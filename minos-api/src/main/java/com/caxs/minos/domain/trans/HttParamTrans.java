package com.caxs.minos.domain.trans;

import java.io.Serializable;

/**
 * Created by coffee on 2020/9/1.
 */
public class HttParamTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;
    //请求参数
    private String key;
    //参数值
    private String value;

    public HttParamTrans() {

    }

    public HttParamTrans(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
