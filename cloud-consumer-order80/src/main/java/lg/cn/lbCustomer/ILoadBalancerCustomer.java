package lg.cn.lbCustomer;

import com.netflix.loadbalancer.Server;
import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义轮询算法
 */
public interface ILoadBalancerCustomer {
    /**
     * 根据算法返回相应的服务
     *
     * @param serviceInstances 获取所有的服务
     * @return
     */
    public ServiceInstance getServer(List<ServiceInstance> serviceInstances);
}
