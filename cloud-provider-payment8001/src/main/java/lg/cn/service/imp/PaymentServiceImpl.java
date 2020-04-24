package lg.cn.service.imp;


import lg.cn.dao.*;
import lg.cn.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lg.cn.service.*;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    @SuppressWarnings("all")
    PaymentMapper paymentMapper;


    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }

    @Override
    public Integer addPayment(Payment payment) {
        return paymentMapper.addPayment(payment);
    }
}
