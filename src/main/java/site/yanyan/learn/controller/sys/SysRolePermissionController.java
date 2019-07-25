package site.yanyan.learn.controller.sys;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import site.yanyan.learn.controller.base.BaseController;
import site.yanyan.learn.pojo.dev.PageTableData;
import site.yanyan.learn.pojo.dev.ResultResponse;
import site.yanyan.learn.pojo.sys.SysRolePermission;
import site.yanyan.learn.service.sys.SysRolePermissionService;
import site.yanyan.learn.vo.sys.SysRolePermissionQuery;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "角色权限")
@RestController
@Validated
@RequestMapping("/sys/rolepermission")
public class SysRolePermissionController extends BaseController {

    @Autowired
    public SysRolePermissionService sysRolePermissionService;

    @ApiOperation(value = "删除记录")
    @DeleteMapping(value = "/del")
    public ResultResponse<SysRolePermission> delById(@ApiParam(required = true, value = "SysRolePermission")
                                                     @RequestBody @NotNull SysRolePermission recode) {
        SysRolePermission re = sysRolePermissionService.delByInfo(recode);
        return new ResultResponse<SysRolePermission>(re);
    }

    @ApiOperation(value = "新增记录")
    @PostMapping(value = "/add")
    public ResultResponse<SysRolePermission> save(@ApiParam(required = true, value = "添加SysRolePermission") @Valid
                                                  @RequestBody SysRolePermission record) {
        sysRolePermissionService.save(record);
        return new ResultResponse<SysRolePermission>(0, "ok", record);
    }

    @ApiOperation(value = "根据roleId查询记录")
    @GetMapping(value = "/get")
    public ResultResponse<List<SysRolePermission>> getById(
            @ApiParam(required = true, value = "查询编号")
            @RequestParam @Valid @NotNull Long recode) {
        List<SysRolePermission> record = sysRolePermissionService.getByRoleId(recode);
        return new ResultResponse<List<SysRolePermission>>(record);
    }

    @ApiOperation(value = "详细列表查询")
    @PostMapping(value = "/list")
    public ResultResponse<PageTableData<SysRolePermission>> list(@ApiParam(required = false, value = "查询参数")
                                                                 @Valid @RequestBody SysRolePermissionQuery param) {
        return new ResultResponse<PageTableData<SysRolePermission>>(
                sysRolePermissionService.list(param.getPage(), param.getPageSize(), param));
    }

}
