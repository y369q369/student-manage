package gs.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gs.demo.constants.ConfigConstant;
import gs.demo.domain.MyPage;
import gs.demo.domain.User;
import gs.demo.exception.OperationException;
import gs.demo.mapper.UserMapper;
import gs.demo.response.ResponseResult;
import gs.demo.service.IUserService;
import gs.demo.utils.ExcelUtil;
import gs.demo.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/13 16:25
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService  {

    @Resource
    private HttpSession session;

    @Resource
    private HttpServletResponse rep;

    @Override
    public ResponseResult<User> getUserInfo() {
        User user = (User) session.getAttribute("user");
        return ResponseResult.success(user);
    }

    @Override
    public IPage<User> getUserPageList(User user, MyPage myPage) {
        Page<User> page = new Page<>(myPage.getPageNo(), myPage.getPageSize());
        Wrapper<User> queryWrapper = Wrappers.<User>lambdaQuery()
                .like(StrUtil.isNotEmpty(user.getName()), User::getName, user.getName())
                .eq(user.getIdentity() != null, User::getIdentity, user.getIdentity());
        return page(page, queryWrapper);
    }

    @Override
    public ResponseResult<User> getUserDetail(Integer userId) {
        return ResponseResult.success(getById(userId));
    }

    @Override
    @Transactional
    public void batchAddUser(List<User> userList) {
        if (CollUtil.isEmpty(userList)) {
            throw new OperationException("用户列表为空");
        } else {
            List<String> accountList = new ArrayList<>();
            userList.forEach(item -> {
                if (StrUtil.isBlank(item.getName()) || StrUtil.isBlank(item.getAccount()) || StrUtil.isBlank(item.getPassword())) {
                    throw new OperationException("用户列表数据存在异常");
                } else {
                    item.setPassword(DigestUtil.md5Hex(item.getPassword()));
                    accountList.add(item.getAccount());
                }
            });
            List<User> existUserList = list(Wrappers.<User>lambdaQuery().in(User::getAccount, accountList));
            if (CollUtil.isNotEmpty(existUserList)) {
                Set<String> existAccountList = existUserList.stream().map(User::getAccount).collect(Collectors.toSet());
                throw new OperationException(existAccountList + "已存在");
            }
            saveBatch(userList);
        }
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        updateById(user);
    }

    @Override
    public void resetPwd(Integer userId) {
        String pwd = DigestUtil.md5Hex(ConfigConstant.DEFAULT_PWD);
        update(Wrappers.<User>lambdaUpdate().set(User::getPassword, pwd).eq(User::getId, userId));
    }

    @Override
    @Transactional
    public void delete(Integer userId) {
        removeById(userId);
    }

    @Override
    @Transactional
    public void batchDelete(List<Integer> userIdList) {
        removeBatchByIds(userIdList);
    }

    @Override
    @Transactional
    public void importUser(MultipartFile file) {
        try {
            List<User> userList = new ArrayList<>();
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, UserVo.class, new PageReadListener<UserVo>(dataList -> {
                for (User user : dataList) {
                    user.setPassword(DigestUtil.md5Hex(ConfigConstant.DEFAULT_PWD));
                    userList.add(user);
                }
            })).sheet().doRead();
            saveBatch(userList);
        } catch (Exception e) {
            throw new OperationException("【导入异常】" + e.getMessage());
        }
    }

    @Override
    public void exportUser(User user) {
        Wrapper<User> queryWrapper = Wrappers.<User>lambdaQuery()
                .like(StrUtil.isNotEmpty(user.getName()), User::getName, user.getName())
                .eq(user.getIdentity() != null, User::getIdentity, user.getIdentity());
        List<User> userList = list(queryWrapper);
        ExcelUtil.webExport(userList, User.class, "sheet1", "用户列表", rep);
    }

}
