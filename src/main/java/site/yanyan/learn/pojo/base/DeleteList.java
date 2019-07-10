package site.yanyan.learn.pojo.base;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.util.List;

public class DeleteList {
	@ApiModelProperty(value = "删除编号的数组")
	@Size(min = 1)
	List<Long> ids;

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

}
