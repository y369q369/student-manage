package gs.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import gs.demo.domain.MyPage;
import gs.demo.domain.User;
import gs.demo.response.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/13 16:25
 */
public interface IUserService extends IService<User> {

    ResponseResult<User> getUserInfo();

    IPage<User> getUserPageList(User user, MyPage myPage);

    ResponseResult<User> getUserDetail(Integer userId);

    void batchAddUser(List<User> userList);

    void resetPwd(Integer userId);

    void importUser(MultipartFile file);

    void exportUser(User user);

}
