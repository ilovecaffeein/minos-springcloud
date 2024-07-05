package com.caxs.minos.domain;

import java.io.Serializable;

public class PkgTypDtl implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long typId;

    private Long seqNo;

    private String fldNm;

    private String fldDesc;

    private Long fldLen;

    private String fldVal;

    public Long getTypId() {
        return typId;
    }

    public void setTypId(Long typId) {
        this.typId = typId;
    }

    public Long getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Long seqNo) {
        this.seqNo = seqNo;
    }

    public String getFldNm() {
        return fldNm;
    }

    public void setFldNm(String fldNm) {
        this.fldNm = fldNm == null ? null : fldNm.trim();
    }

    public String getFldDesc() {
        return fldDesc;
    }

    public void setFldDesc(String fldDesc) {
        this.fldDesc = fldDesc == null ? null : fldDesc.trim();
    }

    public Long getFldLen() {
        return fldLen;
    }

    public void setFldLen(Long fldLen) {
        this.fldLen = fldLen;
    }

    public String getFldVal() {
        return fldVal;
    }

    public void setFldVal(String fldVal) {
        this.fldVal = fldVal == null ? null : fldVal.trim();
    }
}