package com.ashikha;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.ashika.service")
@EnableJpaRepositories(basePackages = {"com.ashika.repositories"})
@EntityScan("com.ashika.entities") 
public class AA_FinarkeinApplication {

    public static void main(String[] args) {
    	System.setProperty("log4j2.formatMsgNoLookups","true");
        SpringApplication.run(AA_FinarkeinApplication.class, args);
    }

}
