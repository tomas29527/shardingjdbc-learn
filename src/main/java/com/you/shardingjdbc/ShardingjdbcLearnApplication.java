package com.you.shardingjdbc;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,MybatisAutoConfiguration.class}) //排除DataSourceConfiguratrion
@EnableTransactionManagement(proxyTargetClass = true)   //开启事物管理功能
public class ShardingjdbcLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingjdbcLearnApplication.class, args);
    }

}

