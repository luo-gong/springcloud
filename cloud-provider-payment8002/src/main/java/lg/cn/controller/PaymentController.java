package lg.cn.controller;

import com.alibaba.druid.support.json.JSONUtils;
import lg.cn.entity.Payment;
import lg.cn.service.PaymentService;
import lg.cn.util.CommResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value(value = "${server.port}")
    public String port;

    @GetMapping("/payment/port")
    public Object getPort() {
        System.out.println("PaymentController》》》》getPort" + port);
        return port;
    }

    @GetMapping("/payment/getPayment/{id}")
    public CommResult<Payment> getPayment(@PathVariable Long id) {
        log.info("cloud-provider-payment8002>>>>PaymentController>>>getPayment>>>id>>" + id);
        CommResult<Payment> commResult = new CommResult<Payment>(200, "success");
        commResult.setData(paymentService.getPaymentById(id));
        return commResult;
    }

    @PostMapping("/payment/create")
    public CommResult<Payment> create(@RequestBody Payment payment) {
        log.info("ccloud-provider-payment8002>>>>PaymentController>>>create>>>payment>>");
        CommResult<Payment> commResult = null;
        if (paymentService.addPayment(payment) > 0) {
            commResult = new CommResult<Payment>(200, "success");
        } else
            commResult = new CommResult<Payment>(500, "fail");
        return commResult;
    }
}
