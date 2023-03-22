package gs.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import gs.demo.domain.PieData;
import gs.demo.domain.WorkCompletion;
import gs.demo.ro.WorkPageListRo;
import gs.demo.vo.WorkCompletionPageListVo;

import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/16 09:24
 */
public interface IWorkService extends IService<WorkCompletion> {

    IPage<WorkCompletionPageListVo> getPageList(WorkPageListRo workPageListRo);

    List<PieData> getCompletionLevelPie(WorkPageListRo workPageListRo);

    void batchAdd(List<WorkCompletion> workCompletionList);

}
