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

/**Answer*/
public class Answer implements Serializable {

	@ApiModelProperty(value = "")
	private Long answerId;

	@ApiModelProperty(value = "(字符长度为1-255)")
	@Size(min=1, max=255,message="字符长度为1-255")
	private String answer;

	@ApiModelProperty(value = "(字符长度为1-255)")
	@Size(min=1, max=255,message="字符长度为1-255")
	private String answerImgPath;

	@ApiModelProperty(value = "回答用户id")
	private Long answerUserId;

	@ApiModelProperty(value = "问题id")
	private Long problemId;

	@ApiModelProperty(value = "创建时间")
	private Timestamp answerCreateTime;

	@ApiModelProperty(value = "修改时间")
	private Timestamp answerUpdateTime;


    private static final long serialVersionUID = 1L;

	public Long getAnswerId () {   
		return answerId;
	}
		
	public void setAnswerId (Long answerId) {
		this.answerId= answerId ;
	}

    public String getAnswer () {   
    	 return answer;
    }

    public void setAnswer (String answer) {
    	 this.answer= answer == null ? null : answer.trim();
    }

    public String getAnswerImgPath () {   
    	 return answerImgPath;
    }

    public void setAnswerImgPath (String answerImgPath) {
    	 this.answerImgPath= answerImgPath == null ? null : answerImgPath.trim();
    }

	public Long getAnswerUserId () {   
		return answerUserId;
	}
		
	public void setAnswerUserId (Long answerUserId) {
		this.answerUserId= answerUserId ;
	}

	public Long getProblemId () {   
		return problemId;
	}
		
	public void setProblemId (Long problemId) {
		this.problemId= problemId ;
	}


	public void difference(Answer obj) {
		String defString = "";
		if (!Objects.equals(this.answerId,obj.getAnswerId())){
			defString += "从" + this.answerId + "修改为" + obj.getAnswerId();
		}

	   if(!this.answer.equals(obj.getAnswer())) {
			 defString += "从" + this.answer +"修改为" +obj.getAnswer();
		}

	   if(!this.answerImgPath.equals(obj.getAnswerImgPath())) {
			 defString += "从" + this.answerImgPath +"修改为" +obj.getAnswerImgPath();
		}

		if (!Objects.equals(this.answerUserId,obj.getAnswerUserId())){
			defString += "回答用户id从" + this.answerUserId + "修改为" + obj.getAnswerUserId();
		}

		if (!Objects.equals(this.problemId,obj.getProblemId())){
			defString += "问题id从" + this.problemId + "修改为" + obj.getProblemId();
		}


    }
}