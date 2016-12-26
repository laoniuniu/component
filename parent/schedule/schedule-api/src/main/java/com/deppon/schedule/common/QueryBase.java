package com.deppon.schedule.common;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author mitsui.
 */
public class QueryBase {
    private static int DEFAULT_PAGE_SIZE = 20;
    protected int pageSize;
    protected int currentPage;
    protected long total;
    protected int start;
    protected int end;

    public QueryBase() {
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.currentPage = 1;
        this.start = 0;
        this.end = 20;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if(pageSize != null && pageSize.intValue() > 0) {
            this.pageSize = pageSize.intValue();
        }

        this.setStartAndEnd();
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if(currentPage != null && currentPage.intValue() > 0) {
            this.currentPage = currentPage.intValue();
        }

        this.setStartAndEnd();
    }

    protected void setStartAndEnd() {
        this.start = (this.getCurrentPage() - 1) * this.getPageSize();
        if(this.start < 0) {
            this.start = 0;
        }

        this.end = this.getStart() + this.getPageSize() - 1;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(Integer start) {
        if(start != null && start.intValue() >= 0) {
            this.start = start.intValue();
        }

    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(Integer end) {
        if(end != null && end.intValue() >= 0) {
            this.end = end.intValue();
        }

    }

    public boolean hasNextPage() {
        return (long)this.getCurrentPage() < this.getTotalPage() - 1L;
    }

    public boolean hasPreviousPage() {
        return (long)this.getCurrentPage() > 1L;
    }

    public long getTotalPage() {
        return this.total % (long)this.pageSize == 0L?this.total / (long)this.pageSize:this.total / (long)this.pageSize + 1L;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
