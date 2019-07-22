package com.redDabbler.review.common.pattern.chainOfResponsibility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Handler {

    public static String process1(String str){
        log.info("process1");
        return "";
    }

    public static String process2(String str){
        log.info("process2");
        return "";
    }

    public static void main(String[]args){
        String str = "<script>,party p";
    //    process1(str);
     //   process2(str);

        FilterChain filterChain = new FilterChain();

        filterChain.addFilter(new OtherFilter()).addFilter(new SensitiveFilter());
        filterChain.addFilter(new SensitiveFilter());

        Request request = new Request();
        Response response = new Response();
        response.setResponseString("test");
        filterChain.process(request,response,filterChain);




    }
}
