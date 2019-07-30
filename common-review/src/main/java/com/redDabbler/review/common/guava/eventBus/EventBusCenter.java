package com.redDabbler.review.common.guava.eventBus;

import com.google.common.eventbus.EventBus;

public class EventBusCenter {

    private static EventBus eventBus = new EventBus();


    public static EventBus getEventBus(){
        return  eventBus;
    }

    public static void register(Object obj){
        eventBus.register(obj);
    }

    public static void unregister(Object obj){
        eventBus.unregister(obj);
    }

    public static void post(Object obj){
        eventBus.post(obj);
    }

}
