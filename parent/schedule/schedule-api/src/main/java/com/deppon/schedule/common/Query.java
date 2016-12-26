package com.deppon.schedule.common;

import java.io.Serializable;

/**
 * @author mitsui.
 */
public class Query<T> extends QueryBase implements Serializable {
    private static final long serialVersionUID = 1930382256159908170L;
    private T data;
    private String orderBy;

    public Query() {
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(String orderBy) {
        if(orderBy != null && !orderBy.isEmpty()) {
            this.orderBy = orderBy;
        } else {
            this.orderBy = "id";
        }

    }
}
