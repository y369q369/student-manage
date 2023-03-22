package gs.demo.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/22 11:15
 */
@ApiModel("课程")
@Data
public class Course {

    @ApiModelProperty("唯一标志")
    @TableId
    private int id;

    @ApiModelProperty("名称")
    private String name;

}
