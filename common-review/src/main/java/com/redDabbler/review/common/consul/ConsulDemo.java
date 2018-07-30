package com.redDabbler.review.common.consul;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.Member;
import com.ecwid.consul.v1.agent.model.NewService;
import com.ecwid.consul.v1.agent.model.Service;
import com.ecwid.consul.v1.health.model.HealthService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Map;

@Slf4j
public class ConsulDemo {

    ConsulClient consulClient = new ConsulClient("10.10.50.195");
    @Test
    public void member(){

        Response<List<Member>> memembers =  consulClient.getAgentMembers();
        log.info("response:{}",memembers);
    }

    @Test
    public void regerst(){
        NewService newService = new NewService();
        newService.setName("test_host");
        newService.setAddress("10.10.50.195");
        newService.setTags(Lists.newArrayList("mysql","prometheus-target"));
        newService.setPort(9104);
//        NewService.Check check = new   NewService.Check();
//        check.setHttp("http://10.10.50.195:9090/metrics");
//        check.setInterval("15s");
//        newService.setCheck(check);
        consulClient.agentServiceRegister(newService);

    }

    @Test
    public void getService(){
        Response<List<String>> response = consulClient.getCatalogDatacenters();
        log.info("response:{}",response);
        Response<Map<String, Service>> services =consulClient.getAgentServices();
        log.info("service:{}",services);

        // query for healthy services based on name (returns myapp_01 and myapp_02 if healthy)
        Response<List<HealthService>> healthyServices = consulClient.getHealthServices("test_mysql", true, QueryParams.DEFAULT);

        log.info(healthyServices.toString());
    }

}
