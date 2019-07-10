package site.yanyan.learn.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
@JsonInclude(Include.NON_NULL)

/**SysUser*/
public class SysUser implements Serializable {

	@ApiModelProperty(value = "")
	private Long userId;

	@ApiModelProperty(value = "(字符长度为1-50)")
	@Size(min=1, max=50,message="字符长度为1-50")

	private String username;

	@ApiModelProperty(value = "(字符长度为1-30)")
	@Size(min=1, max=30,message="字符长度为1-30")
	private String password;

	@ApiModelProperty(value = "(字符长度为1-50)")
	@Size(min=1, max=50,message="字符长度为1-50")
	private String email;

	@ApiModelProperty(value = "(字符长度为1-255)")
	@Size(min=1, max=255,message="字符长度为1-255")
	private String slogan;

	@ApiModelProperty(value = "(字符长度为1-20)")
	@Size(min=1, max=20,message="字符长度为1-20")
	private String studentId;

	@ApiModelProperty(value = "账户警用 0正常1禁用")
	private Integer type;

	@ApiModelProperty(value = "用户角色")
	private Long roleId;


    private static final long serialVersionUID = 1L;

	public Long getUserId () {   
		return userId;
	}
		
	public void setUserId (Long userId) {
		this.userId= userId ;
	}

    public String getUsername () {   
    	 return username;
    }

    public void setUsername (String username) {
    	 this.username= username == null ? null : username.trim();
    }

    public String getPassword () {   
    	 return password;
    }

    public void setPassword (String password) {
    	 this.password= password == null ? null : password.trim();
    }

    public String getEmail () {   
    	 return email;
    }

    public void setEmail (String email) {
    	 this.email= email == null ? null : email.trim();
    }

    public String getSlogan () {   
    	 return slogan;
    }

    public void setSlogan (String slogan) {
    	 this.slogan= slogan == null ? null : slogan.trim();
    }

    public String getStudentId () {   
    	 return studentId;
    }

    public void setStudentId (String studentId) {
    	 this.studentId= studentId == null ? null : studentId.trim();
    }

	public Integer getType () {   
		  return type;
	}
	
	public void setType (Integer type) {
		  this.type= type ;
	}

	public Long getRoleId () {   
		return roleId;
	}
		
	public void setRoleId (Long roleId) {
		this.roleId= roleId ;
	}


	public void difference(SysUser obj) {
		String defString = "";
		if (!Objects.equals(this.userId,obj.getUserId())){
			defString += "从" + this.userId + "修改为" + obj.getUserId();
		}

	   if(!this.username.equals(obj.getUsername())) {
			 defString += "从" + this.username +"修改为" +obj.getUsername();
		}

	   if(!this.password.equals(obj.getPassword())) {
			 defString += "从" + this.password +"修改为" +obj.getPassword();
		}

	   if(!this.email.equals(obj.getEmail())) {
			 defString += "从" + this.email +"修改为" +obj.getEmail();
		}

	   if(!this.slogan.equals(obj.getSlogan())) {
			 defString += "从" + this.slogan +"修改为" +obj.getSlogan();
		}

	   if(!this.studentId.equals(obj.getStudentId())) {
			 defString += "从" + this.studentId +"修改为" +obj.getStudentId();
		}

		if ( !Objects.equals(this.type , obj.getType())){
			defString += "账户警用 0正常1禁用从" + this.type + "修改为" + obj.getType();
		}

		if (!Objects.equals(this.roleId,obj.getRoleId())){
			defString += "用户角色从" + this.roleId + "修改为" + obj.getRoleId();
		}


    }
}