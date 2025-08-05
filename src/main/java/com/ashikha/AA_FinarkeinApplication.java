package com.ashikha;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AA_FinarkeinApplication {

    public static void main(String[] args) {
    	System.setProperty("log4j2.formatMsgNoLookups","true");
        SpringApplication.run(AA_FinarkeinApplication.class, args);
    }

}
