package site.yanyan.learn.vo.base;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class BaseQueryParam {
	@ApiModelProperty(value = "第几页") 
	@Min(1)
	protected Integer page = 1;
	@ApiModelProperty(value = "分页大小") 
	@Min(1)
	@Max(40)
	protected Integer pageSize = 10;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	} 
}
