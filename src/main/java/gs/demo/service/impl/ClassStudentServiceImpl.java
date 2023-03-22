package gs.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gs.demo.domain.ClassStudent;
import gs.demo.domain.User;
import gs.demo.mapper.ClassStudentMapper;
import gs.demo.mapper.UserMapper;
import gs.demo.ro.ClassStudentRo;
import gs.demo.service.IClassStudentService;
import gs.demo.vo.ClassVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/19 09:12
 */
@Service
public class ClassStudentServiceImpl extends ServiceImpl<ClassStudentMapper, ClassStudent> implements IClassStudentService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ClassStudentMapper classStudentMapper;

    @Override
    public IPage<User> getStudentPageList(ClassStudentRo ro) {
        List<ClassStudent> classStudentList = list(Wrappers.<ClassStudent>lambdaQuery().eq(ClassStudent::getClassId, ro.getClassId()));
        Set<Integer> studentIdSet = classStudentList.stream().map(ClassStudent::getStudentId).collect(Collectors.toSet());
        Page<User> page = new Page<>(ro.getPageNo(), ro.getPageSize());
        if (CollUtil.isNotEmpty(studentIdSet)) {
            return userMapper.selectPage(page, Wrappers.<User>lambdaQuery()
                    .in(User::getId, studentIdSet)
                    .like(StrUtil.isNotEmpty(ro.getStudentName()), User::getName, ro.getStudentName()));
        }
        return page;
    }

    @Override
    public void batchOperate(ClassStudentRo ro) {
        List<ClassStudent> classStudentList = list(Wrappers.<ClassStudent>lambdaQuery().eq(ClassStudent::getClassId, ro.getClassId()));
        Set<Integer> studentIdSet = classStudentList.stream().map(ClassStudent::getStudentId).collect(Collectors.toSet());
        // 新增列表
        Set<Integer> addSet = ro.getStudentIdList().stream().filter(item -> !studentIdSet.contains(item)).collect(Collectors.toSet());
        // 删除列表
        Set<Integer> deleteSet = studentIdSet.stream().filter(item -> !ro.getStudentIdList().contains(item)).collect(Collectors.toSet());
        if (CollUtil.isNotEmpty(addSet)) {
            classStudentMapper.batchInsert(ro.getClassId(), addSet);
        }
        if (CollUtil.isNotEmpty(deleteSet)) {
            remove(Wrappers.<ClassStudent>lambdaQuery()
                    .eq(ClassStudent::getClassId, ro.getClassId())
                    .in(ClassStudent::getStudentId, deleteSet));
        }
    }

    @Override
    public List<User> getStudentList(Integer classId) {
        List<ClassStudent> classStudentList = list(Wrappers.<ClassStudent>lambdaQuery().eq(ClassStudent::getClassId, classId));
        Set<Integer> studentIdSet = classStudentList.stream().map(ClassStudent::getStudentId).collect(Collectors.toSet());
        if (CollUtil.isNotEmpty(studentIdSet)) {
            return userMapper.selectList(Wrappers.<User>lambdaQuery().in(User::getId, studentIdSet));
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<User> getOperateStudentList(Integer classId) {
        return classStudentMapper.getOperateStudentList(classId);
    }

}
