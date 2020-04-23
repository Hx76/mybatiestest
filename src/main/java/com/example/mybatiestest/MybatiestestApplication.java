package com.example.mybatiestest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatiestest.mapper")
public class MybatiestestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatiestestApplication.class, args);
    }

}
