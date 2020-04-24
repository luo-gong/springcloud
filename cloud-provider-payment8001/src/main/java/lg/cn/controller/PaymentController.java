package lg.cn.controller;

import lg.cn.entity.Payment;
import lg.cn.service.PaymentService;
import lg.cn.util.CommResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;
    @Value(value = "${server.port}")
    public String port;

    @Autowired
    @SuppressWarnings("all")
    DiscoveryClient discoveryClient;//服务发现


    @GetMapping("/payment/discovery")
    public Object discoveryClient() {
        discoveryClient.getServices().forEach(client -> {
            log.info("PaymentController>>>>>discoveryClient>>>>" + client);
            discoveryClient.getInstances(client).forEach(serviceInstance -> {
                log.info("PaymentController>>>>>discoveryClient>>>>getServiceId:"
                        + serviceInstance.getServiceId() + ">>>>getHost:"
                        + serviceInstance.getHost() + ">>>getPort:"
                        + serviceInstance.getPort() + ">>>>getUri:" +
                        serviceInstance.getUri());
            });
        });//获取所有服务

        return this.discoveryClient;
    }

    @GetMapping("/payment/port")
    public Object getPort() {
        return port;
    }

    @GetMapping("/payment/getPayment/{id}")
    public CommResult<Payment> getPayment(@PathVariable Long id) {
        log.info("cloud-payment8001>>>>PaymentController>>>getPayment>>>id>>" + id);
        CommResult<Payment> commResult = new CommResult<Payment>(200, "success");
        commResult.setData(paymentService.getPaymentById(id));
        return commResult;
    }

    @PostMapping("/payment/create")
    public CommResult<Payment> create(@RequestBody Payment payment) {
        log.info("cloud-payment" + "8001>>>>PaymentController>>>create>>>payment>>");
        CommResult<Payment> commResult = null;
        if (paymentService.addPayment(payment) > 0) {
            commResult = new CommResult<Payment>(200, "success");
        } else
            commResult = new CommResult<Payment>(500, "fail");
        return commResult;
    }
}
