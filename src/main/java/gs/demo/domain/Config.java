package gs.demo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>通用配置</p>
 *
 * @author gs
 * @since 2023/3/14 20:56
 */
@Data
public class Config {

    @ApiModelProperty("键")
    private String fieldKey;

    @ApiModelProperty("值")
    private String fieldValue;

    @ApiModelProperty("说明")
    private String instruction;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

}
