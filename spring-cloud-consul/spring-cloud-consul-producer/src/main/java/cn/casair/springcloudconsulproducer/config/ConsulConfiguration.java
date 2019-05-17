package cn.casair.springcloudconsulproducer.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsulConfiguration {

    @Value("${server.port}")
    private int serverPort;

    @Bean
    public ApplicationListener<ApplicationReadyEvent> consulServiceRegistryRegister(ConsulAutoServiceRegistration consulAutoServiceRegistration) {
        return event -> {
            consulAutoServiceRegistration.setPort(serverPort);
            consulAutoServiceRegistration.start();
        };
    }
}
