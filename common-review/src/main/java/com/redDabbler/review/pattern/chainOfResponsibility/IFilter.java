package com.redDabbler.review.pattern.chainOfResponsibility;

public interface IFilter {

    void process(Request request, Response response, FilterChain filterChain);

}