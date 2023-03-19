package gs.demo.ro;

import gs.demo.domain.MyPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * <p>作业分页列表</p>
 *
 * @author gs
 * @since 2023/3/16 09:37
 */
@Data
public class WorkMyPageListRo extends MyPage {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("完成情况  0：全部完成  1：完成较好  2：完成较差  3：未完成")
    private Integer completionLevel;

    @ApiModelProperty("统计开始日期")
    private LocalDate statisticsTimeSt;

    @ApiModelProperty("统计结束日期")
    private LocalDate statisticsTimeEt;

}
