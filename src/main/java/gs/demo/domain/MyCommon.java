package gs.demo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author gs
 * @since 2023/3/23 10:25
 */
@Data
public class MyCommon extends MyPage{

    @ApiModelProperty("操作符标志")
    private Integer operateSymbolMark;

    @ApiModelProperty(value = "操作符号", hidden = true)
    private String operateSymbol;

    public void setOperateSymbolMark(Integer operateSymbolMark) {
        this.operateSymbolMark = operateSymbolMark;
        if (operateSymbolMark != null) {
            // 后期如若从数据库读取，遍历
            switch (operateSymbolMark) {
                case 0:
                    this.operateSymbol = ">";
                    break;
                case 1:
                    this.operateSymbol = ">=";
                    break;
                case 2:
                    this.operateSymbol = "=";
                    break;
                case 3:
                    this.operateSymbol = "<=";
                    break;
                case 4:
                    this.operateSymbol = "<";
                    break;
                case 5:
                    this.operateSymbol = "!=";
                    break;
            }
        }
    }

}
