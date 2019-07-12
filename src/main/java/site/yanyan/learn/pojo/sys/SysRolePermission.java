package site.yanyan.learn.pojo.sys;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
@JsonInclude(Include.NON_NULL)

/**SysRolePermission*/
public class SysRolePermission implements Serializable {

	@ApiModelProperty(value = "")
	private Long roleId;

	@ApiModelProperty(value = "")
	private Long permissionId;

    private static final long serialVersionUID = 1L;

	public Long getRoleId () {   
		return roleId;
	}
		
	public void setRoleId (Long roleId) {
		this.roleId= roleId ;
	}

	public Long getPermissionId () {   
		return permissionId;
	}
		
	public void setPermissionId (Long permissionId) {
		this.permissionId= permissionId ;
	}


	public void difference(SysRolePermission obj) {
		String defString = "";
		if (!Objects.equals(this.roleId,obj.getRoleId())){
			defString += "从" + this.roleId + "修改为" + obj.getRoleId();
		}

		if (!Objects.equals(this.permissionId,obj.getPermissionId())){
			defString += "从" + this.permissionId + "修改为" + obj.getPermissionId();
		}

    }
}