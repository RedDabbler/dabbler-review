package com.redDabbler.review.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogManager {
    private static Logger LOG = LoggerFactory.getLogger(LogManager.class);

    public static void testLog(){
        LOG.info("hello,{}",LOG.getName());
    }
}