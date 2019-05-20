package cn.casair.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 启用了refresh配置文件的功能
// 配置文件变动后，先执行post请求：
//  curl -X POST http://localhost:8521/actuator/refresh
// 再刷新接口，/env即可拿到最新的配置

@RestController
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class ConfigClientController {

    @Value("${config.env}")
    private String env;

    @RequestMapping("/env")
    public String env() {
        return this.env;
    }
}
