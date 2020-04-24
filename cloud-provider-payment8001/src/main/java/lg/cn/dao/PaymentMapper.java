package lg.cn.dao;

import lg.cn.entity.Payment;

public interface PaymentMapper {

    public Payment getPaymentById(Long id);

    public Integer addPayment(Payment payment);
}
