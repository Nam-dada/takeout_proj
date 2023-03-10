package com.takeout;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@Slf4j
@SpringBootApplication
@ServletComponentScan
public class T_O_Application {
    public static void main(String[] args) {
        SpringApplication.run(T_O_Application.class, args);
        log.info("Starting succeed ...");
    }
}
