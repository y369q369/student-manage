package gs.demo.vo;

import gs.demo.domain.Work;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/16 09:40
 */
@Data
public class WorkPageListVo extends Work {

    @ApiModelProperty("用户名")
    private String userName;

}
