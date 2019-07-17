package com.redDabbler.review.common.socket;

import org.junit.Test;

import static org.junit.Assert.*;

public class SocketServerDemoTest {
    SocketServerDemo socketServerDemo = new SocketServerDemo();

    @Test
    public void connect() {
        socketServerDemo.connect();
    }
}