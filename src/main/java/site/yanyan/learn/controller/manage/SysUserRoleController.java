package site.yanyan.learn.controller.manage;
import java.util.List;
import javax.validation.Valid;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.yanyan.learn.pojo.ResultResponse;
import site.yanyan.learn.pojo.base.BaseRecord;
import site.yanyan.learn.vo.SysUserRoleQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import site.yanyan.learn.pojo.SysUserRole;
import site.yanyan.learn.service.SysUserRoleService;
import site.yanyan.learn.controller.base.BaseController;
import site.yanyan.learn.pojo.PageTableData;
@Api(tags = "SysUserRole")
@RestController
@Validated
@RequestMapping("/sysUserRole")
public class SysUserRoleController extends BaseController {

	@Autowired
	public SysUserRoleService sysUserRoleService;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =sysUserRoleService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<SysUserRole> save(@ApiParam(required = true, value = "添加SysUserRole")@Valid
        @RequestBody SysUserRole record) {
        sysUserRoleService.save(record);
        return new ResultResponse<SysUserRole>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<SysUserRole> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        SysUserRole record=sysUserRoleService.getById(recode.getId());
        return new ResultResponse<SysUserRole>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<SysUserRole> editById(@ApiParam(required=true,value="修改SysUserRole") @Valid
        @RequestBody SysUserRole record) {
        sysUserRoleService.editById(record);
        return new ResultResponse<SysUserRole>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageTableData<SysUserRole>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody SysUserRoleQuery param) {
        return new ResultResponse<PageTableData<SysUserRole>>(
            sysUserRoleService.list(param.getPage(), param.getPageSize(), param));
    }

}
