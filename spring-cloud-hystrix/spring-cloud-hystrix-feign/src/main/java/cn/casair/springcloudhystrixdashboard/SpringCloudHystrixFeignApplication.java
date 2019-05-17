package cn.casair.springcloudhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"cn.casair.springcloudhystrixdashboard.api"})
@EnableDiscoveryClient
public class SpringCloudHystrixFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudHystrixFeignApplication.class, args);
    }

}
