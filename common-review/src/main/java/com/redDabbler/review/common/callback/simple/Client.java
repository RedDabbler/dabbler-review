package com.redDabbler.review.common.callback.simple;

import com.redDabbler.review.common.callback.ICallback;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {


    public void getServerhandler(){
        ServerHandler serverHandler = new ServerHandler();
        serverHandler.setResponse("response");
        serverHandler.doSomething(new ICallback() {
            @Override
            public void success(String response) {
                log.info("success doSomething,get response:{}",response);

            }

            @Override
            public void fail(String response) {
                log.info("fail doSomething");
            }
        });
    }


    public static  void main(String[]args){
        Client client = new Client();
        client.getServerhandler();
    }


}
