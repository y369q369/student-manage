package gs.demo.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import gs.demo.excel.ExaminationTypeConvert;
import gs.demo.excel.SexConvert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author gs
 * @since 2023/3/22 11:22
 */
@Data
@ApiModel("考试成绩")
public class ExaminationResult {

    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("班级id")
    private Integer classId;

    @ApiModelProperty("学生id")
    private Integer studentId;

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("考试日期")
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    @JsonFormat( pattern = "yyyy-MM-dd", timezone = "GMT+08:00" )
    @ExcelProperty(value = "考试日期", order = 4)
    @ColumnWidth(20)
    private LocalDate examinationTime;

    @ApiModelProperty("类型")
    @ExcelProperty(value = "类型", converter = ExaminationTypeConvert.class, order = 5)
    @ColumnWidth(20)
    private Integer type;

    @ApiModelProperty("分数")
    @ExcelProperty(value = "分数", order = 6)
    @ColumnWidth(20)
    private BigDecimal score;

    @ApiModelProperty("创建时间")
    @TableField(exist = false)
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00" )
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(exist = false)
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00" )
    private LocalDateTime updateTime;

}
