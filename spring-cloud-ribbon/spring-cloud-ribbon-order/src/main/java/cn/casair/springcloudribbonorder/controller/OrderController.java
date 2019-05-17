package cn.casair.springcloudribbonorder.controller;

import cn.casair.springcloudribbonorder.config.RibbonRuleConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
@RibbonClient(name = "ribbonRule", configuration = RibbonRuleConfiguration.class)
public class OrderController {

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    @Autowired
    public OrderController(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping
    public String query() {
        final List<String> services = discoveryClient.getServices();
        for (String service : services) {
            List<ServiceInstance> list = discoveryClient.getInstances(service);
            for (ServiceInstance instance : list) {
                System.out.println(instance.getUri() + "/" +service + "-" + instance.getServiceId());
            }
        }
//        RIBBON-PRODUCT 为Eureka的客户端id
//        解码：通过 serviceId 找到对应的客户端，
//        然后根据客户端配置的负载算法从对应集合中
//        找出符合当前算法条件的结果，最后拼接出相应的 http 地址即可
        return restTemplate.getForObject("http://RIBBON-PRODUCT/products", String.class);
    }


}
