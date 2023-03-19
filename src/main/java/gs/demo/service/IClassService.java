package gs.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gs.demo.domain.SchoolClass;
import gs.demo.domain.User;
import gs.demo.ro.ClassRo;
import gs.demo.vo.ClassVo;

import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/18 20:57
 */
public interface IClassService{

    IPage<ClassVo> getClassPageList(ClassRo classRo);

    void addClass(SchoolClass schoolClass);

    SchoolClass getClassDetail(Integer classId);

    void updateClass(SchoolClass schoolClass);

    void deleteClass(Integer classId);

    List<User> getClassTeacherList(Integer classId);

}
