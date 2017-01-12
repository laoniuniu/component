package com.deppon.pddl.client.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DemoDO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3300649379610987399L;

	private Long id;

    private String tVarchar;

    private Date tDate;

    private Integer tInt;

    private BigDecimal tDecimal;

    private Double tDouble;

    private String tEnum;

    private String tLongtext;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gettVarchar() {
        return tVarchar;
    }

    public void settVarchar(String tVarchar) {
        this.tVarchar = tVarchar == null ? null : tVarchar.trim();
    }

    public Date gettDate() {
        return tDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }

    public Integer gettInt() {
        return tInt;
    }

    public void settInt(Integer tInt) {
        this.tInt = tInt;
    }

    public BigDecimal gettDecimal() {
        return tDecimal;
    }

    public void settDecimal(BigDecimal tDecimal) {
        this.tDecimal = tDecimal;
    }

    public Double gettDouble() {
        return tDouble;
    }

    public void settDouble(Double tDouble) {
        this.tDouble = tDouble;
    }

    public String gettEnum() {
        return tEnum;
    }

    public void settEnum(String tEnum) {
        this.tEnum = tEnum == null ? null : tEnum.trim();
    }

    public String gettLongtext() {
        return tLongtext;
    }

    public void settLongtext(String tLongtext) {
        this.tLongtext = tLongtext == null ? null : tLongtext.trim();
    }
}