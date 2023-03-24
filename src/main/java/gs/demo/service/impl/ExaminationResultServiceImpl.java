package gs.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gs.demo.constants.ConfigConstant;
import gs.demo.domain.ExaminationResult;
import gs.demo.domain.PieData;
import gs.demo.domain.User;
import gs.demo.exception.OperationException;
import gs.demo.mapper.ExaminationResultMapper;
import gs.demo.ro.ExaminationResultPageListRo;
import gs.demo.ro.WorkPageListRo;
import gs.demo.service.IExaminationResultService;
import gs.demo.utils.ExcelUtil;
import gs.demo.vo.ExaminationResultPageVo;
import gs.demo.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gs
 * @since 2023/3/22 11:28
 */
@Service
public class ExaminationResultServiceImpl extends ServiceImpl<ExaminationResultMapper, ExaminationResult> implements IExaminationResultService {

    @Resource
    private HttpServletResponse rep;

    @Resource
    private ExaminationResultMapper examinationResultMapper;

    @Override
    public IPage<ExaminationResultPageVo> getPageList(ExaminationResultPageListRo listRo) {
        Page<ExaminationResultPageVo> page = new Page<>(listRo.getPageNo(), listRo.getPageSize());
        return examinationResultMapper.getPageList(page, listRo);
    }

    @Override
    public List<PieData> getScorePie(ExaminationResultPageListRo param) {
        return examinationResultMapper.getScorePie(param);
    }

    @Override
    public void batchAdd(List<ExaminationResult> dataList) {
        List<ExaminationResult> targetList = dataList.stream().filter(item -> item.getScore() != null).collect(Collectors.toList());
        examinationResultMapper.batchAdd(targetList);
    }

    @Override
    public void importData(MultipartFile file) {
        try {
            List<ExaminationResult> targetList = new ArrayList<>();
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, ExaminationResultPageVo.class, new PageReadListener<ExaminationResultPageVo>(dataList -> {
                for (ExaminationResultPageVo item : dataList) {
                    ExaminationResult examinationResult = BeanUtil.copyProperties(item, ExaminationResult.class);
                    targetList.add(examinationResult);
                }
            })).sheet().doRead();
            saveBatch(targetList);
        } catch (Exception e) {
            throw new OperationException("【导入异常】" + e.getMessage());
        }
    }

    @Override
    public void exportData(ExaminationResultPageListRo listRo) {
        Page<ExaminationResultPageVo> page = new Page<>(1, ConfigConstant.EXPORT_MAX_NUM);
        IPage<ExaminationResultPageVo> pageList = examinationResultMapper.getPageList(page, listRo);
        if (CollUtil.isNotEmpty(pageList.getRecords())) {
            ExcelUtil.webExport(pageList.getRecords(), ExaminationResultPageListRo.class, "sheet1", "考试成绩", rep);
        }
    }

}
