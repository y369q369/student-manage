package gs.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import gs.demo.domain.ClassStudent;
import gs.demo.domain.User;
import gs.demo.ro.ClassStudentRo;

import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/19 09:11
 */
public interface IClassStudentService extends IService<ClassStudent> {

    IPage<User> getStudentPageList(ClassStudentRo classStudentRo);

    void batchOperate(ClassStudentRo classStudentRo);

    List<User> getStudentList(Integer classId);

    List<User> getOperateStudentList(Integer classId);

    void batchDeleteStudent(ClassStudentRo classStudentRo);
}
