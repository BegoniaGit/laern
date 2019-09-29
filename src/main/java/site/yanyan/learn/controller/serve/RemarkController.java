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
import site.yanyan.learn.pojo.serve.Remark;
import site.yanyan.learn.service.serve.RemarkService;
import site.yanyan.learn.vo.serve.RemarkQuery;

import javax.validation.Valid;

@Api(tags = "评论")
@RestController
@Validated
@RequestMapping("/remark")
public class RemarkController extends BaseController {

	@Autowired
	public RemarkService remarkService;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =remarkService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<Remark> save(@ApiParam(required = true, value = "添加Remark")@Valid
        @RequestBody Remark record) {
        remarkService.save(record);
        return new ResultResponse<Remark>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<Remark> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        Remark record=remarkService.getById(recode.getId());
        return new ResultResponse<Remark>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<Remark> editById(@ApiParam(required=true,value="修改Remark") @Valid
        @RequestBody Remark record) {
        remarkService.editById(record);
        return new ResultResponse<Remark>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageTableData<Remark>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody RemarkQuery param) {
        return new ResultResponse<PageTableData<Remark>>(
            remarkService.list(param.getPage(), param.getPageSize(), param));
    }

}
