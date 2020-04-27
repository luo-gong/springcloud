package lg.ribbonRule;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置ribbon的负载均衡机制
 */
@Configuration
public class MyIRule {

    @Bean
    RandomRule randomRule() {
        return new RandomRule();
    }

}
