package gs.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author gs
 * @since 2023/3/24 14:59
 */
@Data
@ApiModel("系统字典")
public class SysDict {

    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("字典名称")
    private String dictName;

    @ApiModelProperty("字典编码")
    private String dictCode;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("删除状态 0:未删除 1:已删除")
    private Integer delFlag;

    @ApiModelProperty("字典类型0为string,1为number")
    private Integer type;

}
