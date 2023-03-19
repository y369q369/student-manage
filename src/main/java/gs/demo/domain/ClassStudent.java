package gs.demo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/18 20:52
 */
@Data
public class ClassStudent {

    @ApiModelProperty("班级id")
    private Integer classId;

    @ApiModelProperty("学生id")
    private Integer studentId;

}
