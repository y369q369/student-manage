package gs.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author gs
 * @since 2023/3/24 15:32
 */
@Data
@ApiModel("字典类型")
public class DictVo {

    @ApiModelProperty("标签")
    private String label;

    @ApiModelProperty("值")
    private Object value;

}
