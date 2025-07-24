package com.ashikha;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AA_FinarkeinApplication {

    public static void main(String[] args) {
        SpringApplication.run(AA_FinarkeinApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from your private LAN API!";
    }
}
