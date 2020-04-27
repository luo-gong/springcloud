package lg.cn.lbCustomer;

import com.netflix.loadbalancer.Server;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义轮询算法
 */
@Component
public class ILoadBalancerCustomerImpl implements ILoadBalancerCustomer {
    //用于原子计数
    private AtomicInteger atomicInteger = new AtomicInteger(0);


    /**
     * @return 返回第几次访问
     */
    private final int incrementAndGetModulo() {
        int current = atomicInteger.get();//获取当前第几次访问
        Integer next = null;
        for (; ; ) {
            next = current >= 2147483647 ? 0 : current + 1;
            if (atomicInteger.compareAndSet(current, next)) {
                System.out.println("next>>>>" + next);
                return next;
            }
        }
    }

    public ServiceInstance getServer(List<ServiceInstance> servers) {
        int index = incrementAndGetModulo() % servers.size();
        return servers.get(index);
    }
}
