package lg.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitmqConsumer8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqConsumer8802.class, args);
    }
}
