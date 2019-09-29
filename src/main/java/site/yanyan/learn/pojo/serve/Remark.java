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

/**Remark*/
public class Remark implements Serializable {

	@ApiModelProperty(value = "")
	private Long remarkId;

	@ApiModelProperty(value = "(字符长度为1-1000)")
	@Size(min=1, max=1000,message="字符长度为1-1000")
	private String remarkContent;

	@ApiModelProperty(value = "")
	private Timestamp remarkCreateTime;

	@ApiModelProperty(value = "")
	private Long answerId;

	@ApiModelProperty(value = "")
	private Long userId;


    private static final long serialVersionUID = 1L;

	public Long getRemarkId () {   
		return remarkId;
	}
		
	public void setRemarkId (Long remarkId) {
		this.remarkId= remarkId ;
	}

    public String getRemarkContent () {   
    	 return remarkContent;
    }

    public void setRemarkContent (String remarkContent) {
    	 this.remarkContent= remarkContent == null ? null : remarkContent.trim();
    }

	public Long getAnswerId () {   
		return answerId;
	}
		
	public void setAnswerId (Long answerId) {
		this.answerId= answerId ;
	}

	public Long getUserId () {   
		return userId;
	}
		
	public void setUserId (Long userId) {
		this.userId= userId ;
	}


	public void difference(Remark obj) {
		String defString = "";
		if (!Objects.equals(this.remarkId,obj.getRemarkId())){
			defString += "从" + this.remarkId + "修改为" + obj.getRemarkId();
		}

	   if(!this.remarkContent.equals(obj.getRemarkContent())) {
			 defString += "从" + this.remarkContent +"修改为" +obj.getRemarkContent();
		}

		if (!Objects.equals(this.answerId,obj.getAnswerId())){
			defString += "从" + this.answerId + "修改为" + obj.getAnswerId();
		}

		if (!Objects.equals(this.userId,obj.getUserId())){
			defString += "从" + this.userId + "修改为" + obj.getUserId();
		}


    }
}