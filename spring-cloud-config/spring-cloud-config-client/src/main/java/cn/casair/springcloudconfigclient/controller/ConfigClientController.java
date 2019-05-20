package cn.casair.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 启用了refresh配置文件的功能
// 配置文件变动后，先执行post请求：
//  curl -X POST http://localhost:8521/actuator/refresh  （8521是该client的port）
// 当前客户端在调用RefreshScope的接口时，即获取最新配置

// 但如果使用spring cloud bus。就可以执行server端请求后：
// curl -X POST http://localhost:8520/actuator/bus-refresh/  （8520是server的port）
// 所有客户端在调用RefreshScope的接口时，即全部获取最新配置
@RestController
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class ConfigClientController {

    @Value("${config.env}")
    private String env;

    @RequestMapping("/env")
    public String env() {
        System.out.println("当前使用的env："+this.env);
        return this.env;
    }
}
