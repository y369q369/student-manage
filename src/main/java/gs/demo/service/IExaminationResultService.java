package gs.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import gs.demo.domain.ExaminationResult;
import gs.demo.domain.PieData;
import gs.demo.ro.ExaminationResultPageListRo;
import gs.demo.ro.WorkPageListRo;
import gs.demo.vo.ExaminationResultPageVo;

import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/22 11:28
 */
public interface IExaminationResultService extends IService<ExaminationResult> {

    IPage<ExaminationResultPageVo> getPageList(ExaminationResultPageListRo listRo);

    List<PieData> getScorePie(WorkPageListRo workPageListRo);

    void batchAdd(List<ExaminationResult> dataList);

}
