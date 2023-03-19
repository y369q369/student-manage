package gs.demo.ro;

import gs.demo.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/18 14:17
 */
@Data
public class CommonUserRo {

    @ApiModelProperty("用户列表")
    private List<User> userList;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("用户id列表")
    private List<Integer> userIdList;

}
