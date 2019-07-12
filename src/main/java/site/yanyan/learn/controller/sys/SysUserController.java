package site.yanyan.learn.controller.sys;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import site.yanyan.learn.controller.base.BaseController;
import site.yanyan.learn.dao.sys.SysUserDao;
import site.yanyan.learn.pojo.dev.PageTableData;
import site.yanyan.learn.pojo.dev.ResultResponse;
import site.yanyan.learn.pojo.sys.SysUser;
import site.yanyan.learn.service.sys.SysUserService;
import site.yanyan.learn.utils.UserUtil;
import site.yanyan.learn.vo.sys.SysUserQuery;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "用户")
@RestController
@Validated
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {

    @Autowired
    public SysUserService sysUserService;

    @Autowired
    public SysUserDao sysUserDao;

    @ApiOperation(value = "删除记录")
    @DeleteMapping(value = "/del")
    public ResultResponse<Long> delById(@ApiParam(required = true, value = "查询编号")
                                        @RequestParam @NotNull Long recode) {
        Long count = sysUserService.delById(recode);
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value = "新增记录")
    @PostMapping(value = "/add")
    public ResultResponse<SysUser> save(@ApiParam(required = true, value = "添加SysUser") @Valid
                                        @RequestBody SysUser record) {
        sysUserService.save(record);
        return new ResultResponse<SysUser>(0, "ok", record);
    }

    @ApiOperation(value = "获取当前用户")
    @PostMapping(value = "/curuser")
    public ResultResponse<SysUser> save() {
        return new ResultResponse<SysUser>(0, "ok", UserUtil.getCurrentUser());
    }


    @ApiOperation(value = "根据ID查询记录")
    @GetMapping(value = "/get")
    public ResultResponse<SysUser> getById(
            @ApiParam(required = true, value = "查询编号")
            @RequestParam @Valid @NotNull Long recode) {
        SysUser record = sysUserService.getById(recode);
        return new ResultResponse<SysUser>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<SysUser> editById(@ApiParam(required = true, value = "修改SysUser") @Valid
                                            @RequestBody SysUser record) {
        sysUserService.editById(record);
        return new ResultResponse<SysUser>(0, "ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PostMapping(value = "/list")
    public ResultResponse<PageTableData<SysUser>> list(@ApiParam(required = false, value = "查询参数")
                                                       @Valid @RequestBody SysUserQuery param) {
        return new ResultResponse<PageTableData<SysUser>>(
                sysUserService.list(param.getPage(), param.getPageSize(), param));
    }


}
