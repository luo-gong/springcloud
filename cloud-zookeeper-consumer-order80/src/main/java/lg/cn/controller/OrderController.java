package lg.cn.controller;

import lg.cn.entity.Payment;
import lg.cn.util.CommResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    private static String url = "http://cloud-zookeeper-provider-payment8003/";
    @Autowired
    @SuppressWarnings("all")
    RestTemplate restTemplate;


    @GetMapping("/consumer/zookeeper")
    public Object getPort() {
        String forObject = restTemplate.getForObject(url + "payment/zookeeper", String.class);
        return forObject;
    }
}
