package gs.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gs.demo.constants.ApiConstant;
import gs.demo.domain.ExaminationResult;
import gs.demo.domain.PieData;
import gs.demo.domain.User;
import gs.demo.response.ResponseResult;
import gs.demo.ro.CommonRo;
import gs.demo.ro.ExaminationResultPageListRo;
import gs.demo.service.IExaminationResultService;
import gs.demo.vo.ExaminationResultPageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gs
 * @since 2023/3/22 11:27
 */
@RestController
@Api( tags = "考试成绩" )
@RequestMapping("examinationResult")
public class ExaminationResultController {

    @Resource
    private IExaminationResultService examinationResultService;

    @GetMapping(value = ApiConstant.PAGE_LIST)
    @ApiOperation(value = "分页列表", notes = "分页列表")
    public ResponseResult<IPage<ExaminationResultPageVo>> getPageList(ExaminationResultPageListRo listRo) {
        IPage<ExaminationResultPageVo> pageList = examinationResultService.getPageList(listRo);
        return ResponseResult.success(pageList);
    }

    @GetMapping(value = ApiConstant.ECHARTS_PIE)
    @ApiOperation(value = "饼图统计", notes = "饼图统计")
    public ResponseResult<List<PieData>> getPieData(ExaminationResultPageListRo param) {
        List<PieData> pieDataList = examinationResultService.getScorePie(param);
        return ResponseResult.success(pieDataList);
    }

    @PostMapping(value = ApiConstant.BATCH_ADD)
    @ApiOperation(value = "批量添加", notes = "批量添加")
    public ResponseResult<String> batchAdd(@RequestBody CommonRo<ExaminationResult> commonRo) {
        examinationResultService.batchAdd(commonRo.getDataList());
        return ResponseResult.success("添加成功");
    }

    @PutMapping(value = ApiConstant.UPDATE)
    @ApiOperation(value = "修改", notes = "修改")
    public ResponseResult<String> update(@RequestBody ExaminationResult param) {
        examinationResultService.updateById(param);
        return ResponseResult.success("修改成功");
    }

    @DeleteMapping(value = ApiConstant.BATCH_DELETE)
    @ApiOperation(value = "批量删除", notes = "批量删除")
    public ResponseResult<String> batchDelete(@RequestBody CommonRo<ExaminationResult> commonRo) {
        examinationResultService.removeBatchByIds(commonRo.getIdList());
        return ResponseResult.success("删除成功");
    }

    @PostMapping(value = ApiConstant.IMPORT)
    @ApiOperation(value = "导入", notes = "导入")
    @ApiImplicitParam(name = "file", value = "表格", required = true, dataType = "__file")
    public ResponseResult<String> importData(@RequestParam("file") MultipartFile file) {
        examinationResultService.importData(file);
        return ResponseResult.success("导入成功");
    }

    @GetMapping(value = ApiConstant.EXPORT, produces = "application/octet-stream")
    @ApiOperation(value = "导出", notes = "导出")
    public void exportData(ExaminationResultPageListRo listRo) {
        examinationResultService.exportData(listRo);
    }

}
