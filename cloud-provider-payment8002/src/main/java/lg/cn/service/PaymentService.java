package lg.cn.service;

import lg.cn.entity.Payment;


public interface PaymentService {

    public Payment getPaymentById(Long id);

    public Integer addPayment(Payment payment);
}
