package com.appdev.SCT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class SCRApplication {

	public static void main(String[] args) {
		SpringApplication.run(SCRApplication.class, args);
	}

}
