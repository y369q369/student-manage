package gs.demo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.alibaba.fastjson2.JSONObject;
import gs.demo.constants.ApiConstant;
import gs.demo.response.ResponseResult;
import gs.demo.ro.LoginRo;
import gs.demo.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * <p>登录</p>
 *
 * @author gs
 * @since 2023/3/13 16:24
 */
@RestController
@Api( tags = "登录" )
public class LoginController {

    @Resource
    private ILoginService loginService;

    @Resource
    private HttpSession session;

    @GetMapping(value = ApiConstant.LOGIN_CODE)
    @ApiOperation(value = "获取验证码", notes = "获取验证码")
    public ResponseResult<String> getCode() {
        // 利用 hutool 工具，生成验证码图片资源
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 5);
        // 获得生成的验证码字符
        String code = captcha.getCode();
        // 利用 session 来存储验证码
        session.setAttribute("code",code);
        return ResponseResult.success(captcha.getImageBase64Data());
    }

    @PostMapping(value = ApiConstant.USER_LOGIN)
    @ApiOperation(value = "登录", notes = "登录")
    public ResponseResult<JSONObject> login(@Valid @RequestBody LoginRo loginRo) {
        return loginService.login(loginRo);
    }


}
