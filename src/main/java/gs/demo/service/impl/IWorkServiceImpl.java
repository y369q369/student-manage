package gs.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gs.demo.domain.Work;
import gs.demo.mapper.WorkMapper;
import gs.demo.ro.WorkMyPageListRo;
import gs.demo.service.IWorkService;
import gs.demo.vo.WorkPageListVo;
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
    public IPage<WorkPageListVo> getPageList(WorkMyPageListRo workPageListRo) {
        Page<WorkPageListVo> page = new Page<>(workPageListRo.getPageNo(), workPageListRo.getPageSize());
        IPage<WorkPageListVo> pageListVoIPage = workMapper.selectPageList(page, workPageListRo);
        return pageListVoIPage;
    }

    @Override
    public void add(Work work) {
        workMapper.insert(work);
    }

    @Override
    public void batchAdd(List<Work> workList) {
        workMapper.batchAdd(workList);
    }

    @Override
    public void update(Work work) {
        workMapper.updateById(work);
    }

    @Override
    public void batchDelete(List<Integer> workIdList) {
        workMapper.deleteBatchIds(workIdList);
    }
}
