package site.yanyan.learn.controller.manage;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import site.yanyan.learn.controller.base.BaseController;
import site.yanyan.learn.dao.SysUserDao;
import site.yanyan.learn.pojo.dev.PageTableData;
import site.yanyan.learn.pojo.dev.ResultResponse;
import site.yanyan.learn.pojo.sys.SysUser;
import site.yanyan.learn.pojo.base.BaseRecord;
import site.yanyan.learn.service.SysUserService;
import site.yanyan.learn.vo.SysUserQuery;

import javax.validation.Valid;
@Api(tags = "SysUser")
@RestController
@Validated
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {

	@Autowired
	public SysUserService sysUserService;

	@Autowired
	public SysUserDao sysUserDao;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =sysUserService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<SysUser> save(@ApiParam(required = true, value = "添加SysUser")@Valid
        @RequestBody SysUser record) {
        sysUserService.save(record);
        return new ResultResponse<SysUser>(0,"ok", record);
    }


    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<SysUser> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        SysUser record=sysUserService.getById(recode.getId());
        return new ResultResponse<SysUser>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<SysUser> editById(@ApiParam(required=true,value="修改SysUser") @Valid
        @RequestBody SysUser record) {
        sysUserService.editById(record);
        return new ResultResponse<SysUser>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageTableData<SysUser>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody SysUserQuery param) {
        return new ResultResponse<PageTableData<SysUser>>(
            sysUserService.list(param.getPage(), param.getPageSize(), param));
    }




}
