package gs.demo.vo;

import gs.demo.domain.SchoolClass;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/18 21:17
 */
@Data
public class ClassVo extends SchoolClass {

    @ApiModelProperty("班主任名称")
    private String classTeacherName;

}
