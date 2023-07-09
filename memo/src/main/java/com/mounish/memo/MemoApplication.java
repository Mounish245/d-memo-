package com.mounish.memo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableWebMvc
//@ComponentScan(basePackages = "com.mounish.memo")
public class MemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoApplication.class, args);
	}

}
