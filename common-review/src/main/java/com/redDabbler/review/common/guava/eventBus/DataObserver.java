package com.redDabbler.review.common.guava.eventBus;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataObserver {


    /***
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * @param msg
     */
    @Subscribe
    public void func(String msg){

        log.info("func String:{}",msg);
    }
}
