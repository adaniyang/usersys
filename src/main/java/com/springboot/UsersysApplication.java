package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.springboot.activeMQ"})
//@MapperScan(value = "com.springboot.usersys.dao")
@EnableSwagger2
public class UsersysApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersysApplication.class, args);
	}
}
