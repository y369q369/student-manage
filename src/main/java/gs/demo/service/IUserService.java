package gs.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import gs.demo.domain.User;
import gs.demo.response.ResponseResult;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/13 16:25
 */
public interface IUserService extends IService<User> {

    ResponseResult<User> getUserInfo();

}
