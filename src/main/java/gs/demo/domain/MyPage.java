package gs.demo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>页码</p>
 *
 * @author gs
 * @since 2023/3/16 09:35
 */
@Data
public class MyPage {

    @ApiModelProperty("查询页")
    private Integer pageNo = 1;

    @ApiModelProperty("每页展示数量")
    private Integer pageSize = 10;

}
