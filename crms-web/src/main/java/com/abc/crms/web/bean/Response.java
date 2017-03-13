package com.abc.crms.web.bean;

import java.util.Map;

public interface Response {
    boolean isOk();

    void setOk(boolean var1);

    Map<String, Object> getDataMap();

    String getMessage();

    void setMessage(String var1);

    Object getDataValue(String var1);

    boolean getBoolean(String var1);

    void addKey(String var1, Object var2);

    void clearContent();

    boolean isContainsKey(String var1);

    int getCode();

    void setCode(int var1);
}