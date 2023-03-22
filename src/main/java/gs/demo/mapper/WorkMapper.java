package gs.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gs.demo.domain.PieData;
import gs.demo.domain.WorkCompletion;
import gs.demo.ro.WorkPageListRo;
import gs.demo.vo.WorkCompletionPageListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/16 09:25
 */
public interface WorkMapper extends BaseMapper<WorkCompletion> {

    IPage<WorkCompletionPageListVo> selectPageList(@Param("page") Page<WorkCompletionPageListVo> page, @Param("param") WorkPageListRo param);

    List<PieData> getCompletionLevelPie(@Param("param") WorkPageListRo workPageListRo);

    void batchAdd(@Param("list") List<WorkCompletion> list);

}
