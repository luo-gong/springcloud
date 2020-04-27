package lg.cn.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    //    @LoadBalanced  //开启轮询
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
