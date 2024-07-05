package com.caxs.minos.domain.trans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author coffee
 * @date 2016年5月16日
 * @description 操作结果信息封装，默认操作结果是成功的
 */
public class OperateResultTrans implements Serializable {

    private static final long serialVersionUID = 1L;


    private boolean state = true;

    private boolean success = true;

    private String message = "操作成功";

    private Map<Object, Object> extendMap;

    private Map<Object, Object> data;


    public static OperateResultTrans createOperateResultModel() {
        return new OperateResultTrans();
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<Object, Object> getExtendMap() {
        if (this.extendMap == null) {
            this.extendMap = new HashMap<Object, Object>();
        }
        return extendMap;
    }

    public void setExtendMap(Map<Object, Object> extendMap) {
        this.extendMap = extendMap;
    }


    public void putValueToExtendmap(Object key, Object value) {
        this.getExtendMap().put(key, value);
    }


    public Object getValueFormExtendmap(Object key) {
        return this.getExtendMap().get(key);
    }

    public Map<Object, Object> getData() {
        if (this.data == null) {
            this.data = new HashMap<Object, Object>();
        }
        return data;
    }

    public void setData(Map<Object, Object> extendMap) {
        this.data = extendMap;
    }


    public void putValueToData(Object key, Object value) {
        this.getData().put(key, value);
    }


    public Object getValueFormData(Object key) {
        return this.getData().get(key);
    }


}
