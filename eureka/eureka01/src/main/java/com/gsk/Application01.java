package com.gsk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description: TODO
 * @date: 2020/6/16 12:27
 * @author: ShangKun
 * @version: 2.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class Application01 {

    public static void main(String[] args) {
        SpringApplication.run(Application01.class, args);
    }
}
