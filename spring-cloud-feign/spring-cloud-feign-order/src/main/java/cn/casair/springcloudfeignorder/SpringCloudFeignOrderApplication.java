package cn.casair.springcloudfeignorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringCloudFeignOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignOrderApplication.class, args);
    }

}
