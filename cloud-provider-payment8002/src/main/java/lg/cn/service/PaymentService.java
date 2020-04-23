package lg.cn.service;

import lg.cn.entity.Payment;

import java.util.List;

public interface PaymentService {

    public Payment getPaymentById(Long id);

    public Integer addPayment(Payment payment);
}
