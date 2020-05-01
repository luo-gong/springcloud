package lg.cn.service;


import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@DefaultProperties(defaultFallback = "global_FallbackMethod")
public class PaymentService {
    /**
     * 正常访问，肯定OK
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程名称：" + Thread.currentThread().getName() +
                "paymentInfo_OK,id: " + id + "\t " + " O(∩_∩) O哈哈 ~";
    }

    /**
     * 线程休眠3秒
     *
     * @param id
     * @return
     * @throws InterruptedException
     */
    @HystrixCommand(fallbackMethod = "getByIdFallback",
            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "300")
                    @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "3000")
            }
    )
    public String paymentInfo_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程名称：" + Thread.currentThread().getName() +
                "paymentInfo_OK,id: " + id + "\t " + " O(∩_∩) O哈哈 ~";
    }

    private String getByIdFallback(Integer id) {
        return "线程名称：" + Thread.currentThread().getName() +
                "paymentInfo_OK,id: " + id + "\t " + " /(ㄒoㄒ)/~";
    }

    //服务熔断
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED, value = "true")
                    ,// 是否开启断路器
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "10")
                    ,// 请求次数
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "10000")
                    ,// 时间窗口期
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "60")
                    ,// 失败率达到多少后跳闸
            }
    )
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0)
            throw new RuntimeException();
        String uuid = IdUtil.randomUUID();
        return "线程名：" + Thread.currentThread().getName() + "》》UUID:" + uuid;
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
