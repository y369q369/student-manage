package gs.demo.ro;

import gs.demo.domain.WorkCompletion;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/21 10:24
 */
@Data
public class CommonWorkRo {

    @ApiModelProperty("作业完成情况列表")
    private List<WorkCompletion> workList;

    @ApiModelProperty("作业完成情况id列表")
    private  List<Integer> workIdList;

}
