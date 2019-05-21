package cn.casair.springcloudgweurekaproducer2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Value("${server.port}")
    private int port;

    @Value("${spring.application.name}")
    String applicationName;

    @GetMapping
    public String query() {
        return "port : " + port + " applicationName: "+applicationName;
    }

    @GetMapping("/{id}")
    public String query(@PathVariable Long id) {
        return id + "：Spring Boot..." + "\n\r"+"port : " + port + " applicationName: "+applicationName;
    }

    @RequestMapping("/foo")
    public String foo(String foo) {
        return "hello "+foo+"!"+ "\n\r"+"port : " + port + " applicationName: "+applicationName;
    }

    @GetMapping("/token/{id}")
    public String queryWithToken(@PathVariable Long id, @RequestHeader String token) {
        return id + "：Spring Boot..., token = " + token;
    }
}

