package cn.casair.springcloudribbonorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringCloudRibbonOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonOrderApplication.class, args);
    }

    @Configuration
    class MyConfiguration {
        @LoadBalanced
        @Bean
        RestTemplate restTemplate() {
            // 默认 RestTemplate 是无负载功能的，所以需要重新定义 RestTemplate 申请成 @LoadBalanced（默认情况是轮训）
            return new RestTemplate();
        }
    }
}
