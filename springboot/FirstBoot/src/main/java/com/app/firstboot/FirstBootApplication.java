package com.app.firstboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.app.firstboot.mapper")
public class FirstBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstBootApplication.class, args);
    }

}
