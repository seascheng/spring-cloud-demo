package cn.casair.springcloudgatewaygw.config;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public interface KeyResolver {
    Mono<String> userKeyResolver(ServerWebExchange exchange);
}
