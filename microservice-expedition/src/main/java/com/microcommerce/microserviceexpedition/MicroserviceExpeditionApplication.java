package com.microcommerce.microserviceexpedition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.microcommerce.microserviceexpedition")
public class MicroserviceExpeditionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceExpeditionApplication.class, args);
	}

}
