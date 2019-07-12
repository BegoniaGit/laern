package site.yanyan.learn.pojo.sys;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
@JsonInclude(Include.NON_NULL)

/**SysUserRole*/
public class SysUserRole implements Serializable {

	@ApiModelProperty(value = "")
	private Long userId;

	@ApiModelProperty(value = "")
	private Long roleId;


    private static final long serialVersionUID = 1L;

	public Long getUserId () {   
		return userId;
	}
		
	public void setUserId (Long userId) {
		this.userId= userId ;
	}

	public Long getRoleId () {   
		return roleId;
	}
		
	public void setRoleId (Long roleId) {
		this.roleId= roleId ;
	}


	public void difference(SysUserRole obj) {
		String defString = "";
		if (!Objects.equals(this.userId,obj.getUserId())){
			defString += "从" + this.userId + "修改为" + obj.getUserId();
		}

		if (!Objects.equals(this.roleId,obj.getRoleId())){
			defString += "从" + this.roleId + "修改为" + obj.getRoleId();
		}


    }
}