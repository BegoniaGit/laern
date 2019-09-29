package site.yanyan.learn.pojo.serve;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
@JsonInclude(Include.NON_NULL)

/**Subject*/
public class Subject implements Serializable {

	@ApiModelProperty(value = "科目id")
	private Long subjectId;

	@ApiModelProperty(value = "科目名称(字符长度为1-100)")
	@Size(min=1, max=100,message="科目名称字符长度为1-100")
	private String subjectName;

	@ApiModelProperty(value = "级别")
	private Long subjectClass;

	@ApiModelProperty(value = "父id(字符长度为1-4)")
	@Size(min=1, max=4,message="父id字符长度为1-4")
	private String subjectParent;


    private static final long serialVersionUID = 1L;

	public Long getSubjectId () {   
		return subjectId;
	}
		
	public void setSubjectId (Long subjectId) {
		this.subjectId= subjectId ;
	}

    public String getSubjectName () {   
    	 return subjectName;
    }

    public void setSubjectName (String subjectName) {
    	 this.subjectName= subjectName == null ? null : subjectName.trim();
    }

	public Long getSubjectClass () {   
		return subjectClass;
	}
		
	public void setSubjectClass (Long subjectClass) {
		this.subjectClass= subjectClass ;
	}

    public String getSubjectParent () {   
    	 return subjectParent;
    }

    public void setSubjectParent (String subjectParent) {
    	 this.subjectParent= subjectParent == null ? null : subjectParent.trim();
    }


	public void difference(Subject obj) {
		String defString = "";
		if (!Objects.equals(this.subjectId,obj.getSubjectId())){
			defString += "科目id从" + this.subjectId + "修改为" + obj.getSubjectId();
		}

	   if(!this.subjectName.equals(obj.getSubjectName())) {
			 defString += "科目名称从" + this.subjectName +"修改为" +obj.getSubjectName();
		}

		if (!Objects.equals(this.subjectClass,obj.getSubjectClass())){
			defString += "级别从" + this.subjectClass + "修改为" + obj.getSubjectClass();
		}

	   if(!this.subjectParent.equals(obj.getSubjectParent())) {
			 defString += "父id从" + this.subjectParent +"修改为" +obj.getSubjectParent();
		}


    }
}