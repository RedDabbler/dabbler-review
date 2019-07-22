package com.redDabbler.review.common.pattern.chainOfResponsibility;

public class SensitiveFilter implements IFilter {

    @Override
    public void process(Request request, Response response, FilterChain filterChain) {
        System.out.println(request.getRequestStr()+"--SensitiveFilter");
        filterChain.process(request,response,filterChain);
        System.out.println(response.getResponseString()+"---response--SensitiveFilter");
    }
}
