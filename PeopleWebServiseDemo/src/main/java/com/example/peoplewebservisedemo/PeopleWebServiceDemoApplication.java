package com.example.peoplewebservisedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PeopleWebServiceDemoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PeopleWebServiceDemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PeopleWebServiceDemoApplication.class, args);
    }

}
