package com.example.pfm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.pfm.mapper")
public class PfmApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfmApplication.class, args);
    }

}
