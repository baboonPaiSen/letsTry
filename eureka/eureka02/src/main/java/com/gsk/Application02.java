package com.gsk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description: TODO
 * @date: 2020/6/16 12:28
 * @author: ShangKun
 * @version: 2.0.0
 */
@SpringBootApplication
@EnableEurekaClient
public class Application02 {

    public static void main(String[] args) {
        SpringApplication.run(Application02.class, args);
    }
}
