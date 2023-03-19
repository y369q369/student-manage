package gs.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gs.demo.domain.Work;
import gs.demo.ro.WorkMyPageListRo;
import gs.demo.vo.WorkPageListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/16 09:25
 */
public interface WorkMapper extends BaseMapper<Work> {

    IPage<WorkPageListVo> selectPageList(@Param("page") Page<WorkPageListVo> page, @Param("param") WorkMyPageListRo param);

    void batchAdd(@Param("list") List<Work> list);

}
