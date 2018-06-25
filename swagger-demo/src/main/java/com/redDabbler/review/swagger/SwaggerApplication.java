package com.redDabbler.review.swagger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(value = {"com.redDabbler.review"})
@ServletComponentScan
public class SwaggerApplication {

        private static final Logger logger = LoggerFactory.getLogger(SwaggerApplication.class);
        private static ConfigurableApplicationContext ctx;

        public static void main(String[] args) {
            ctx =  SpringApplication.run(SwaggerApplication.class, args);
            logger.info("server start");
        }
}
