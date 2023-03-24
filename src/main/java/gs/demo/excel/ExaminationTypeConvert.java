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
 * <p>性别转换</p>
 *
 * @author gs
 * @since 2023/3/19 21:29
 */
public class ExaminationTypeConvert implements Converter<Integer> {

    public static final Map<String, Integer> IMPORT = new HashMap(){{
        put("期中考试", 0);
        put("期末考试", 1);
        put("月考", 2);
        put("周考", 3);
        put("日考", 4);
        put("测验", 5);
    }};

    public static final Map<Integer, String> EXPORT = new HashMap(){{
        put(0, "期中考试");
        put(1, "期末考试");
        put(2, "月考");
        put(3, "周考");
        put(4, "日考");
        put(5, "测验");
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
