package com.springboot;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
//@ComponentScan(basePackages = {"com.springboot.activeMQ"})
//@MapperScan(value = "com.springboot.usersys.dao")
@EnableSwagger2 //先注释掉这个swagger访问，做activiti用
public class UsersysApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersysApplication.class, args);
	}
}
