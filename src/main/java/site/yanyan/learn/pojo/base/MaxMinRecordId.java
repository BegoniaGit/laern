package site.yanyan.learn.pojo.base;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class MaxMinRecordId {
	
	@ApiModelProperty(value = "最大值")
	@NotNull
	Long maxid;
	
	@ApiModelProperty(value = "最小值")
	@NotNull
	Long minid;
	public Long getMaxid() {
		return maxid;
	}
	public void setMaxid(Long maxid) {
		this.maxid = maxid;
	}
	public Long getMinid() {
		return minid;
	}
	public void setMinid(Long minid) {
		this.minid = minid;
	}
	
}
