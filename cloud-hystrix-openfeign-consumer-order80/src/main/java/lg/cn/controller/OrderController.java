package lg.cn.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import lg.cn.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//@DefaultProperties(defaultFallback = "global_FallbackMethod")//设置全局默认异常回调方法
public class OrderController {

    @Resource
    PaymentService paymentService;

    @GetMapping("/customer/payment/hystrix/ok/{id}")
//    @HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
//        int i = 1 / 0;
        return paymentService.paymentInfo_OK(id);
    }

    //    @HystrixCommand(fallbackMethod = "getByIdFallback", commandProperties = {
//            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "1500")
//    })
    @GetMapping("/customer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentService.paymentInfo_TimeOut(id);
    }

    private String getByIdFallback(Integer id) {
        return "线程名称：" + Thread.currentThread().getName() +
                "paymentInfo_TimeOut,id: " + id + "\t " + "服务繁忙请重试 /(ㄒoㄒ)/~";
    }

    /**
     * 全局兜底方法
     *
     * @return
     */
    private String global_FallbackMethod() {
        return "服务繁忙请重试 /(ㄒoㄒ)/~";
    }


}
