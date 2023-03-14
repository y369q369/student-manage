package gs.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gs.demo.domain.User;
import gs.demo.mapper.UserMapper;
import gs.demo.response.ResponseResult;
import gs.demo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/13 16:25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService  {

    @Resource
    private HttpSession session;

    @Override
    public ResponseResult<User> getUserInfo() {
        User user = (User) session.getAttribute("user");
        return ResponseResult.success(user);
    }

}
