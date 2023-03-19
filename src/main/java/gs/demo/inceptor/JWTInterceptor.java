package gs.demo.inceptor;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import gs.demo.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/14 21:21
 */
@Slf4j
@Component
public class JWTInterceptor implements HandlerInterceptor {

    @Resource
    private ILoginService iLoginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //获取请求头中的令牌
//        String authorization = request.getHeader("Authorization");
//        if (StrUtil.isBlank(authorization) || !authorization.startsWith("Bearer ")) {
//            String uri = request.getRequestURI();
//            log.error("{} 访问认证异常", uri);
//            return false;
//        }
//        String token = authorization.replace("Bearer ", "");
//        log.info("当前token为：{}", token);
//        DecodedJWT decodedJWT = iLoginService.decodedToken(token);
//        // 账号
//        String account = (String) request.getSession().getAttribute("account");
//        String decodeAccount = decodedJWT.getClaim("account").asString();
//        if (StrUtil.isBlank(account) || !account.equals(decodeAccount)) {
//            log.error("解密用户异常");
//            return false;
//        }
//        // 过期时间
//        LocalDateTime expireTime = LocalDateTimeUtil.of(decodedJWT.getExpiresAtAsInstant());
//        return expireTime.isAfter(LocalDateTime.now());
        return true;
    }

}
