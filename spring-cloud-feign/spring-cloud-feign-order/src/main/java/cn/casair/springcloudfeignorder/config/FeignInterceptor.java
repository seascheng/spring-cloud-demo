package cn.casair.springcloudfeignorder.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignInterceptor implements RequestInterceptor {

    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("token", "123456");
    }
}
