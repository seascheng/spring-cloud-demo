package cn.casair.springcloudfeignorder.controller;

import cn.casair.springcloudfeignorder.api.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    // 注解式HTTP请求Feign
    private final ProductClient productClient;

    @Autowired
    public OrderController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping
    public String query() {
        return this.productClient.selectProductById(10L);
    }

    @GetMapping("/token")
    public String queryWithToken() {
        return this.productClient.selectProductByIdWithToken(10L);
    }


}
