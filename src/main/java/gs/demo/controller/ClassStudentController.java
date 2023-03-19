package gs.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gs.demo.constants.ApiConstant;
import gs.demo.domain.User;
import gs.demo.response.ResponseResult;
import gs.demo.ro.ClassRo;
import gs.demo.ro.ClassStudentRo;
import gs.demo.service.IClassStudentService;
import gs.demo.vo.ClassVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/19 09:08
 */
@RestController
@Api( tags = "班级 - 学生 关系" )
public class ClassStudentController {

    @Resource
    private IClassStudentService classStudentService;

    @GetMapping(value = ApiConstant.CLASS_STUDENT_PAGE_LIST)
    @ApiOperation(value = "学生分页列表", notes = "学生分页列表")
    public ResponseResult<IPage<User>> getStudentPageList(ClassStudentRo classStudentRo) {
        IPage<User> userPageList = classStudentService.getStudentPageList(classStudentRo);
        return ResponseResult.success(userPageList);
    }

    @PostMapping(value = ApiConstant.CLASS_STUDENT_BATCH_OPERATE)
    @ApiOperation(value = "批量操作", notes = "批量操作")
    public ResponseResult<String> batchOperate(@RequestBody ClassStudentRo classStudentRo) {
        classStudentService.batchOperate(classStudentRo);
        return ResponseResult.success("班级 - 学生 维护完成");
    }

    @GetMapping(value = ApiConstant.CLASS_STUDENT_LIST)
    @ApiOperation(value = "学生列表", notes = "学生列表")
    public ResponseResult<List<User>> getStudentList(@RequestParam(value = "classId") Integer classId) {
        List<User> studentList = classStudentService.getStudentList(classId);
        return ResponseResult.success(studentList);
    }

    @GetMapping(value = ApiConstant.CLASS_STUDENT_OPERATE_STUDENT_LIST)
    @ApiOperation(value = "未绑定学生列表", notes = "未绑定学生列表")
    public ResponseResult<List<User>> getOperateStudentList(@RequestParam(value = "classId") Integer classId) {
        List<User> userPageList = classStudentService.getOperateStudentList(classId);
        return ResponseResult.success(userPageList);
    }

    @DeleteMapping(value = ApiConstant.CLASS_STUDENT_BATCH_DELETE)
    @ApiOperation(value = "批量删除班级-学生关系", notes = "批量删除班级-学生关系")
    public ResponseResult<String> batchDeleteStudent(@RequestBody ClassStudentRo classStudentRo) {
        classStudentService.batchDeleteStudent(classStudentRo);
        return ResponseResult.success("删除成功");
    }

}
