package com.petfoster.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class for setting up Cross-Origin Resource Sharing (CORS) settings.
 * This class allows configuration of CORS mappings for the application.
 */
	@Configuration
	public class WebConfig implements WebMvcConfigurer {
		 /**
	     * Configures CORS mappings to allow specific origins, methods, and headers,
	     * and to allow credentials.
	     *
	     * @param registry the CORS registry to configure
	     */
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")  // Allow all endpoints to be accessed
	                .allowedOrigins("http://localhost:3000") // Allow React frontend running on port 3000
	                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow these HTTP methods
	                .allowedHeaders("*") // Allow all headers
	                .allowCredentials(true);
	         // Allow cookies and credentials
	       
	    }
	}


