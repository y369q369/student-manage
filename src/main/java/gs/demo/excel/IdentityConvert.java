package gs.demo.excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>身份转换</p>
 *
 * @author gs
 * @since 2023/3/19 21:29
 */
public class IdentityConvert implements Converter<Integer> {

    public static final Map<String, Integer> IMPORT = new HashMap(){{
        put("学生", 0);
        put("教师", 1);
    }};

    public static final Map<Integer, String> EXPORT = new HashMap(){{
        put(0, "学生");
        put(1, "教师");
    }};

    @Override
    public Class<?> supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Integer convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return IMPORT.get(cellData.getStringValue());
    }

    @Override
    public WriteCellData<String> convertToExcelData(Integer value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new WriteCellData(EXPORT.get(value));
    }

}
