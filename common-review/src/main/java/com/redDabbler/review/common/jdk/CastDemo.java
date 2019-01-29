package com.redDabbler.review.common.jdk;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CastDemo {

    public void test(){
        Object[] values = new Object[3];
        values[0] = 1243;
        int count = 0;
        for (Object value : values) {
            if (value != null) {
             //   count=count+(int)value; // 直接强转编译问题
            }
        }
    }

    /**
     * shift operator
     */
    public void testValue(){
        log.info("2<<2 value:{}",2<<2);
        System.out.println(2<<2);
        System.out.println(2>>2);
    }
}
