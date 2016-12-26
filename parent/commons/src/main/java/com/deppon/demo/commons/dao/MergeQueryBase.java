package com.deppon.demo.commons.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static java.lang.Math.abs;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 16/11/28 下午10:17
 */
public class MergeQueryBase{
    private static int		DEFAULT_PAGE_SIZE	= 20;

    protected int	pageSize	= DEFAULT_PAGE_SIZE;
    protected int	currentPage = 1;
    protected long	total;

    protected long  firstTotal = 0;
    protected long  secondTotal = 0;

    protected int midPage;
    protected int midPageSize;

    protected int	start = 0;
    protected int	end = 20;

    public long getFirstTotal() {
        return firstTotal;
    }

    public void setFirstTotal(long firstTotal) {
        this.firstTotal = firstTotal;
    }

    public long getSecondTotal() {
        return secondTotal;
    }

    public void setSecondTotal(long secondTotal) {
        this.secondTotal = secondTotal;
        this.setMidPage();
        this.setMidPageSize();
        this.setStartAndEnd();
    }

    public int getMidPage() {
        return midPage;
    }

    public void setMidPage() {
        this.midPage = (int) (abs(firstTotal / this.getPageSize()) + 1);
    }

    public int getMidPageSize() {
        return midPageSize;
    }

    public void setMidPageSize() {
        this.midPageSize = (int) (firstTotal % this.getPageSize());
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = this.getFirstTotal() + this.getSecondTotal();
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
        if (this.getSecondTotal() > 0){
            if (this.getCurrentPage() < this.getMidPage()){
                this.pageSize = 0;
            }else if (this.getCurrentPage() == this.getMidPage()){
                this.start = 0;
                this.pageSize = this.getPageSize() - this.getMidPageSize();
            }else {
                // TODO: 16/11/28  int 和 long 的转换，会不会因为溢出出错
                this.start = (int) (this.getStart() - this.getFirstTotal());
            }
        }
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
