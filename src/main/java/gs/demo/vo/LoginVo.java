package gs.demo.vo;

import gs.demo.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author gs
 * @since 2023/3/23 16:22
 */
@Data
public class LoginVo {

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("用户")
    private User user;

}
