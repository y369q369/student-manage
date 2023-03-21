package gs.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gs.demo.constants.IdentityEnum;
import gs.demo.domain.ClassStudent;
import gs.demo.domain.SchoolClass;
import gs.demo.domain.User;
import gs.demo.mapper.ClassMapper;
import gs.demo.mapper.ClassStudentMapper;
import gs.demo.mapper.UserMapper;
import gs.demo.ro.ClassRo;
import gs.demo.service.IClassService;
import gs.demo.vo.ClassVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/18 20:58
 */
@Service
public class ClassServiceImpl implements IClassService {

    @Resource
    private ClassMapper classMapper;

    @Resource
    private ClassStudentMapper classStudentMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<ClassVo> getClassPageList(ClassRo classRo) {
        Page<ClassVo> page = new Page<>(classRo.getPageNo(), classRo.getPageSize());
        return classMapper.getClassPageList(page, classRo);
    }

    @Override
    public void addClass(SchoolClass schoolClass) {
        classMapper.insert(schoolClass);
    }

    @Override
    public SchoolClass getClassDetail(Integer classId) {
        return classMapper.selectById(classId);
    }

    @Override
    public void updateClass(SchoolClass schoolClass) {
        classMapper.updateById(schoolClass);
    }

    @Override
    @Transactional
    public void deleteClass(Integer classId) {
        SchoolClass schoolClass = classMapper.selectById(classId);
        if (schoolClass != null) {
            classMapper.deleteById(classId);
            classStudentMapper.delete(Wrappers.<ClassStudent>lambdaQuery().eq(ClassStudent::getClassId, classId));
        }
    }

    @Override
    public List<User> getClassTeacherList(Integer classId) {
        List<SchoolClass> schoolClassList = classMapper.selectList(Wrappers.<SchoolClass>lambdaQuery()
                .ne(classId != null, SchoolClass::getId, classId));
        Set<Integer> teacherIdSet = schoolClassList.stream().map(SchoolClass::getClassTeacherId).collect(Collectors.toSet());
        return userMapper.selectList(Wrappers.<User>lambdaQuery()
                .eq(User::getIdentity, IdentityEnum.TEACHER.getCode())
                .notIn(CollUtil.isNotEmpty(teacherIdSet), User::getId, teacherIdSet));

    }

    @Override
    public List<SchoolClass> getClassList() {
        return classMapper.selectList(null);
    }

}
