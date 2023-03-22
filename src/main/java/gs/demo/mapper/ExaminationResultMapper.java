package gs.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gs.demo.domain.ExaminationResult;
import gs.demo.domain.PieData;
import gs.demo.ro.ExaminationResultPageListRo;
import gs.demo.ro.WorkPageListRo;
import gs.demo.vo.ExaminationResultPageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/22 11:28
 */
public interface ExaminationResultMapper extends BaseMapper<ExaminationResult> {

    IPage<ExaminationResultPageVo> getPageList(@Param("page") Page<ExaminationResultPageVo> page, @Param("param") ExaminationResultPageListRo param);

    List<PieData> getScorePie(@Param("param") WorkPageListRo param);

    void batchAdd(@Param("list") List<ExaminationResult> list);

}
