package gs.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author gs
 * @since 2023/3/24 14:55
 */
@Data
@ApiModel("系统字典实际项")
public class SysDictItem {

    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("字典id")
    private Integer dictId;

    @ApiModelProperty("字典项文本")
    private String itemText;

    @ApiModelProperty("字典项值")
    private String itemValue;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("排序")
    private Integer sortOrder;

    @ApiModelProperty("状态（1启用 0不启用）")
    private Integer status;

}
