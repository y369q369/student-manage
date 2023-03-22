package gs.demo.ro;

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
public class CommonRo<T> {

    @ApiModelProperty("对象列表")
    private List<T> dataList;

    @ApiModelProperty("对象主键id")
    private Integer id;

    @ApiModelProperty("对象主键id列表")
    private  List<Integer> idList;

}
