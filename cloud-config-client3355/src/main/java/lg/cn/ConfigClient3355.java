package lg.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * springcloud bus 消息总线
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3355.class, args);
    }
}
