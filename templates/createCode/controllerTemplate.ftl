package ${controllerPackageName};
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
import ${packageName}.pojo.ResultResponse;
import ${packageName}.pojo.base.BaseRecord;
import ${voPackageName}.${voName};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ${beanPackageName}.${beanName};
import ${servicePackageName}.${beanName}Service;
import ${packageName}.controller.base.BaseController;
import ${packageName}.pojo.PageTableData;
@Api(tags = "${beanName}")
@RestController
@Validated
@RequestMapping("/${beanName?uncap_first}")
public class ${beanName}Controller extends BaseController {

	@Autowired
	public ${beanName}Service ${beanName?uncap_first}Service;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =${beanName?uncap_first}Service.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<${beanName}> save(@ApiParam(required = true, value = "添加${beanName}")@Valid
        @RequestBody ${beanName} record) {
        ${beanName?uncap_first}Service.save(record);
        return new ResultResponse<${beanName}>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<${beanName}> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        ${beanName} record=${beanName?uncap_first}Service.getById(recode.getId());
        return new ResultResponse<${beanName}>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<${beanName}> editById(@ApiParam(required=true,value="修改${beanName}") @Valid
        @RequestBody ${beanName} record) {
        ${beanName?uncap_first}Service.editById(record);
        return new ResultResponse<${beanName}>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageTableData<${beanName}>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody ${voName} param) {
        return new ResultResponse<PageTableData<${beanName}>>(
            ${beanName?uncap_first}Service.list(param.getPage(), param.getPageSize(), param));
    }

}
