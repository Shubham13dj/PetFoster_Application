package com.petfoster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

/**
 * Configuration class for multipart file upload support. 
 * This class provides a bean for MultipartResolver.
 */
@Configuration
public class MultipartConfig {
	/**
	 * Creates a bean of MultipartResolver to handle file uploads.
	 *
	 * @return a StandardServletMultipartResolver instance
	 */
	@Bean
	MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
}
