package cn.controller;

import cn.service.ProviderController;
import lg.cn.entity.Payment;
import lg.cn.util.CommResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class OrderController {
    @Autowired
    ProviderController providerController;

    @GetMapping("/consumer/payment/getPayment/{id}")
    public CommResult<Payment> getPayment(@PathVariable Long id) {
        log.info("cloud-consumer-order80>>>>OrderController>>>getPayment>>>id>>" + id);
        return providerController.getPayment(id);
    }

    /**
     * openfeign超时测试
     */
    @GetMapping("/customer/payment/openfeignOutTime")
    public Object openfeignOutTime() throws InterruptedException {
        return providerController.openfeignOutTime();
    }
}
