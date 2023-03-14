package gs.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/14 16:17
 */
@Data
public class User {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("登录账号")
    private String account;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("身份 0:教师 1:学生")
    private Integer identity;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("性别 0: 女  1: 男 ")
    private Integer sex;

    @ApiModelProperty("出生日期")
    private LocalDateTime birthDay;

    @ApiModelProperty("联系方式")
    private String phone;


}
