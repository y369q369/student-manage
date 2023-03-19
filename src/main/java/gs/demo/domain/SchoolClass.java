package gs.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/18 20:50
 */
@Data
@TableName("class")
public class SchoolClass {

    @ApiModelProperty("唯一id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("班级名称")
    private String name;

    @ApiModelProperty("班主任id")
    private Integer classTeacherId;

    @ApiModelProperty("班级标语")
    private String slogan;

}
