package com.redDabbler.review.pattern.callback.async;

import com.redDabbler.review.pattern.callback.ICallback;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
@Slf4j
public class Server {

    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void  getAnswer(ICallback callback, String request){
        log.info("get request:{}",request);
        if("doSomething".equalsIgnoreCase(request)){
            callback.success(response);
        }else{
            if("123".equalsIgnoreCase(request)){
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                callback.success("tommorry");
            }else{
                callback.success("");
            }

        }

    }
}
