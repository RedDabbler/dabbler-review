package com.redDabbler.review.common.jdk;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 日期转换经常碰到的坑
 */
@Slf4j
public class DateDemo {

    public void testDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        // 1表示周日 依次往后
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);// 这是比较坑的地方

        log.info("dayOfWeek:{}",dayOfWeek);

        //calendar.set(Calendar.DAY_OF_WEEK,-1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     //   System.out.println(simpleDateFormat.format(calendar.getTime()));
        log.info("simpleDateFormat:{}",simpleDateFormat.format(calendar.getTime()));
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

       // System.out.println("dayOfMonth:" + dayOfMonth);
        log.info("dayOfMonth:{}",dayOfMonth);


    }
}
