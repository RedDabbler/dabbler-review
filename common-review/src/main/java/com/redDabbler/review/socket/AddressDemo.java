package com.redDabbler.review.socket;

import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
@Slf4j
public class AddressDemo {

    public void inetSocketAddressDemo(){
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8088);
        log.info(inetSocketAddress.getHostName());
        log.info(inetSocketAddress.getHostString());
        log.info(String.valueOf(inetSocketAddress.isUnresolved()));

        InetSocketAddress inetSocketAddress1 = new InetSocketAddress(6666);
        log.info(inetSocketAddress1.getHostName());
        log.info(inetSocketAddress1.getHostString());
        log.info(String.valueOf(inetSocketAddress1.isUnresolved()));
    }
}
