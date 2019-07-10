package site.yanyan.learn.pojo.base;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

public class Name {
	
	@ApiModelProperty(value = "姓名,字符长度1-50之间")
	@Size(min=1, max=50,message = "姓名长度在1-50之间")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
