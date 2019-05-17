package cn.casair.springcloudfeignorder.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// name：指定 FeignClient 的名称，该属性会作为微服务的名称，用于服务发现
// value：同 name 字段互通
// serviceId：指定服务ID，每个注册到注册中心上的客户端都会有对应的 serviceId 一般是 spring.application.name，与 name 和 value 互通
// url： 一般用于调试，可以指定一个详细地址（http://localhost:8080/products）
// path： 请求统一路径，可以看成 @RequestMapping("/products")
// decode404：404 错误时，调用 decoder 进行解码，否则抛出 FeignException
// fallback：发生错误时，回调 hystrix 类/方法
@FeignClient(name = "ribbon-product/products", decode404 = true)
public interface ProductClient {

    @GetMapping("/{product_id}")
    String selectProductById(@PathVariable("product_id") long productId);

    @GetMapping("/token/{product_id}")
    String selectProductByIdWithToken(@PathVariable("product_id") long productId);
}
