package com.redDabbler.review.common.pattern.chainOfResponsibility;

public interface IFilter {

    void process(Request request, Response response, FilterChain filterChain);

}