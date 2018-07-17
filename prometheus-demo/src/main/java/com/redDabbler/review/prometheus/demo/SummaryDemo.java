package com.redDabbler.review.prometheus.demo;

import io.prometheus.client.Summary;

public class SummaryDemo {

    static final Summary receivedBytes = Summary.build()
            .name("requests_size_bytes").help("Request size in bytes.").register();
    static final Summary requestLatency = Summary.build()
            .name("requests_latency_seconds").help("Request latency in seconds.").register();

//    void processRequest(Request req) {
//        Summary.Timer requestTimer = requestLatency.startTimer();
//        try {
//            // Your code here.
//        } finally {
//            receivedBytes.observe(req.size());
//            requestTimer.observeDuration();
//        }
//    }
}
