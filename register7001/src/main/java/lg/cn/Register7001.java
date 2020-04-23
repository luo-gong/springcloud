package lg.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Register7001 {
    public static void main(String args[]) {
        SpringApplication.run(Register7001.class, args);
    }
}
