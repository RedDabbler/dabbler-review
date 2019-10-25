package com.redDabbler.review.pattern.chainOfResponsibility;

public class OtherFilter implements IFilter {

    @Override
    public void process(Request request, Response response, FilterChain filterChain) {
        System.out.println(request.getRequestStr()+"--OtherFilter");
        filterChain.process(request,response,filterChain);
        System.out.println(response.getResponseString()+"--response---OtherFilter");
    }
}
