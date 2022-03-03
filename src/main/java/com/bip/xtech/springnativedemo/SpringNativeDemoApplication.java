package com.bip.xtech.springnativedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringNativeDemoApplication {

	public static void main(String[] args) {
		log.info("Hello world!");
		SpringApplication.run(SpringNativeDemoApplication.class, args);
	}

}
