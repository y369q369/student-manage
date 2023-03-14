package gs.demo.ro;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/14 15:00
 */
@Data
public class LoginRo {

    @ApiModelProperty("登录账号")
    @NotEmpty(message = "登录账号不能为空")
    private String account;

    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty("验证码")
    @NotEmpty(message = "验证码不能为空")
    private String code;

}
