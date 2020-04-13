package com.ly.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication()
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class,args);
    }
}
