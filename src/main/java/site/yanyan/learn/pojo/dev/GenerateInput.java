package site.yanyan.learn.pojo.dev;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class GenerateInput implements Serializable { 
  
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="保存路径")
	private String path = "D:/generate";
	@ApiModelProperty(value="数据表名")
	private String tableName;
	@ApiModelProperty(value="包名")
	private String packageName;
	@ApiModelProperty(value="Pojo包名")
	private String beanPackageName;
	@ApiModelProperty(value="vo包名")
	private String voPackageName;

	
	@ApiModelProperty(value="mybatisMapper包名")
	private String mybatisMapperPackageName;
	@ApiModelProperty(value="dao包名")
	private String daoPackageName;
	@ApiModelProperty(value="service包名")
	private String servicePackageName;	 
	@ApiModelProperty(value="controller包名")
	private String controllerPkgName;
	@ApiModelProperty(value="html包名")
	private String htmlPackageName;  
	
	@ApiModelProperty(value="daotest包名")
	private String daotestPackageName;	
	
	
	@ApiModelProperty(value="Pojo 类名 可以不填写")
	private String beanName;		 
	@ApiModelProperty(value="mybatisMapper类名")
	private String mybatisMapperName;
	
	
	
	@ApiModelProperty(value="dao类名")
	private String daoName;	
	
	
	@ApiModelProperty(value="vo类名Query")
	private String voName;	
	

	@ApiModelProperty(value="service类名")
	private String serviceName;	
	@ApiModelProperty(value="controller类名")
	private String controllerName;
	@ApiModelProperty(value="html类名")
	private String htmlName;
	@ApiModelProperty(value="类映射url")
	private String classUrl;
	
	@ApiModelProperty(value="daotest类名")
	private String daotestName;
	@ApiModelProperty(value="controllertest类名")
	private String controllertestName;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDaoName() {
		return daoName;
	}

	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}

	public String getDaotestPackageName() {
		return daotestPackageName;
	}

	public void setDaotestPackageName(String daotestPackageName) {
		this.daotestPackageName = daotestPackageName;
	}
	public String getDaotestName() {
		return daotestName;
	}

	public void setDaotestName(String daotestName) {
		this.daotestName = daotestName;
	}


	
	public String getClassUrl() {
		return classUrl;
	}

	public void setClassUrl(String classUrl) {
		this.classUrl = classUrl;
	}

	public String getHtmlPackageName() {
		return htmlPackageName;
	}

	public void setHtmlPackageName(String htmlPackageName) {
		this.htmlPackageName = htmlPackageName;
	}

	public String getHtmlName() {
		return htmlName;
	}

	public void setHtmlName(String htmlName) {
		this.htmlName = htmlName;
	}

	private List<BeanField> fields;
	
	 
	
	public String getVoName() {
		return voName;
	}

	public void setVoName(String voName) {
		this.voName = voName;
	}

	public String getMybatisMapperName() {
		return mybatisMapperName;
	}

	public void setMybatisMapperName(String mybatisMapperName) {
		this.mybatisMapperName = mybatisMapperName;
	}
	 
	public String getMybatisMapperPackageName() {
		return mybatisMapperPackageName;
	}

	public void setMybatisMapperPackageName(String mybatisMapperPackageName) {
		this.mybatisMapperPackageName = mybatisMapperPackageName;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getBeanPackageName() {
		return beanPackageName;
	}

	public void setBeanPackageName(String beanPackageName) {
		this.beanPackageName = beanPackageName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getDaoPackageName() {
		return daoPackageName;
	}

	public void setDaoPackageName(String daoPackageName) {
		this.daoPackageName = daoPackageName;
	}

 

	public String getServicePackageName() {
		return servicePackageName;
	}

	public void setServicePackageName(String servicePackageName) {
		this.servicePackageName = servicePackageName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getControllerPkgName() {
		return controllerPkgName;
	}

	public void setControllerPkgName(String controllerPkgName) {
		this.controllerPkgName = controllerPkgName;
	}

	public String getControllerName() {
		return controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	public List<BeanField> getFields() {
		return fields;
	}

	public void setFields(List<BeanField> fields) {
		this.fields = fields;
	}
	public String getVoPackageName() {
		return voPackageName;
	}

	public void setVoPackageName(String voPackageName) {
		this.voPackageName = voPackageName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getControllertestName() {
		return controllertestName;
	}

	public void setControllertestName(String controllertestName) {
		this.controllertestName = controllertestName;
	}
}
