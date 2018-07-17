package com.redDabbler.review.prometheus.demo;

import io.prometheus.client.hotspot.DefaultExports;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnablePrometheusEndpoint
public class PrometheusApplicaion implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(PrometheusApplicaion.class, args);
        DefaultExports.initialize();
    }

    public void run(String... strings) throws Exception {

    }

}
