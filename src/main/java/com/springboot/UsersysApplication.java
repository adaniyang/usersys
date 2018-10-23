package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.springboot.activeMQ"})
//@MapperScan(value = "com.springboot.usersys.dao")
//@EnableSwagger2 //将这个注释写到SwaggerConfig上了
public class UsersysApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersysApplication.class, args);
	}
}
