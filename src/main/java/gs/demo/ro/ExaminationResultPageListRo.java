package gs.demo.ro;

import com.fasterxml.jackson.annotation.JsonFormat;
import gs.demo.domain.MyCommon;
import gs.demo.domain.MyPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author gs
 * @since 2023/3/22 11:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExaminationResultPageListRo extends MyCommon {

    @ApiModelProperty("班级")
    private Integer classId;

    @ApiModelProperty("课程")
    private Integer courseId;

    @ApiModelProperty("学生")
    private String studentName;

    @ApiModelProperty("考试分数")
    private BigDecimal score;

    @ApiModelProperty("类型")
    private List<Integer> typeList;

    @ApiModelProperty("考试开始日期")
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    @JsonFormat( pattern = "yyyy-MM-dd", timezone = "GMT+08:00" )
    private LocalDate examinationTimeSt;

    @ApiModelProperty("考试结束日期")
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    @JsonFormat( pattern = "yyyy-MM-dd", timezone = "GMT+08:00" )
    private LocalDate examinationTimeEt;

}
