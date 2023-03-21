package gs.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gs.demo.domain.WorkCompletion;
import gs.demo.mapper.WorkMapper;
import gs.demo.ro.WorkMyPageListRo;
import gs.demo.service.IWorkService;
import gs.demo.vo.WorkCompletionPageListVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/16 09:24
 */
@Service
public class IWorkServiceImpl implements IWorkService {

    @Resource
    private WorkMapper workMapper;

    @Override
    public IPage<WorkCompletionPageListVo> getPageList(WorkMyPageListRo workPageListRo) {
        Page<WorkCompletionPageListVo> page = new Page<>(workPageListRo.getPageNo(), workPageListRo.getPageSize());
        return workMapper.selectPageList(page, workPageListRo);
    }

    @Override
    public void add(WorkCompletion workCompletion) {
        workMapper.insert(workCompletion);
    }

    @Override
    public void batchAdd(List<WorkCompletion> workCompletionList) {
        workMapper.batchAdd(workCompletionList);
    }

    @Override
    public void update(WorkCompletion workCompletion) {
        workMapper.updateById(workCompletion);
    }

    @Override
    public void batchDelete(List<Integer> workIdList) {
        workMapper.deleteBatchIds(workIdList);
    }
}
