package com.junjun.organizationservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrganizationServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServicesApplication.class, args);
	}

}
