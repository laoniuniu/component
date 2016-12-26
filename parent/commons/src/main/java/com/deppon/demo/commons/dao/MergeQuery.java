package com.deppon.demo.commons.dao;

import java.io.Serializable;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 16/11/28 下午10:16
 */
public class MergeQuery<T> extends MergeQueryBase implements Serializable {
    private static final long serialVersionUID = -6443186486048799474L;

    private T	data;

    private String orderBy;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
