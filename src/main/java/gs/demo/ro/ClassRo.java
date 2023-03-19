package gs.demo.ro;

import gs.demo.domain.MyPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/18 21:00
 */
@Data
public class ClassRo extends MyPage {

    @ApiModelProperty("班级名称")
    private String name;

    @ApiModelProperty("班主任")
    private String classTeacherName;

}
