package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // This is the trigger. When someone visits the URL, it executes the SQL inside.
    @GetMapping("/ping")
    public String ping() {
        jdbcTemplate.update("INSERT INTO messages (content) VALUES ('Hello from the cloud!')");
        return "Success: The robot just wrote on the whiteboard!";
    }
}