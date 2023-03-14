package gs.demo.service.impl;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson2.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import gs.demo.constants.ConfigConstant;
import gs.demo.domain.User;
import gs.demo.mapper.UserMapper;
import gs.demo.response.ResponseEnum;
import gs.demo.response.ResponseResult;
import gs.demo.ro.LoginRo;
import gs.demo.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/13 16:26
 */
@Service
@Slf4j
public class LoginServiceImpl implements ILoginService {

    @Resource
    private HttpSession session;

    @Resource
    private UserMapper userMapper;

    @Override
    public String getToken(String account) {
        LocalDateTime expireTime = LocalDateTime.now().plusMinutes(ConfigConstant.TOKEN_EXPIRE);
        Map<String, Object> map = new HashMap<>();
        String token = JWT.create()
                .withHeader(map)                                                //header
                .withClaim("account", account)                            //payload
                .withExpiresAt(expireTime.toInstant(ZoneOffset.of("+8")))       //指定令牌的过期时间
                .sign(Algorithm.HMAC256(ConfigConstant.TOKEN_SALT));            //签名，密钥⾃⼰记住
        log.info(token);
        return token;
    }

    @Override
    public DecodedJWT decodedToken(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(ConfigConstant.TOKEN_SALT)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token); // 验证并获取解码后的
        return decodedJWT;
    }

    public static void main(String[] args) {
        LoginServiceImpl a = new LoginServiceImpl();
        String token = a.getToken("admin");
        DecodedJWT decodedJWT = a.decodedToken(token);
        System.out.println(decodedJWT.getClaim("account").asString());
        System.out.println(decodedJWT.getExpiresAt());
    }


    @Override
    public ResponseResult<JSONObject> login(LoginRo loginRo) {
        String code = (String) session.getAttribute("code");
        if (StrUtil.isBlank(code) || !code.equals(loginRo.getCode())) {
            return ResponseResult.fail(ResponseEnum.USER_NOT_EXIST);
        }
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User :: getAccount, loginRo.getAccount()));
        if (user == null) {
            return ResponseResult.fail(ResponseEnum.USER_NOT_EXIST);
        } else if (!user.getPassword().equals(DigestUtil.md5Hex(loginRo.getPassword()))) {
            return ResponseResult.fail(ResponseEnum.PASSWORD_ERROR);
        }
        session.setAttribute("account", user.getAccount());
        session.setAttribute("user", user);
        String token = getToken(user.getAccount());
        JSONObject result = new JSONObject();
        result.put("token", token);
        return ResponseResult.success(result);
    }

}
