package com.storemanager.api;

import org.apache.catalina.Manager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class StoreManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreManagerApplication.class, args);
	}

}
