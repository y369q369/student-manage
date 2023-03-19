package gs.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gs.demo.domain.ClassStudent;
import gs.demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/18 20:56
 */
public interface ClassStudentMapper extends BaseMapper<ClassStudent> {

    void batchInsert(@Param("classId") String classId, @Param("col") Set<Integer> col);

    List<User> getOperateStudentList(@Param("classId") Integer classId);

}
