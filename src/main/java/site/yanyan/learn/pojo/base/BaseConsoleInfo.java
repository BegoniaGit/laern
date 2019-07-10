package site.yanyan.learn.pojo.base;

import io.swagger.annotations.ApiModelProperty;

public class BaseConsoleInfo {
	
	@ApiModelProperty(value = "项目Project的Id")
	private int prjId;
	
	@ApiModelProperty(value = "buildPrj的Id")
	private int buildId;
	
	@ApiModelProperty(value = "文件名称")
	private String fileName;

	public int getPrjId() {
		return prjId;
	}

	public void setPrjId(int prjId) {
		this.prjId = prjId;
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
