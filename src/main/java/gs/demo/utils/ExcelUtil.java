package gs.demo.utils;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collection;

/**
 * easyExcel操作工具类
 * @author gs
 * @since  2021-10-27 11:00
 */
@Slf4j
public class ExcelUtil {

    /**
     * web 导出
     * @param data 数据内容
     * @param clazz 数据实体对象
     * @param sheetName 表格空间名
     * @param fileName 文件名
     * @param rep 响应体
     */
    public static void webExport(Collection<?> data, Class<?> clazz, String sheetName, String fileName, HttpServletResponse rep) {
        try {
            rep.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            rep.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码
            fileName = URLEncoder.encode(fileName, "UTF-8");
            rep.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            EasyExcel.write(rep.getOutputStream(), clazz)
                    .sheet(sheetName)
                    .doWrite(data);
        } catch (IOException e) {
            // 重置response
            rep.reset();
            log.error("【web表格导出】{} 导出失败 ", fileName, e);
        }
    }

    /**
     * 文件 导出
     * @param data 数据内容
     * @param clazz 数据实体对象
     * @param directory 存储目录
     * @param fileName 文件名
     * @param sheetName 表格空间名
     */
    public static void fileExport(Collection<?> data, Class<?> clazz, String directory, String fileName, String sheetName) {
        String pathName = directory + "/" + fileName + ".xlsx";
        EasyExcel.write(pathName, clazz).sheet(sheetName).doWrite(data);
    }

}
