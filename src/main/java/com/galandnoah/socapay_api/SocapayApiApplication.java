package com.galandnoah.socapay_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SocapayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocapayApiApplication.class, args);
	}

}
