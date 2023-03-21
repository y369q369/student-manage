package gs.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gs.demo.domain.WorkCompletion;
import gs.demo.ro.WorkMyPageListRo;
import gs.demo.vo.WorkCompletionPageListVo;

import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/16 09:24
 */
public interface IWorkService {

    IPage<WorkCompletionPageListVo> getPageList(WorkMyPageListRo workPageListRo);

    void add(WorkCompletion workCompletion);

    void batchAdd(List<WorkCompletion> workCompletionList);

    void update(WorkCompletion workCompletion);

    void batchDelete(List<Integer> workIdList);

}
