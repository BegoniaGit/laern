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

/**Problem*/
public class Problem implements Serializable {

	@ApiModelProperty(value = "")
	private Long problemId;

	@ApiModelProperty(value = "(字符长度为1-100)")
	@Size(min=1, max=100,message="字符长度为1-100")
	private String problemTitle;

	@ApiModelProperty(value = "(字符长度为1-1000)")
	@Size(min=1, max=1000,message="字符长度为1-1000")
	private String problemContext;

	@ApiModelProperty(value = "该是否解决  0未解决 1解决(字符长度为1-1)")
	@Size(min=1, max=1,message="该是否解决  0未解决 1解决字符长度为1-1")
	private String solve;

	@ApiModelProperty(value = "发起问题的用户id")
	private Long userId;

	@ApiModelProperty(value = "科目id")
	private Long subjectId;

	@ApiModelProperty(value = "评论次数")
	private Long problemRemarkCount;

	@ApiModelProperty(value = "问题浏览次数")
	private Long problemViewCount;

	@ApiModelProperty(value = "发起问题的时间")
	private Timestamp problemCreateTime;

	@ApiModelProperty(value = "修改问题的时间")
	private Timestamp problemUpdateTime;


    private static final long serialVersionUID = 1L;

	public Long getProblemId () {   
		return problemId;
	}
		
	public void setProblemId (Long problemId) {
		this.problemId= problemId ;
	}

    public String getProblemTitle () {   
    	 return problemTitle;
    }

    public void setProblemTitle (String problemTitle) {
    	 this.problemTitle= problemTitle == null ? null : problemTitle.trim();
    }

    public String getProblemContext () {   
    	 return problemContext;
    }

    public void setProblemContext (String problemContext) {
    	 this.problemContext= problemContext == null ? null : problemContext.trim();
    }

    public String getSolve () {   
    	 return solve;
    }

    public void setSolve (String solve) {
    	 this.solve= solve == null ? null : solve.trim();
    }

	public Long getUserId () {   
		return userId;
	}
		
	public void setUserId (Long userId) {
		this.userId= userId ;
	}

	public Long getSubjectId () {   
		return subjectId;
	}
		
	public void setSubjectId (Long subjectId) {
		this.subjectId= subjectId ;
	}

	public Long getProblemRemarkCount () {   
		return problemRemarkCount;
	}
		
	public void setProblemRemarkCount (Long problemRemarkCount) {
		this.problemRemarkCount= problemRemarkCount ;
	}

	public Long getProblemViewCount () {   
		return problemViewCount;
	}
		
	public void setProblemViewCount (Long problemViewCount) {
		this.problemViewCount= problemViewCount ;
	}


	public void difference(Problem obj) {
		String defString = "";
		if (!Objects.equals(this.problemId,obj.getProblemId())){
			defString += "从" + this.problemId + "修改为" + obj.getProblemId();
		}

	   if(!this.problemTitle.equals(obj.getProblemTitle())) {
			 defString += "从" + this.problemTitle +"修改为" +obj.getProblemTitle();
		}

	   if(!this.problemContext.equals(obj.getProblemContext())) {
			 defString += "从" + this.problemContext +"修改为" +obj.getProblemContext();
		}

	   if(!this.solve.equals(obj.getSolve())) {
			 defString += "该是否解决  0未解决 1解决从" + this.solve +"修改为" +obj.getSolve();
		}

		if (!Objects.equals(this.userId,obj.getUserId())){
			defString += "发起问题的用户id从" + this.userId + "修改为" + obj.getUserId();
		}

		if (!Objects.equals(this.subjectId,obj.getSubjectId())){
			defString += "科目id从" + this.subjectId + "修改为" + obj.getSubjectId();
		}

		if (!Objects.equals(this.problemRemarkCount,obj.getProblemRemarkCount())){
			defString += "评论次数从" + this.problemRemarkCount + "修改为" + obj.getProblemRemarkCount();
		}

		if (!Objects.equals(this.problemViewCount,obj.getProblemViewCount())){
			defString += "问题浏览次数从" + this.problemViewCount + "修改为" + obj.getProblemViewCount();
		}


    }
}