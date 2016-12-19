package com.deppon.mq.client.model;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.pamirs.mq.client.serialize.KryoSerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 * MQ物流交易实体
 *
 * @author wuxing
 */
public class MqTradeDO implements Serializable {


    private static final long serialVersionUID = 6615109503257049848L;
    /**
     * 物流交易ID
     */
    private Long id;

    /**
     * 最近一次历史记录ID
     */
    private Long newHistoryId;

    /**
     * 上一次历史记录ID
     */
    private Long oldHistoryId;
    //账号json
    private String accountJson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNewHistoryId() {
        return newHistoryId;
    }

    public void setNewHistoryId(Long newHistoryId) {
        this.newHistoryId = newHistoryId;
    }

    public Long getOldHistoryId() {
        return oldHistoryId;
    }

    public void setOldHistoryId(Long oldHistoryId) {
        this.oldHistoryId = oldHistoryId;
    }

    public String getAccountJson() {
        return accountJson;
    }

    public void setAccountJson(String accountJson) {
        this.accountJson = accountJson;
    }

}
