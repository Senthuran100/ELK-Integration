package com.elk.elkstackintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ElkStackIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElkStackIntegrationApplication.class, args);
	}

}
