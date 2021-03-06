package com.acmeair;

import io.servicecomb.foundation.common.utils.Log4jUtils;
import io.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication(scanBasePackages = {"com.acmeair"})
public class CustomerServiceApplication {

    public static void main(String[] args) throws Exception {
        Log4jUtils.init();
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Configuration
    @EnableDiscoveryClient
    @Profile("!cse")
    class ConsulServiceDiscoveryConfig {
    }

    @Configuration
    @Profile("cse")
    @EnableServiceComb
    class CseConfig {
    }
}
