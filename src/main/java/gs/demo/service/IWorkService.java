package gs.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gs.demo.domain.Work;
import gs.demo.ro.WorkMyPageListRo;
import gs.demo.vo.WorkPageListVo;

import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/16 09:24
 */
public interface IWorkService {

    IPage<WorkPageListVo> getPageList(WorkMyPageListRo workPageListRo);

    void add(Work work);

    void batchAdd(List<Work> workList);

    void update(Work work);

    void batchDelete(List<Integer> workIdList);

}
