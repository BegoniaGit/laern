package site.yanyan.learn.pojo.sys;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include; 

import io.swagger.annotations.ApiModelProperty;
@JsonInclude(Include.NON_NULL)

/**SysRole*/
public class SysRole implements Serializable {

	@ApiModelProperty(value = "角色")
	private Long roleId;

	@ApiModelProperty(value = "名称(字符长度为1-20)")
	@Size(min=1, max=20,message="名称字符长度为1-20")

	private String name;


	@ApiModelProperty(value = "修改时间")
	private Timestamp updateTime;


    private static final long serialVersionUID = 1L;

	public Long getRoleId () {   
		return roleId;
	}
		
	public void setRoleId (Long roleId) {
		this.roleId= roleId ;
	}

    public String getName () {   
    	 return name;
    }

    public void setName (String name) {
    	 this.name= name == null ? null : name.trim();
    }

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public void difference(SysRole obj) {
		String defString = "";
		if (!Objects.equals(this.roleId,obj.getRoleId())){
			defString += "角色从" + this.roleId + "修改为" + obj.getRoleId();
		}

	   if(!this.name.equals(obj.getName())) {
			 defString += "名称从" + this.name +"修改为" +obj.getName();
		}


    }
}