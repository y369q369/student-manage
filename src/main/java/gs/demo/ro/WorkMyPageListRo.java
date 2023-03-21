package gs.demo.ro;

import com.fasterxml.jackson.annotation.JsonFormat;
import gs.demo.domain.MyPage;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * <p>作业分页列表</p>
 *
 * @author gs
 * @since 2023/3/16 09:37
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WorkMyPageListRo extends MyPage {

    @ApiModelProperty("班级")
    private Integer classId;

    @ApiModelProperty("学生")
    private String studentName;

    @ApiModelProperty("完成情况  0：全部完成  1：完成较好  2：完成较差  3：未完成")
    private Integer completionLevel;

    @ApiModelProperty("统计开始日期")
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    @JsonFormat( pattern = "yyyy-MM-dd", timezone = "GMT+08:00" )
    private LocalDate statisticsTimeSt;

    @ApiModelProperty("统计结束日期")
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    @JsonFormat( pattern = "yyyy-MM-dd", timezone = "GMT+08:00" )
    private LocalDate statisticsTimeEt;

}
