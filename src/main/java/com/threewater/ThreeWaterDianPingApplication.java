package com.threewater;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.threewater.mapper")
@SpringBootApplication
public class ThreeWaterDianPingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreeWaterDianPingApplication.class, args);
    }

}
