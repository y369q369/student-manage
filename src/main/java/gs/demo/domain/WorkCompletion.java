package gs.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>作业</p>
 *
 * @author gs
 * @since 2023/3/16 09:19
 */
@Data
public class WorkCompletion {

    @ApiModelProperty("唯一id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("学生id")
    private Integer studentId;

    @ApiModelProperty("班级id")
    private Integer classId;

    @ApiModelProperty("完成情况  0：全部完成  1：完成较好  2：完成较差  3：未完成")
    private Integer completionLevel;

    @ApiModelProperty("统计日期")
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    @JsonFormat( pattern = "yyyy-MM-dd", timezone = "GMT+08:00" )
    private LocalDate statisticsTime;

    @ApiModelProperty("创建时间")
    @TableField(exist = false)
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00" )
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(exist = false)
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00" )
    private LocalDateTime updateTime;

}
