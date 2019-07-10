package site.yanyan.learn.pojo.base;

public class ExcelInfo {
	/**
	 * 文件名
	 */
	String fileName;
	/**
	 * 字段显示头名
	 */
	String[] headers;
	
	/**
	 * 字段名
	 */
	String[] fieldNames;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String[] getHeaders() {
		return headers;
	}

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}

	public String[] getFieldNames() {
		return fieldNames;
	}

	public void setFieldNames(String[] fieldNames) {
		this.fieldNames = fieldNames;
	}
	
}
