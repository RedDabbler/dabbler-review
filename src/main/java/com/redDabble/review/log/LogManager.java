package com.redDabble.review.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by whh on 2017/11/9.
 */
public class LogManager {
    private static Logger LOG = LoggerFactory.getLogger(LogManager.class);

    public static void testLog(){
        LOG.info("hello,{}",LOG.getName());
    }
}