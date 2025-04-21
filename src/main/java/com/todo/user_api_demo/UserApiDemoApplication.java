package com.todo.user_api_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApiDemoApplication.class, args);
        System.out.println("App successfully lunched with a newer version from the PR!...");
    }

}