package lg.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient//开启服务发现
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
