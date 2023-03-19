package gs.demo.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import gs.demo.excel.IdentityConvert;
import gs.demo.excel.SexConvert;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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
    @ExcelIgnore
    private Integer id;

    @ApiModelProperty("登录账号")
    @ExcelProperty(value = "登录账号", order = 2)
    @ColumnWidth(20)
    private String account;

    @ApiModelProperty("姓名")
    @ExcelProperty(value = "名称", order = 1)
    @ColumnWidth(20)
    private String name;

    @ApiModelProperty("身份 0:学生 1:教师")
    @ExcelProperty(value = "身份", converter = IdentityConvert.class, order = 3)
    @ColumnWidth(20)
    private Integer identity;

    @ApiModelProperty("密码")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ExcelIgnore
    private String password;

    @ApiModelProperty("性别 0: 女  1: 男 ")
    @ExcelProperty(value = "性别", converter = SexConvert.class, order = 4)
    @ColumnWidth(20)
    private Integer sex;

    @ApiModelProperty("出生日期")
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    @JsonFormat( pattern = "yyyy-MM-dd", timezone = "GMT+08:00" )
    @ExcelProperty(value = "出生日期", order = 5)
    @ColumnWidth(20)
    private LocalDate birthDay;

    @ApiModelProperty("联系方式")
    @ExcelProperty(value = "联系方式", order = 6)
    @ColumnWidth(20)
    private String phone;


}
