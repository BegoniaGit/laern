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
import site.yanyan.learn.vo.SysRoleQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import site.yanyan.learn.pojo.sys.SysRole;
import site.yanyan.learn.service.SysRoleService;
import site.yanyan.learn.controller.base.BaseController;
import site.yanyan.learn.pojo.dev.PageTableData;
@Api(tags = "SysRole")
@RestController
@Validated
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController {

	@Autowired
	public SysRoleService sysRoleService;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =sysRoleService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<SysRole> save(@ApiParam(required = true, value = "添加SysRole")@Valid
        @RequestBody SysRole record) {
        sysRoleService.save(record);
        return new ResultResponse<SysRole>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<SysRole> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        SysRole record=sysRoleService.getById(recode.getId());
        return new ResultResponse<SysRole>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<SysRole> editById(@ApiParam(required=true,value="修改SysRole") @Valid
        @RequestBody SysRole record) {
        sysRoleService.editById(record);
        return new ResultResponse<SysRole>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageTableData<SysRole>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody SysRoleQuery param) {
        return new ResultResponse<PageTableData<SysRole>>(
            sysRoleService.list(param.getPage(), param.getPageSize(), param));
    }

}
