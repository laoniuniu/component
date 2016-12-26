package com.deppon.demo.commons.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 传入pageSize,currentPage,total;计算start,end
 * @author JETLEE
 *
 */
public class QueryBase {
	private static int		DEFAULT_PAGE_SIZE	= 20;
	
	protected int	pageSize	= DEFAULT_PAGE_SIZE;
	protected int	currentPage = 1;
	protected long	total;
	
	protected int	start = 0;
	protected int	end = 20;	
	
	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize){
		if(pageSize != null && pageSize > 0){
			this.pageSize = pageSize;
		}
		this.setStartAndEnd();
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		if (currentPage != null && currentPage > 0) {
			this.currentPage = currentPage;			
		}
		this.setStartAndEnd();
	}
	
	protected void setStartAndEnd(){
		this.start = (this.getCurrentPage() - 1) * this.getPageSize();
		if (this.start < 0) this.start = 0;
		this.end = this.getStart() + this.getPageSize() - 1;
	}

	public int getStart() {
		return start;
	}

	public void setStart(Integer start) {
		if (start != null && start >= 0) {
			this.start = start;			
		}
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		if (end != null && end >= 0) {
			this.end = end;
		}
	}

	public boolean hasNextPage() {
		return getCurrentPage() < getTotalPage() - 1L;
	}

	public boolean hasPreviousPage() {
		return getCurrentPage() > 1L;
	}
	
	public long getTotalPage() {
		if (total % (long) pageSize == 0L)
			return total / (long) pageSize;
		else
			return total / (long) pageSize + 1L;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
