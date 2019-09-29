package site.yanyan.learn.controller.serve;
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
import site.yanyan.learn.pojo.base.BaseRecord;
import site.yanyan.learn.pojo.dev.ResultResponse;
import site.yanyan.learn.vo.serve.ProblemQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import site.yanyan.learn.pojo.serve.Problem;
import site.yanyan.learn.service.serve.ProblemService;
import site.yanyan.learn.controller.base.BaseController;
import site.yanyan.learn.pojo.dev.PageTableData;
@Api(tags = "提问题")
@RestController
@Validated
@RequestMapping("/problem")
public class ProblemController extends BaseController {

	@Autowired
	public ProblemService problemService;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =problemService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<Problem> save(@ApiParam(required = true, value = "添加Problem")@Valid
        @RequestBody Problem record) {
        problemService.save(record);
        return new ResultResponse<Problem>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<Problem> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        Problem record=problemService.getById(recode.getId());
        return new ResultResponse<Problem>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<Problem> editById(@ApiParam(required=true,value="修改Problem") @Valid
        @RequestBody Problem record) {
        problemService.editById(record);
        return new ResultResponse<Problem>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageTableData<Problem>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody ProblemQuery param) {
        return new ResultResponse<PageTableData<Problem>>(
            problemService.list(param.getPage(), param.getPageSize(), param));
    }

}
