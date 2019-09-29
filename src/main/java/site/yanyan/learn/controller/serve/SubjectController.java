package site.yanyan.learn.controller.serve;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import site.yanyan.learn.controller.base.BaseController;
import site.yanyan.learn.pojo.base.BaseRecord;
import site.yanyan.learn.pojo.dev.PageTableData;
import site.yanyan.learn.pojo.dev.ResultResponse;
import site.yanyan.learn.pojo.serve.Subject;
import site.yanyan.learn.service.serve.SubjectService;
import site.yanyan.learn.vo.serve.SubjectQuery;

import javax.validation.Valid;

@Api(tags = "科目")
@RestController
@Validated
@RequestMapping("/subject")
public class SubjectController extends BaseController {

	@Autowired
	public SubjectService subjectService;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =subjectService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<Subject> save(@ApiParam(required = true, value = "添加Subject")@Valid
        @RequestBody Subject record) {
        subjectService.save(record);
        return new ResultResponse<Subject>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<Subject> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        Subject record=subjectService.getById(recode.getId());
        return new ResultResponse<Subject>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<Subject> editById(@ApiParam(required=true,value="修改Subject") @Valid
        @RequestBody Subject record) {
        subjectService.editById(record);
        return new ResultResponse<Subject>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageTableData<Subject>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody SubjectQuery param) {
        return new ResultResponse<PageTableData<Subject>>(
            subjectService.list(param.getPage(), param.getPageSize(), param));
    }

}
