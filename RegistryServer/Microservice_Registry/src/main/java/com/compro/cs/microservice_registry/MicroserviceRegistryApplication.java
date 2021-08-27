package com.compro.cs.microservice_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class MicroserviceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceRegistryApplication.class, args);
    }

}
