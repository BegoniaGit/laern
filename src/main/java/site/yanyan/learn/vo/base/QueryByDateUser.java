package site.yanyan.learn.vo.base;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

public class QueryByDateUser extends BaseQueryParam {
	
	
	
	@ApiModelProperty(value = "建立用户id") 
	protected Long updateUserId; 
	
	@ApiModelProperty(value = "修改用户id") 
	protected Long createUserId;  
	
	/** 
	 * 修改时间 
	 */
	@ApiModelProperty(value = "查询修改开始时间") 
	protected Timestamp updateTimeStart; 
	
	/** 
	 * 建单时间 
	 */ 
	@ApiModelProperty(value = "查询建单开始时间") 
	protected Timestamp createTimeStart;
	 
	/** 
	 * 修改时间 
	 */
	@ApiModelProperty(value = "查询修改结束时间") 
	protected Timestamp updateTimeEnd; 
	
	/** 
	 * 建单时间 
	 */ 
	@ApiModelProperty(value = "查询建单结束时间") 
	protected Timestamp createTimeEnd;

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
 

	public Timestamp getUpdateTimeStart() {
		return updateTimeStart;
	}

	public void setUpdateTimeStart(Timestamp updateTimeStart) {
		this.updateTimeStart = updateTimeStart;
	}

	public Timestamp getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(Timestamp createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public Timestamp getChangeTimeEnd() {
		return updateTimeEnd;
	}

	public void setChangeTimeEnd(Timestamp changeTimeEnd) {
		this.updateTimeEnd = changeTimeEnd;
	}

	public Timestamp getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Timestamp createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}   
	
	
}
