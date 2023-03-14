package gs.demo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import gs.demo.constants.ApiConstant;
import gs.demo.domain.User;
import gs.demo.response.ResponseResult;
import gs.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/14 21:40
 */
@RestController
@Api( tags = "用户管理" )
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping(value = ApiConstant.USER_INFO)
    @ApiOperation(value = "用户信息", notes = "用户信息")
    public ResponseResult<User> getUserInfo() {
        return userService.getUserInfo();
    }

}
