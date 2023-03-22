package gs.demo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
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

    @ApiModelProperty("考试时间")
    private LocalDateTime examinationTime;

    @ApiModelProperty("测试名称")
    private String name;

    @ApiModelProperty("分数")
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
