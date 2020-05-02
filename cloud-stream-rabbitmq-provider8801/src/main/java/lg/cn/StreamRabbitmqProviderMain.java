package lg.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitmqProviderMain {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqProviderMain.class, args);
    }

}
