package com.redDabbler.review.yaml;


import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;

/**
 * https://yaml.org/
 * https://bitbucket.org/asomov/snakeyaml/src/default/
 * https://bitbucket.org/asomov/snakeyaml/wiki/Documentation
 * snakeYaml
 */
@Slf4j
public class YamlParse {


    public void parseYml(){
        Yaml yaml = new Yaml();
        /**
         * Yaml.load(InputStream stream) detects the encoding
         * by checking the BOM (byte order mark) sequence at the beginning of the
         * stream. If no BOM is present, the utf-8 encoding is assumed.
         */
       Map data = (Map)yaml.load("hello: 25");
       log.info(data.toString());

    }
    public void parse(){
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
