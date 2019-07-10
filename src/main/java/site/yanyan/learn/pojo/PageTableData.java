package site.yanyan.learn.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class PageTableData<T extends Object>  {
	  
    @ApiModelProperty(value = "当前页")
    int pageNum = 1;
    @ApiModelProperty(value = "总页数")
    int pages = 1;
    @ApiModelProperty(value = "每页条数")
    int pageSize = 10;
    @ApiModelProperty(value = "总查询条数")
    long total;
    
   
    @ApiModelProperty(value = "开始行")
    private int startRow; 
    @ApiModelProperty(value = "结束行")
    private int endRow; 
     
    @ApiModelProperty(value = "前一页")
    private int prePage;  
    @ApiModelProperty(value = "后一页")
    private int nextPage;  
    @ApiModelProperty(value = "是第一页")
    private boolean isFirstPage = false; 
    @ApiModelProperty(value = "是最后一页")
    private boolean isLastPage = false; 
    @ApiModelProperty(value = "有前一页")
    private boolean hasPreviousPage = false; 
    @ApiModelProperty(value = "有后一页")
    private boolean hasNextPage = false; 

    @JsonProperty("data")
    @ApiModelProperty(value = "查询数据")
    List<T> data;
    
    

    public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
 

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	} 

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	 

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public PageTableData(List<T> list) {
        data = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
 

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
 

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> datalist) {
        this.data = datalist;
    } 
    
}
