package com.caxs.minos.domain;

import java.io.Serializable;

public class PkgTyp implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long typId;

    private String pkgTyp;

    private String fldDel;

    private String lnDel;

    private String fldAlg;

    private String fdChr;

    private String emtSd;

    private String hdDel;

    public Long getTypId() {
        return typId;
    }

    public void setTypId(Long typId) {
        this.typId = typId;
    }

    public String getPkgTyp() {
        return pkgTyp;
    }

    public void setPkgTyp(String pkgTyp) {
        this.pkgTyp = pkgTyp == null ? null : pkgTyp.trim();
    }

    public String getFldDel() {
        return fldDel;
    }

    public void setFldDel(String fldDel) {
        this.fldDel = fldDel == null ? null : fldDel.trim();
    }

    public String getLnDel() {
        return lnDel;
    }

    public void setLnDel(String lnDel) {
        this.lnDel = lnDel == null ? null : lnDel.trim();
    }

    public String getFldAlg() {
        return fldAlg;
    }

    public void setFldAlg(String fldAlg) {
        this.fldAlg = fldAlg == null ? null : fldAlg.trim();
    }

    public String getFdChr() {
        return fdChr;
    }

    public void setFdChr(String fdChr) {
        this.fdChr = fdChr == null ? null : fdChr.trim();
    }

    public String getEmtSd() {
        return emtSd;
    }

    public void setEmtSd(String emtSd) {
        this.emtSd = emtSd == null ? null : emtSd.trim();
    }

    public String getHdDel() {
        return hdDel;
    }

    public void setHdDel(String hdDel) {
        this.hdDel = hdDel == null ? null : hdDel.trim();
    }
}