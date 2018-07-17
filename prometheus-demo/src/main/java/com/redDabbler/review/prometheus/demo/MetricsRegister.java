package com.redDabbler.review.prometheus.demo;

import io.prometheus.client.Gauge;

public class MetricsRegister {
    static final Gauge activeTransactions = Gauge.build()
            .name("my_library_transactions_active")
            .help("Active transactions.")
            .register();

    void processThatCalculates(String key) {
        activeTransactions.inc();
        try {
            // Perform work.
        } finally{
            activeTransactions.dec();
        }
    }
}
