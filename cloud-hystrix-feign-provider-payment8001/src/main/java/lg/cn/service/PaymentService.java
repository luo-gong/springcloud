package lg.cn.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
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
}
