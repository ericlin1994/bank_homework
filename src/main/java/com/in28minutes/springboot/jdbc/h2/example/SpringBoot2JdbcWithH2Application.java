package com.in28minutes.springboot.jdbc.h2.example;

import com.in28minutes.springboot.jdbc.h2.example.student.Coin;
import com.in28minutes.springboot.jdbc.h2.example.student.CoinJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2JdbcWithH2Application implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CoinJdbcRepository coinRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
    }

    @Override
    public void run(String... args) {
    }
}
