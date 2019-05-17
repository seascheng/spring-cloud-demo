package cn.casair.springcloudribbonproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudRibbonProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonProductApplication.class, args);
    }

}
