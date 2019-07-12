package site.yanyan.learn.controller.manage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yanyan.learn.pojo.dev.ResultResponse;
import site.yanyan.learn.pojo.base.BaseRecord;
import site.yanyan.learn.vo.SysRolePermissionQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import site.yanyan.learn.pojo.sys.SysRolePermission;
import site.yanyan.learn.service.SysRolePermissionService;
import site.yanyan.learn.controller.base.BaseController;
import site.yanyan.learn.pojo.dev.PageTableData;
@Api(tags = "SysRolePermission")
@RestController
@Validated
@RequestMapping("/sysRolePermission")
public class SysRolePermissionController extends BaseController {

	@Autowired
	public SysRolePermissionService sysRolePermissionService;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =sysRolePermissionService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<SysRolePermission> save(@ApiParam(required = true, value = "添加SysRolePermission")@Valid
        @RequestBody SysRolePermission record) {
        sysRolePermissionService.save(record);
        return new ResultResponse<SysRolePermission>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<SysRolePermission> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        SysRolePermission record=sysRolePermissionService.getById(recode.getId());
        return new ResultResponse<SysRolePermission>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<SysRolePermission> editById(@ApiParam(required=true,value="修改SysRolePermission") @Valid
        @RequestBody SysRolePermission record) {
        sysRolePermissionService.editById(record);
        return new ResultResponse<SysRolePermission>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageTableData<SysRolePermission>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody SysRolePermissionQuery param) {
        return new ResultResponse<PageTableData<SysRolePermission>>(
            sysRolePermissionService.list(param.getPage(), param.getPageSize(), param));
    }

}
