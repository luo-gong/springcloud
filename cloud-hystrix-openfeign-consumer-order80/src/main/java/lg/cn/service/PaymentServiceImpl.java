package lg.cn.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "远程调用paymentInfo_OK接口时，远程服务调用失败";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "远程调用paymentInfo_TimeOut接口时，远程服务调用失败";

    }
}
