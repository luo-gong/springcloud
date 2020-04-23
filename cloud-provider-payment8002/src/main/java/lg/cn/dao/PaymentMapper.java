package lg.cn.dao;

import lg.cn.entity.Payment;

import java.util.List;

public interface PaymentMapper {

    public Payment getPaymentById(Long id);

    public Integer addPayment(Payment payment);
}
