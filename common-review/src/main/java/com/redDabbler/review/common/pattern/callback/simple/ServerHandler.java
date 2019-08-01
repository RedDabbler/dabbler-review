package com.redDabbler.review.common.pattern.callback.simple;


import com.redDabbler.review.common.pattern.callback.ICallback;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServerHandler {

    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void doSomething(ICallback callback){
        log.info("doSomethings");
        // 成功
        callback.success(response);

        // 失败
        callback.fail(response);

    }



}