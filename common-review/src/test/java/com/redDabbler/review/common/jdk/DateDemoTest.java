package com.redDabbler.review.common.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;

import static org.junit.Assert.*;

@Slf4j
public class DateDemoTest {


    DateDemo dateDemo;

    @BeforeClass
    public static void beforeClass(){
        log.info("@beforeClass invoke beforeClass method");
    }

    @Before
    public void init(){
        log.info("@Before invoke init method");
        dateDemo = new DateDemo();
    }

    @Test
    public void testDayOfWeek() {
        log.info("test");
        dateDemo.testDayOfWeek();
    }

    @After
    public void complete(){
        log.info("@After complete  method");
    }

    @AfterClass
    public static void destory(){
        log.info("@AfterClass destory  method");
    }
}