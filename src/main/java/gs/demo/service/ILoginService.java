package gs.demo.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import gs.demo.response.ResponseResult;
import gs.demo.ro.LoginRo;
import gs.demo.vo.LoginVo;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/13 16:25
 */
public interface ILoginService {

    /**
     * 生成token
     * @param account 用户
     * @return token
     */
    String getToken(String account);

    /**
     * 令牌验证解码
     */
    DecodedJWT decodedToken(String token);

    /**
     * 登录
     * @param loginRo
     * @return
     */
    ResponseResult<LoginVo> login(LoginRo loginRo);

}
