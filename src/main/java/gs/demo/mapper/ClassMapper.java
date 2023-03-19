package gs.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gs.demo.domain.SchoolClass;
import gs.demo.ro.ClassRo;
import gs.demo.vo.ClassVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/18 20:54
 */
public interface ClassMapper extends BaseMapper<SchoolClass> {

    IPage<ClassVo> getClassPageList(Page<ClassVo> page, @Param("param") ClassRo param);

}
