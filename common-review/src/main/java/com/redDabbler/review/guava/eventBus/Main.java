package com.redDabbler.review.guava.eventBus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String []args){
        DataObserver observer = new DataObserver();
        OtherObserver otherObserver = new OtherObserver();
        EventBusCenter.register(observer);
        EventBusCenter.register(otherObserver);
        log.info("=============start================");
        EventBusCenter.post("tommorrow");
        EventBusCenter.post(23);

        EventBusCenter.unregister(otherObserver);
        EventBusCenter.post("aggion");
        EventBusCenter.post(555);

        log.info("===============end================");
    }

}
