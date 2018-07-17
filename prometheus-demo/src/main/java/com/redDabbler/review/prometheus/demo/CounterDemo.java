package com.redDabbler.review.prometheus.demo;

import io.prometheus.client.Counter;

public class CounterDemo {

    static final Counter requests = Counter.build()
            .name("requests_total").help("Total requests.").register();

    void processRequest() {
        requests.inc();
        // Your
    }

    public static void main(String[] args) {
        CounterDemo demo = new CounterDemo();
        demo.processRequest();
    }
}
