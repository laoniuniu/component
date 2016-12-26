package com.deppon.demo.commons.dao;

import java.util.Date;

/**
 * 分页模型
 *
 * @author deng<yihui,haloashen@gmail.com>
 * @version 创建时间：2013-4-9 下午3:02:01
 * 
 * 用于查询列表时进行分页
 * 
 */
public class Paginator {

	/** 每页显示条数 */
	private int limit = 20; 
	
	/** 起始行号 */
    private long start = 0;
    
    /** 结束行号 */
    private long end = 20;
    
    /** 总数 */
    private long total = 0;
    
    /** 时间戳 */
    private Date timestamp;
    
    /** 当前页 */
    private long index = 1;
    
    /** 总页数 */
    private long pageNum = 0;
    
    /** ...隔开的中间页码数量 */
    private int breakpage = 5;
    
    /** ...隔开的中间页码序列中间位置，从零开始 */
    private long currentposition = 2;
    
    /** ...隔开的两端页码数量 */
    private int breakspace = 2;
    
    /** 是否用...断开的判断数量 */
    private int maxspace = 4;
    
    private long prevnum;
    
    private long nextnum;
    

	public Paginator(){
    	
    }
	
	/**
	 * 初始化分页类，生成可供查询使用的分页类
	 * 
	 * @param index
	 * @param limit
	 */
	public Paginator(int index, int limit){
		if(index < 0){
            this.setIndex(1);
        }
		this.setIndex(index);
		this.setLimit(limit);
		this.setStart((this.getIndex() - 1) * this.getLimit());
		this.setEnd(this.getIndex() * this.getLimit());
	}
    
	/**
	 * 完成查询得道结果后，使用此方法生成供页面展示分页控件的分页类
	 * 
	 */
    public void generateView(){
        this.setPageNum(new Double(Math.ceil(new Double(total)/this.getLimit())).intValue());

        if(this.getIndex() > this.getPageNum()){
        	this.setIndex(this.getPageNum());
        }

        this.setPrevnum(this.getIndex() - this.getCurrentposition());
        this.setNextnum(this.getIndex() + this.getCurrentposition());
        if(this.getPrevnum() < 1){
        	this.setPrevnum(1);
        }
        if(this.getNextnum() > this.getPageNum()){
        	this.setNextnum(this.getPageNum());
        }
        this.setEnd(Math.min(this.getIndex() * this.getLimit(), this.getTotal()));
    }
    
    public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
		this.setStart((this.getIndex() - 1) * this.getLimit());
		this.setEnd(this.getIndex() * this.getLimit());
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		if(index < 1){index = 1;}
		this.index = index;
		this.setStart((this.getIndex() - 1) * this.getLimit());
		this.setEnd(this.getIndex() * this.getLimit());
	}

	public long getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getBreakpage() {
		return breakpage;
	}

	public void setBreakpage(int breakpage) {
		this.breakpage = breakpage;
	}

	public long getCurrentposition() {
		return currentposition;
	}

	public void setCurrentposition(int currentposition) {
		this.currentposition = currentposition;
	}

	public int getBreakspace() {
		return breakspace;
	}

	public void setBreakspace(int breakspace) {
		this.breakspace = breakspace;
	}

	public int getMaxspace() {
		return maxspace;
	}

	public void setMaxspace(int maxspace) {
		this.maxspace = maxspace;
	}

    public long getPrevnum() {
		return prevnum;
	}

	public void setPrevnum(long prevnum) {
		this.prevnum = prevnum;
	}

	public long getNextnum() {
		return nextnum;
	}

	public void setNextnum(long nextnum) {
		this.nextnum = nextnum;
	}

    public boolean isBreakLeft(){
        return this.getPrevnum() - this.getBreakspace() > this.getMaxspace() ? true:false;
    }

    public boolean isBreakRight(){
        return  this.getPageNum() - this.getBreakspace() - this.getNextnum() + 1 > this.getMaxspace() ? true:false;
    }

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

    
}
