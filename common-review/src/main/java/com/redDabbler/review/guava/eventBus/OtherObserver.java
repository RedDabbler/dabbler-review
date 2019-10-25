package com.redDabbler.review.guava.eventBus;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OtherObserver {
    @Subscribe
    public void func(Integer msg){
      log.info("func Integer:{}",msg);
    }
}
