package cn.casair.springcloudhystrixdashboard.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "consul-producer", fallbackFactory = ProductClientFallbackFactory.class)
public interface ProducerClient {

    @RequestMapping("/producer")
    String producer();

}
