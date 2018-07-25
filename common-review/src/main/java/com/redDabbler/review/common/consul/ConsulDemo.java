package com.redDabbler.review.common.consul;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

@Slf4j
public class ConsulDemo {

    @Test
    public void demo(){
        ConsulClient consulClient = new ConsulClient("10.10.50.195");
        Response<List<Member>> memembers =  consulClient.getAgentMembers();
        log.info("response:{}",memembers);

    }
}
