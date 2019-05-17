package cn.casair.springcloudhystrixdashboard.api;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductClientFallbackFactory implements FallbackFactory<ProducerClient> {

    public ProducerClient create(final Throwable throwable) {
        return new ProducerClient() {
            public String producer() {
                System.out.println("Fallback, Reason: "+throwable);
                return "Service Producer Unavailable";
            }
        };
    }
}
