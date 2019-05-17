package cn.casair.springcloudhystrixdashboard.controller;

import cn.casair.springcloudhystrixdashboard.api.ProducerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    private final ProducerClient producerClient;

    @Autowired
    public FeignController(ProducerClient producerClient) {
        this.producerClient = producerClient;
    }

    @RequestMapping("/producer")
    public String producer(){
        return producerClient.producer();
    }
}
