package gs.demo.vo;

import gs.demo.domain.WorkCompletion;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/16 09:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WorkCompletionPageListVo extends WorkCompletion {

    @ApiModelProperty("班级")
    private String className;

    @ApiModelProperty("学生")
    private String studentName;

}
