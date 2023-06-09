package gs.demo.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import gs.demo.constants.ApiConstant;
import gs.demo.domain.PieData;
import gs.demo.domain.WorkCompletion;
import gs.demo.response.ResponseResult;
import gs.demo.ro.CommonRo;
import gs.demo.ro.WorkPageListRo;
import gs.demo.service.IWorkService;
import gs.demo.vo.WorkCompletionPageListVo;
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

    @GetMapping(value = ApiConstant.PAGE_LIST)
    @ApiOperation(value = "分页列表", notes = "分页列表")
    public ResponseResult<IPage<WorkCompletionPageListVo>> getPageList(WorkPageListRo workPageListRo) {
        IPage<WorkCompletionPageListVo> workPageListVoIPage = workService.getPageList(workPageListRo);
        return ResponseResult.success(workPageListVoIPage);
    }

    @GetMapping(value = ApiConstant.ECHARTS_PIE)
    @ApiOperation(value = "饼图统计", notes = "饼图统计")
    public ResponseResult<List<PieData>> getPieData(WorkPageListRo workPageListRo) {
        List<PieData> pieDataList = workService.getCompletionLevelPie(workPageListRo);
        return ResponseResult.success(pieDataList);
    }

    @PostMapping(value = ApiConstant.BATCH_ADD)
    @ApiOperation(value = "批量添加", notes = "批量添加")
    public ResponseResult<String> batchAdd(@RequestBody CommonRo<WorkCompletion> param) {
        if (CollUtil.isNotEmpty(param.getDataList())) {
            workService.batchAdd(param.getDataList());
        }
        return ResponseResult.success("添加成功");
    }

    @PutMapping(value = ApiConstant.UPDATE)
    @ApiOperation(value = "修改", notes = "修改")
    public ResponseResult<String> update(@RequestBody WorkCompletion workCompletion) {
        workService.updateById(workCompletion);
        return ResponseResult.success("修改成功");
    }

    @DeleteMapping(value = ApiConstant.BATCH_DELETE)
    @ApiOperation(value = "批量删除", notes = "批量删除")
    public ResponseResult<String> batchDelete(@RequestBody CommonRo<WorkCompletion> param) {
        if (CollUtil.isNotEmpty(param.getIdList())) {
            workService.removeBatchByIds(param.getIdList());
        }
        return ResponseResult.success("删除成功");
    }

}
