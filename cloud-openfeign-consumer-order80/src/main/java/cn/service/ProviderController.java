package cn.service;

import lg.cn.entity.Payment;
import lg.cn.util.CommResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("cloud-provider-payment")
@Component
public interface ProviderController {

    @GetMapping("/payment/getPayment/{id}")
    public CommResult<Payment> getPayment(@PathVariable(value = "id") Long id);

    /**
     * openfeign超时测试
     */
    @GetMapping("/payment/openfeignOutTime")
    public Object openfeignOutTime() throws InterruptedException;
}
