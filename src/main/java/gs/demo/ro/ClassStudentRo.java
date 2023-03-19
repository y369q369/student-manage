package gs.demo.ro;

import gs.demo.domain.MyPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/19 09:10
 */
@Data
public class ClassStudentRo extends MyPage {

    @ApiModelProperty("班级唯一id")
    private String classId;

    @ApiModelProperty("学生名称")
    private String studentName;

    @ApiModelProperty("更新学生列表")
    private List<Integer> studentIdList;

}
