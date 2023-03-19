package gs.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gs.demo.domain.Work;
import gs.demo.response.ResponseResult;
import gs.demo.ro.WorkMyPageListRo;
import gs.demo.service.IWorkService;
import gs.demo.vo.WorkPageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>作业分页列表</p>
 *
 * @author gs
 * @since 2023/3/16 09:24
 */
@RestController
@Api( tags = "作业" )
@RequestMapping("work")
public class WorkController {

    @Resource
    private IWorkService workService;

    @PostMapping(value = "pageList")
    @ApiOperation(value = "分页列表", notes = "分页列表")
    public ResponseResult<IPage<WorkPageListVo>> getPageList(WorkMyPageListRo workPageListRo) {
        IPage<WorkPageListVo> workPageListVoIPage = workService.getPageList(workPageListRo);
        return ResponseResult.success(workPageListVoIPage);
    }

    @PostMapping(value = "add")
    @ApiOperation(value = "添加", notes = "批量添加")
    public ResponseResult<String> add(@RequestBody Work work) {
        workService.add(work);
        return ResponseResult.success("添加成功");
    }

    @PostMapping(value = "batchAdd")
    @ApiOperation(value = "批量添加", notes = "批量添加")
    public ResponseResult<String> batchAdd(@RequestBody List<Work> workList) {
        workService.batchAdd(workList);
        return ResponseResult.success("添加成功");
    }

    @PutMapping(value = "update")
    @ApiOperation(value = "修改", notes = "修改")
    public ResponseResult<String> update(@RequestBody Work work) {
        workService.update(work);
        return ResponseResult.success("修改成功");
    }

    @DeleteMapping(value = "batchDelete")
    @ApiOperation(value = "批量删除", notes = "批量删除")
    public ResponseResult<String> batchDelete(@RequestBody List<Integer> workIdList) {
        workService.batchDelete(workIdList);
        return ResponseResult.success("删除成功");
    }

}
