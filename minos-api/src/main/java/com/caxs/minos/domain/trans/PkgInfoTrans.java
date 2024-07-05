package com.caxs.minos.domain.trans;
import com.caxs.minos.domain.PkgTyp;
import com.caxs.minos.domain.PkgTypDtl;

import java.io.Serializable;

/**
 * Created by lenovo on 2020/9/30.
 */
public class PkgInfoTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;

    private String pkgTyp; // 扣款数据类型
    private String fdDel; // 字段分隔符
    private String lnDel; // 分行符号
    private String fdAlg;
    private String fdChr; // 字段符号
    private String emtSd;
    private String hdDel;
    private PkgTypDtl[] typeDtls;// 包类型明细

    // 包信息构造方法
    public PkgInfoTrans() {
        super();
    }

    // 初始化方法
    private void init() {
        // 字段分隔符
        if ("SX".equals(this.fdDel)) {
            this.fdDel = "|";
        }
        if ("DH".equals(this.fdDel)) {
            this.fdDel = ",";
        }
        if ("ZB".equals(this.fdDel)) {
            this.fdDel = "\t";
        }
        // 分行符号
        if ("HH".equals(this.lnDel)) {
            this.lnDel = "\n";
        }
        if ("HE".equals(this.lnDel)) {
            this.lnDel = "\r\n";
        }
        // 字段符号
        if ("SY".equals(this.fdChr)) {
            this.fdChr = "''";
        }
        if ("DY".equals(this.fdChr)) {
            this.fdChr = "'";
        }
        if ("DH".equals(this.fdChr)) {
            this.fdChr = ",";
        }
        if ("NL".equals(this.fdChr)) {
            this.fdChr = "";
        }
    }

    // 包信息构造方法
    public PkgInfoTrans(PkgTyp pt,PkgTypInfoTrans pkg) {
        this.emtSd = pt.getEmtSd();
        this.fdChr = (pt.getFdChr());
        this.fdAlg = (pt.getFldAlg());
        this.fdDel = (pt.getFldDel());
        this.hdDel = (pt.getHdDel());
        this.lnDel = (pt.getLnDel());
        this.pkgTyp = (pt.getPkgTyp());
        this.typeDtls =pkg.getPkgTypDtlArr();
        init();
    }

    // 获取扣款类型信息
    public String getPkgTyp() {
        return this.pkgTyp;
    }

    // 设置扣款类型信息
    public void setPkgTyp(String pkgTyp) {
        this.pkgTyp = pkgTyp;
    }

    // 获取字段分隔符
    public String getFdDel() {
        if ("SX".equals(this.fdDel)) {
            this.fdDel = "|";
        }
        if ("DH".equals(this.fdDel)) {
            this.fdDel = ",";
        }
        return this.fdDel;
    }

    // 设置字段分隔符
    public void setFdDel(String fdDel) {
        this.fdDel = fdDel;
    }

    // 获取分行符号
    public String getLnDel() {
        if ("HH".equals(this.lnDel)) {
            this.lnDel = "";
        }
        if ("HE".equals(this.lnDel)) {
            this.lnDel = "\r";
        }
        return this.lnDel;
    }

    // 设置分行符号
    public void setLnDel(String lnDel) {
        this.lnDel = lnDel;
    }

    //
    public String getFdAlg() {
        return this.fdAlg;
    }

    public void setFdAlg(String fdAlg) {
        this.fdAlg = fdAlg;
    }

    // 获取字段符号
    public String getFdChr() {
        if ("SY".equals(this.fdChr)) {
            this.fdChr = "''";
        }
        if ("DY".equals(this.fdChr)) {
            this.fdChr = "'";
        }
        if ("DH".equals(this.fdChr)) {
            this.fdChr = ",";
        }
        if ("NL".equals(this.fdChr)) {
            this.fdChr = "";
        }
        return this.fdChr;
    }

    // 设置字段符号
    public void setFdChr(String fdChr) {
        this.fdChr = fdChr;
    }

    public String getEmtSd() {
        return this.emtSd;
    }

    public void setEmtSd(String emtSd) {
        this.emtSd = emtSd;
    }

    public String getHdDel() {
        if ("MH".equals(this.hdDel)) {
            this.hdDel = ":";
        }
        return this.hdDel;
    }

    public void setHdDel(String hdDel) {
        this.hdDel = hdDel;
    }

    // 获取包类型明细
    public PkgTypDtl[] getTypeDtls() {
        return typeDtls;
    }

    // 设置包类型明细
    public void setTypeDtls(PkgTypDtl[] typeDtls) {
        this.typeDtls = typeDtls;
    }
}
