//package com.springboot.usersys.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class Config {
//
//    @Bean
//    public DataSource dataSource(){
//        HikariDataSource dataSource=new HikariDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/personmanage");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        return dataSource;
//    }
//}
