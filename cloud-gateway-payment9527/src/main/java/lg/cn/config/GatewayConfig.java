package lg.cn.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

/**
 * 配置文件的方式配置路由
 */
//@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("wangyiyun", r ->
                        r.path("/**")
                                .and()
                                .after(ZonedDateTime.parse("2020-04-01T09:51:17.734+08:00[Asia/Shanghai]"))
//                        .and()
//                        .cookie("crul", "get")
                                .uri("http://music.163.com/")
        ).build();
        return routes.build();
    }


}
