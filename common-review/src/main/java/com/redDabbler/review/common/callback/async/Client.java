package com.redDabbler.review.common.callback.async;

import com.redDabbler.review.common.callback.ICallback;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {

    public void handler(){
        Server server = new Server();
        server.setResponse("yestday");
        server.getAnswer(new ICallback() {
            @Override
            public void success(String response) {
                log.info("success ",response);
            }

            @Override
            public void fail(String response) {
                log.info("fail ",response);

            }
        },"123");
    }


    public static void main(String[]args){
        Client client = new Client();
        client.handler();;

    }

}
