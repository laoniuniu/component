package com.deppon.demo.commons.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ResultList<T> extends Result<T> {

	private static final long serialVersionUID = -8793824978794414238L;
	private Collection<T>				datalist;
	private long			total				= 0;

	private static int		DEFAULT_PAGE_SIZE	= 20;
	private int				pageSize;
	private long			start;
	
	public ResultList(){
		this(0L,0L,DEFAULT_PAGE_SIZE,new ArrayList<T>());
	}
	
	public ResultList(long start, long totalSize, int pageSize, Collection<T> data) {
		this.pageSize = pageSize;
		this.start = start;
		this.total = totalSize;
		this.datalist = data;
	}
	
	public Collection<T> getDatalist() {
		return this.datalist;
	}

	public void setDatalist(Collection<T> data) {
		this.datalist = data;
	}
	
	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getTotalPageCount() {
		if (total % (long) pageSize == 0L)
			return total / (long) pageSize;
		else
			return total / (long) pageSize + 1L;
	}

	public int getPageSize() {
		return pageSize;
	}

	public long getCurrentPageNo() {
		return start / (long) pageSize + 1L;
	}

	public boolean hasNextPage() {
		return getCurrentPageNo() < getTotalPageCount() - 1L;
	}

	public boolean hasPreviousPage() {
		return getCurrentPageNo() > 1L;
	}

	protected static int getStartOfPage(int pageNo) {
		return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}

	public static int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}
	
	public Paginator getPaginator(Integer currentPage, Integer pageSize){
		if(null == currentPage){
			currentPage = 1;
		}
		if(null == pageSize){
			pageSize = 20;
		}
		Paginator paginator = new Paginator(currentPage, pageSize);
		paginator.setTotal(total);
		paginator.generateView();
		return paginator;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
