package com.petfoster.WebApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */

@SpringBootApplication(scanBasePackages= {"com.petfoster.services", "com.petfoster.config","com.petfoster.controllers"})
@EntityScan(basePackages = "com.petfoster.model")
@EnableJpaRepositories(basePackages = "com.petfoster.repository")
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
