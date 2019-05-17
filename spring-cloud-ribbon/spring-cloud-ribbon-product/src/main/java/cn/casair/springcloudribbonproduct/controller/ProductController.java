package cn.casair.springcloudribbonproduct.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Value("${server.port}")
    private int port;

    @GetMapping
    public String query() {
        return "port : " + port;
    }

    @GetMapping("/{id}")
    public String query(@PathVariable Long id) {
        return id + "：Spring Boot...";
    }

    @GetMapping("/token/{id}")
    public String queryWithToken(@PathVariable Long id, @RequestHeader String token) {
        return id + "：Spring Boot..., token = " + token;
    }
}
