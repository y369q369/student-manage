package gs.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gs.demo.domain.Course;
import gs.demo.mapper.CourseMapper;
import gs.demo.service.ICourseService;
import org.springframework.stereotype.Service;

/**
 * @author gs
 * @since 2023/3/22 22:21
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
}
