package site.yanyan.learn.pojo.base;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Timestamp;

@XmlAccessorType(value = XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseInfo 
	
	extends BaseRecord { 
	/**
	 * 备注
	 */
	@XmlTransient
	@ApiModelProperty(value = "备注")
	protected String memo;
	
	
	/**
	 * 更新人Id
	 */
	@XmlTransient 
	@ApiModelProperty(value = "更新人Id")
	protected Long updateUserId;
	
	/**
	 * 更新人Name
	 */
	@XmlTransient 
	@ApiModelProperty(value = "更新人Name")
	protected String updateUserName; 
	
	
	/**
	 * 新建人Id
	 */
	@XmlTransient 
	@ApiModelProperty(value = "新建人Id")
	protected Long createUserId;
	
	/**
	 * 新建人Name
	 */
	@XmlTransient 
	@ApiModelProperty(value = "新建人Name")
	protected String createUserName;
	/**
	 * 修改时间
	 */ 
	@XmlTransient 
	@ApiModelProperty(value = "更新时间")
	protected Timestamp updateTime; 
	
	/**
	 * 建单时间
	 */ 
	@XmlTransient 
	@ApiModelProperty(value = "建单时间")
	protected Timestamp createTime;

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	  
}
