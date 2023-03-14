package gs.demo.config;

import gs.demo.constants.ApiConstant;
import gs.demo.inceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/14 21:24
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Resource
    private JWTInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .excludePathPatterns("/**/" + ApiConstant.LOGIN_CODE, "/**/" + ApiConstant.USER_LOGIN);
    }

}
