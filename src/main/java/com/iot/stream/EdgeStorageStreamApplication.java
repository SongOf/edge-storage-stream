package com.iot.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EdgeStorageStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdgeStorageStreamApplication.class, args);
    }

}
