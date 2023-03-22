package gs.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/22 09:12
 */
@ApiModel("饼图数据")
@Data
public class PieData {

    @ApiModelProperty("标题唯一标志")
    private String id;

    @ApiModelProperty("标题")
    private String name;

    @ApiModelProperty("数值")
    private BigDecimal value;

}
