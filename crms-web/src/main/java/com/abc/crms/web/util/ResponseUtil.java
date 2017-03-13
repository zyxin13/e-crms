package com.abc.crms.web.util;

import com.abc.crms.web.bean.Response;
import com.abc.crms.web.bean.SimpleResponse;

/**
 * Created by yuxin.zou on 2017/3/13.
 */
public class ResponseUtil {
    public static Response getResponse() {
        return new SimpleResponse();
    }

    public static Response setErrorMsg(Response res,String message) {
        res.setCode(500);
        res.setOk(Boolean.FALSE);
        res.setMessage(message);
        return res;
    }

    public static Response setSuccessMsg(Response res,String message) {
        res.setCode(200);
        res.setOk(Boolean.TRUE);
        res.setMessage(message);
        return  res;
    }
}
