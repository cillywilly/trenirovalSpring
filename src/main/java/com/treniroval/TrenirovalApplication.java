package com.treniroval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.treniroval")
public class TrenirovalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrenirovalApplication.class, args);
    }

}
