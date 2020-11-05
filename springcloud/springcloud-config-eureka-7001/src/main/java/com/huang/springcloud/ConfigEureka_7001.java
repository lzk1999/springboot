package com.huang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ConfigEureka_7001 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigEureka_7001.class,args);
    }
}
