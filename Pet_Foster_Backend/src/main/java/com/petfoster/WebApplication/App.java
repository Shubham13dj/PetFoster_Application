package com.petfoster.WebApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * The main entry point for the Pet Foster web application.
 * This class is responsible for bootstrapping the application.
 */
@SpringBootApplication(scanBasePackages= {"com.petfoster.services", "com.petfoster.config","com.petfoster.controllers","com.petfoster.utils"})
@EntityScan(basePackages = {"com.petfoster.model", "com.petfoster.model.utility"})
@EnableJpaRepositories(basePackages = "com.petfoster.repository")
@EnableAspectJAutoProxy

public class App 
{
	/**
     * The main method that serves as the entry point of the application.
     *
     * @param args command line arguments
     */
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
 