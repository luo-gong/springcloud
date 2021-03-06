package lg.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 */
@SpringBootApplication
@MapperScan(basePackages = {"lg.cn.dao"})
@EnableEurekaClient
@EnableDiscoveryClient//开启服务发现
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
