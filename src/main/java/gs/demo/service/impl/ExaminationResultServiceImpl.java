package gs.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gs.demo.domain.ExaminationResult;
import gs.demo.domain.PieData;
import gs.demo.mapper.ExaminationResultMapper;
import gs.demo.ro.ExaminationResultPageListRo;
import gs.demo.ro.WorkPageListRo;
import gs.demo.service.IExaminationResultService;
import gs.demo.vo.ExaminationResultPageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gs
 * @since 2023/3/22 11:28
 */
@Service
public class ExaminationResultServiceImpl extends ServiceImpl<ExaminationResultMapper, ExaminationResult> implements IExaminationResultService {

    @Resource
    private ExaminationResultMapper examinationResultMapper;

    @Override
    public IPage<ExaminationResultPageVo> getPageList(ExaminationResultPageListRo listRo) {
        Page<ExaminationResultPageVo> page = new Page<>(listRo.getPageNo(), listRo.getPageSize());
        return examinationResultMapper.getPageList(page, listRo);
    }

    @Override
    public List<PieData> getScorePie(WorkPageListRo param) {
        return examinationResultMapper.getScorePie(param);
    }

    @Override
    public void batchAdd(List<ExaminationResult> dataList) {
        examinationResultMapper.batchAdd(dataList);
    }

}
