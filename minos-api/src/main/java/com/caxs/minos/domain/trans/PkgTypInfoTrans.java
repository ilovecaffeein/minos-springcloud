package com.caxs.minos.domain.trans;

import com.caxs.minos.domain.PkgTyp;
import com.caxs.minos.domain.PkgTypDtl;

import java.io.Serializable;

/**
 * Created by lenovo on 2020/9/30.
 */
public class PkgTypInfoTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;

    private PkgTyp pkgTyp; //包类型
    private PkgTypDtl[] pkgTypDtlArr; //包类型明细

    //获取包类型
    public PkgTyp getPkgTyp() {
        return pkgTyp;
    }
    //包类型信息构造方法
    public PkgTypInfoTrans(PkgTyp pkgTyp, PkgTypDtl[] pkgTypDtlArr) {
        super();
        this.pkgTyp = pkgTyp;
        this.pkgTypDtlArr = pkgTypDtlArr;
    }
    //获取包类型明细
    public PkgTypDtl[] getPkgTypDtlArr() {
        return pkgTypDtlArr;
    }
}
