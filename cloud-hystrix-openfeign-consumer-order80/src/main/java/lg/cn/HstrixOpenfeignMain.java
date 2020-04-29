package lg.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"lg.cn.service"})
@EnableCircuitBreaker
public class HstrixOpenfeignMain {
    public static void main(String[] args) {
        SpringApplication.run(HstrixOpenfeignMain.class, args);
    }
}
