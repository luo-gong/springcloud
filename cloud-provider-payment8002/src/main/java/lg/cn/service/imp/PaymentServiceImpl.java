package lg.cn.service.imp;

//import com.netflix.discovery.converters.Auto;

import lg.cn.dao.PaymentMapper;
import lg.cn.entity.Payment;
import lg.cn.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.List;

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
