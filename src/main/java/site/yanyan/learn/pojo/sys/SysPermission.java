package site.yanyan.learn.pojo.sys;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
@JsonInclude(Include.NON_NULL)

/**SysPermission*/
public class SysPermission implements Serializable {

	@ApiModelProperty(value = "权限")
	private Long permissionId;

	@ApiModelProperty(value = "名称(字符长度为1-20)")
	@Size(min=1, max=20,message="名称字符长度为1-20")
	private String permissionName;


    private static final long serialVersionUID = 1L;

	public Long getPermissionId () {   
		return permissionId;
	}
		
	public void setPermissionId (Long permissionId) {
		this.permissionId= permissionId ;
	}

    public String getPermissionName () {   
    	 return permissionName;
    }

    public void setPermissionName (String permissionName) {
    	 this.permissionName= permissionName == null ? null : permissionName.trim();
    }


	public void difference(SysPermission obj) {
		String defString = "";
		if (!Objects.equals(this.permissionId,obj.getPermissionId())){
			defString += "权限从" + this.permissionId + "修改为" + obj.getPermissionId();
		}

	   if(!this.permissionName.equals(obj.getPermissionName())) {
			 defString += "名称从" + this.permissionName +"修改为" +obj.getPermissionName();
		}


    }
}