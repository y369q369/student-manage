package gs.demo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>作业</p>
 *
 * @author gs
 * @since 2023/3/16 09:19
 */
@Data
public class Work {

    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("用户id")
    private Integer user_id;

    @ApiModelProperty("完成情况  0：全部完成  1：完成脚好  2：完成较差  3：未完成")
    private Integer completionLevel;

    @ApiModelProperty("统计日期")
    private LocalDate statisticsTime;

    @ApiModelProperty("创建时间")
    @TableField(exist = false)
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(exist = false)
    private LocalDateTime updateTime;

}
