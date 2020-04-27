package lg.cn.controller;

import com.netflix.discovery.converters.Auto;
import lg.cn.entity.Payment;
import lg.cn.lbCustomer.ILoadBalancerCustomer;
import lg.cn.util.CommResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    private static String url = "http://cloud-provider-payment/payment/";
    @Autowired
    @SuppressWarnings("all")
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    ILoadBalancerCustomer iLoadBalancerCustomer;

    @GetMapping("/consumer/payment/getPayment/{id}")
    public CommResult<Payment> getPayment(@PathVariable Long id) {
        log.info("cloud-consumer-order80>>>>OrderController>>>getPayment>>>id>>" + id);
        CommResult<Payment> commResult = restTemplate.getForObject("getPayment" + url + id, CommResult.class);
        return commResult;
    }

    @PostMapping("/consumer/payment/create")
    public CommResult<Payment> create(@RequestBody Payment payment) {
        log.info("cloud-consumer-order80>>>>OrderController>>>create>>");
        CommResult<Payment> commResult = restTemplate.postForObject(url + "create", payment, CommResult.class);
        return commResult;
    }

    @GetMapping("/payment/port")
    public Object getPort() {
        String forObject = restTemplate.getForObject(url + "port", String.class);
        return forObject;
    }

    /**
     * 自定义轮询算法测试
     *
     * @return
     */
    @GetMapping("/consumer/port/lb")
    public Object lb() {
        Integer instances = null;
        url = iLoadBalancerCustomer.getServer(discoveryClient.getInstances("cloud-provider-payment")).getUri() + "/payment/port";
        String forObject = restTemplate.getForObject(url, String.class);
        return forObject;
    }
}
