package gs.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gs.demo.domain.PieData;
import gs.demo.domain.WorkCompletion;
import gs.demo.mapper.WorkMapper;
import gs.demo.ro.WorkPageListRo;
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
public class IWorkServiceImpl extends ServiceImpl<WorkMapper, WorkCompletion> implements IWorkService {

    @Resource
    private WorkMapper workMapper;

    @Override
    public IPage<WorkCompletionPageListVo> getPageList(WorkPageListRo workPageListRo) {
        Page<WorkCompletionPageListVo> page = new Page<>(workPageListRo.getPageNo(), workPageListRo.getPageSize());
        return workMapper.selectPageList(page, workPageListRo);
    }

    @Override
    public List<PieData> getCompletionLevelPie(WorkPageListRo workPageListRo) {
        return workMapper.getCompletionLevelPie(workPageListRo);
    }

    @Override
    public void batchAdd(List<WorkCompletion> workCompletionList) {
        workMapper.batchAdd(workCompletionList);
    }

}
