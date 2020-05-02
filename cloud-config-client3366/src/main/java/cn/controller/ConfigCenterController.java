package cn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigCenterController {
    @Value(value = "${config.info}")
    String configInfo;

    @GetMapping("/getConfigInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
