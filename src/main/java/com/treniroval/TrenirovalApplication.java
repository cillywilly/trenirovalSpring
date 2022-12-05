package com.treniroval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.treniroval")
@EnableJpaRepositories
public class TrenirovalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrenirovalApplication.class, args);
    }

}
