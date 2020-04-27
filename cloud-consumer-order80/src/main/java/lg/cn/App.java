package lg.cn;

import lg.ribbonRule.MyIRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RibbonClient(name = "cloud-provider-payment", configuration = MyIRule.class)//配置ribbon的负载均衡策略（轮询，随机，加权，尝试）
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
