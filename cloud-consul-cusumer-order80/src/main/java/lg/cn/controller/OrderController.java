package lg.cn.controller;

import lg.cn.entity.Payment;
import lg.cn.util.CommResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    private static String url = "http://cloud-consul-provider-payment8004/payment/";
    @Autowired
    @SuppressWarnings("all")
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/cusumer/consul")
    public Object consul() {
        discoveryClient.getServices().forEach(IDs -> {
            System.out.println(IDs);
        });
        String forObject = restTemplate.getForObject(url + "consul", String.class);
        return forObject;
    }
}
