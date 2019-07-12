package site.yanyan.learn.controller.sys;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import site.yanyan.learn.pojo.dev.ResultResponse;
import site.yanyan.learn.pojo.base.BaseRecord;
import site.yanyan.learn.vo.sys.SysPermissionQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import site.yanyan.learn.pojo.sys.SysPermission;
import site.yanyan.learn.service.sys.SysPermissionService;
import site.yanyan.learn.controller.base.BaseController;
import site.yanyan.learn.pojo.dev.PageTableData;
@Api(tags = "权限")
@RestController
@Validated
@RequestMapping("/sysPermission")
public class SysPermissionController extends BaseController {

	@Autowired
	public SysPermissionService sysPermissionService;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestParam @NotNull Long recode) {
        Long count =sysPermissionService.delById(recode);
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<SysPermission> save(@ApiParam(required = true, value = "添加SysPermission")@Valid
        @RequestBody SysPermission record) {
        sysPermissionService.save(record);
        return new ResultResponse<SysPermission>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @GetMapping(value = "/get")
    public ResultResponse<SysPermission> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestParam @Valid @NotNull Long recode) {
        SysPermission record=sysPermissionService.getById(recode);
        return new ResultResponse<SysPermission>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<SysPermission> editById(@ApiParam(required=true,value="修改SysPermission") @Valid
        @RequestBody SysPermission record) {
        sysPermissionService.editById(record);
        return new ResultResponse<SysPermission>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PostMapping(value = "/list")
    public ResultResponse<PageTableData<SysPermission>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody SysPermissionQuery param) {
        return new ResultResponse<PageTableData<SysPermission>>(
            sysPermissionService.list(param.getPage(), param.getPageSize(), param));
    }

}
