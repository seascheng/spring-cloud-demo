package cn.casair.springcloudconsulconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerClient {
    private final DiscoveryClient discoveryClient;

    @Autowired
    public ProducerClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping("/services")
    public Object service() {
        return discoveryClient.getInstances("consul-producer");
    }

    @RequestMapping("/discover")
    public Object discover() {
        ServiceInstance serviceInstance = discoveryClient.getInstances("consul-producer").get(0);
        return serviceInstance.getUri().toString();
    }
}
