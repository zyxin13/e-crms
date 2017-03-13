package com.abc.crms.web.bean;

import java.util.HashMap;
import java.util.Map;

public class SimpleResponse implements Response {
    protected boolean ok = true;
    protected String message;
    protected int code;
    protected Map<String, Object> dataMap = new HashMap();

    public SimpleResponse() {
    }

    public void addKey(String key, Object value) {
        if(this.dataMap.get(key) != null) {
            this.dataMap.remove(key);
        }

        this.dataMap.put(key, value);
    }

    public void clearContent() {
        this.dataMap.clear();
    }

    public boolean isContainsKey(String key) {
        return this.dataMap.containsKey(key);
    }

    public void removeKey(String key) {
        this.dataMap.remove(key);
    }

    public Map<String, Object> getDataMap() {
        return this.dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public boolean isOk() {
        return this.ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getDataValue(String key) {
        return this.dataMap.get(key);
    }

    public boolean getBoolean(String key) {
        Object v = this.getDataValue(key);
        return v != null;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}