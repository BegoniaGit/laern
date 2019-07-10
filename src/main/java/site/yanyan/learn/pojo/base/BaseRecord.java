package site.yanyan.learn.pojo.base;


import io.swagger.annotations.ApiModelProperty;
import site.yanyan.learn.vo.base.BaseQueryParam;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(value = XmlAccessType.FIELD)
public class BaseRecord extends BaseQueryParam {
	
	@XmlTransient 
	@ApiModelProperty(value = "基本信息id编号主键,新建记录无id")
	@Min(1)
	@NotNull
	protected Long id = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	 
}
