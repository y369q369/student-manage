package gs.demo.controller;

import gs.demo.constants.ApiConstant;
import gs.demo.domain.Course;
import gs.demo.response.ResponseResult;
import gs.demo.service.ICourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gs
 * @since 2023/3/22 22:18
 */
@RestController
@Api( tags = "课程" )
@RequestMapping("course")
public class CourseController {

    @Resource
    private ICourseService courseService;

    @GetMapping(value = ApiConstant.LIST)
    @ApiOperation(value = "课程列表", notes = "课程列表")
    public ResponseResult<List<Course>> getCourseList() {
        List<Course> list = courseService.list();
        return ResponseResult.success(list);
    }

}
