package site.yanyan.learn.pojo.base;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

public class IdCard {
	
	@ApiModelProperty(value = "身份证件号码(字符长度为15或18)")
	@Size(min=15, max=18,message="身份证件号码字符长度为15或18")
	private String idCard;

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

}
