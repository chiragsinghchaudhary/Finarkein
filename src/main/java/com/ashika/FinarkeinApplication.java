package com.ashika;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinarkeinApplication {

    public static void main(String[] args) {
    	System.setProperty("log4j2.formatMsgNoLookups","true");
        SpringApplication.run(FinarkeinApplication.class, args);
    }
}
