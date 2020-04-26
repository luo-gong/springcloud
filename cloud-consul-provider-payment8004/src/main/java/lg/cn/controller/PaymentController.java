package lg.cn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @Value(value = "${server.port}")
    public String port;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul() {
        return "cloud-consul-provider-payment8004: " + port + "\t   " + UUID.randomUUID().toString();
    }

}
