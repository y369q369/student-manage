package gs.demo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import gs.demo.domain.ExaminationResult;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author gs
 * @since 2023/3/22 11:31
 */
@Data
public class ExaminationResultPageVo extends ExaminationResult {

    @ApiModelProperty("课程")
    @ExcelProperty(value = "课程", order = 2)
    @ColumnWidth(20)
    private String courseName;

    @ApiModelProperty("班级")
    @ExcelProperty(value = "班级", order = 1)
    @ColumnWidth(20)
    private String className;

    @ApiModelProperty("学生")
    @ExcelProperty(value = "学生", order = 3)
    @ColumnWidth(20)
    private String studentName;

}
