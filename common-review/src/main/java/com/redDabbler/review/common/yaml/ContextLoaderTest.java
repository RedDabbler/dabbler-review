package com.redDabbler.review.common.yaml;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ContextLoaderTest {

    @Test
    public void testClassContextLoader(){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        classLoader.getResource("connect.yml");
        Enumeration<URL> urls = null;
        try {
            urls =  classLoader.getResources("connect.yml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (urls.hasMoreElements()){
            URL url= urls.nextElement();
            System.out.println("url:"+url);
        }

    }
}
