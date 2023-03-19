package gs.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gs.demo.constants.ApiConstant;
import gs.demo.domain.MyPage;
import gs.demo.domain.User;
import gs.demo.response.ResponseResult;
import gs.demo.ro.CommonUserRo;
import gs.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/14 21:40
 */
@RestController
@Api( tags = "用户管理" )
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping(value = ApiConstant.USER_INFO)
    @ApiOperation(value = "用户信息", notes = "用户信息")
    public ResponseResult<User> getUserInfo() {
        return userService.getUserInfo();
    }

    @GetMapping(value = ApiConstant.USER_PAGE_LIST)
    @ApiOperation(value = "分页列表", notes = "分页列表")
    public ResponseResult<IPage<User>> getUserPageList(User user, MyPage myPage) {
        IPage<User> userPageList = userService.getUserPageList(user, myPage);
        return ResponseResult.success(userPageList);
    }

    @GetMapping(value = ApiConstant.USER_DETAIL)
    @ApiOperation(value = "用户详细信息", notes = "用户详细信息")
    public ResponseResult<User> getUserDetail(@RequestParam("userId") Integer userId) {
        return userService.getUserDetail(userId);
    }

    @PostMapping(value = ApiConstant.USER_BATCH_ADD)
    @ApiOperation(value = "批量新增", notes = "批量新增")
    public ResponseResult<String> batchAddUser(@RequestBody CommonUserRo userRo) {
        userService.batchAddUser(userRo.getUserList());
        return ResponseResult.success("用户新增成功");
    }

    @PutMapping(value = ApiConstant.USER_EDIT)
    @ApiOperation(value = "修改", notes = "修改")
    public ResponseResult<String> update(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseResult.success("用户修改成功");
    }

    @PutMapping(value = ApiConstant.USER_RESET_PWD)
    @ApiOperation(value = "密码重置", notes = "密码重置")
    public ResponseResult<String> resetPwd(@RequestBody CommonUserRo userRo) {
        userService.resetPwd(userRo.getUserId());
        return ResponseResult.success("密码重置成功");
    }

    @DeleteMapping(value = ApiConstant.USER_DELETE)
    @ApiOperation(value = "删除", notes = "删除")
    public ResponseResult<String> delete(@RequestBody CommonUserRo userRo) {
        userService.delete(userRo.getUserId());
        return ResponseResult.success("用户删除成功");
    }

    @DeleteMapping(value = ApiConstant.USER_BATCH_DELETE)
    @ApiOperation(value = "批量删除", notes = "批量删除")
    public ResponseResult<String> batchDelete(@RequestBody CommonUserRo userRo) {
        userService.batchDelete(userRo.getUserIdList());
        return ResponseResult.success("用户删除成功");
    }

    @PostMapping(value = ApiConstant.USER_IMPORT)
    @ApiOperation(value = "导入", notes = "导入")
    @ApiImplicitParam(name = "file", value = "表格", required = true, dataType = "__file")
    public ResponseResult<String> importUser(@RequestParam("file") MultipartFile file) {
        userService.importUser(file);
        return ResponseResult.success("导入成功");
    }

    @GetMapping(value = ApiConstant.USER_EXPORT, produces = "application/octet-stream")
    @ApiOperation(value = "导出", notes = "导出")
    public void exportUser(User user) {
        userService.exportUser(user);
    }

}
