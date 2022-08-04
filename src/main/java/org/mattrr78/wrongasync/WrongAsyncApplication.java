package org.mattrr78.wrongasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class WrongAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(WrongAsyncApplication.class, args);
    }

}
