package gs.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gs.demo.constants.ApiConstant;
import gs.demo.domain.SchoolClass;
import gs.demo.domain.User;
import gs.demo.response.ResponseResult;
import gs.demo.ro.ClassRo;
import gs.demo.ro.CommonRo;
import gs.demo.service.IClassService;
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
 * @since 2023/3/18 20:58
 */
@RestController
@Api( tags = "班级管理" )
@RequestMapping("class")
public class ClassController {

    @Resource
    private IClassService classService;

    @GetMapping(value = ApiConstant.PAGE_LIST)
    @ApiOperation(value = "分页列表", notes = "分页列表")
    public ResponseResult<IPage<ClassVo>> getClassPageList(ClassRo classRo) {
        IPage<ClassVo> classPageList = classService.getClassPageList(classRo);
        return ResponseResult.success(classPageList);
    }

    @PostMapping(value = ApiConstant.ADD)
    @ApiOperation(value = "新增", notes = "新增")
    public ResponseResult<String> addClass(@RequestBody SchoolClass schoolClass) {
        classService.addClass(schoolClass);
        return ResponseResult.success("新增成功");
    }

    @GetMapping(value = ApiConstant.DETAIL)
    @ApiOperation(value = "详情", notes = "详情")
    public ResponseResult<SchoolClass> getClassDetail(@RequestParam("classId") Integer classId) {
        SchoolClass schoolClass = classService.getClassDetail(classId);
        return ResponseResult.success(schoolClass);
    }

    @PutMapping(value = ApiConstant.UPDATE)
    @ApiOperation(value = "修改", notes = "修改")
    public ResponseResult<String> updateClass(@RequestBody SchoolClass schoolClass) {
        classService.updateClass(schoolClass);
        return ResponseResult.success("修改成功");
    }

    @DeleteMapping(value = ApiConstant.DELETE)
    @ApiOperation(value = "删除", notes = "删除")
    public ResponseResult<String> deleteClass(@RequestBody CommonRo<SchoolClass> commonRo) {
        classService.deleteClass(commonRo.getId());
        return ResponseResult.success("删除成功");
    }

    @GetMapping(value = ApiConstant.CLASS_TEACHER_LIST)
    @ApiOperation(value = "班主任列表", notes = "班主任列表")
    public ResponseResult<List<User>> getClassTeacherList(@RequestParam(value = "classId", required = false) Integer classId) {
        List<User> userList = classService.getClassTeacherList(classId);
        return ResponseResult.success(userList);
    }

    @GetMapping(value = ApiConstant.LIST)
    @ApiOperation(value = "班级列表", notes = "班主任列表")
    public ResponseResult<List<SchoolClass>> getClassList() {
        List<SchoolClass> classList = classService.getClassList();
        return ResponseResult.success(classList);
    }

}
