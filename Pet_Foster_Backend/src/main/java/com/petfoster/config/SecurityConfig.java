////package com.petfoster.config;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
////
////import com.petfoster.utils.JWTUtils;
////import com.petfoster.utils.JwtAuthenticationFilter;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig extends WebSecurityConfiguration {
////
////
////	    private JWTUtils jwtUtils;
////
////	    public SecurityConfig(JWTUtils jwtUtils)
////	    {
////	    	this.jwtUtils = jwtUtils;
////	    }
////
////    @Bean
////    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
////	    {
////	    	http.csrf(csrf -> csrf.disable())
////	    		.authorizeHttpRequests(auth-> auth
////	    		.requestMatchers("/login", "/signup").permitAll()
////	    		.anyRequest().authenticated()
////	    		)
////	    		.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
////			
////	    	return http.build();
////	    }
////	
////	    @Bean
////	    public PasswordEncoder passwordEncoder()
////	    {
////	    	return new BCryptPasswordEncoder();
////	    }
////	    
////	    @Bean
////	    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception
////	    {
////	    	return http.getSharedObject(AuthenticationManagerBuilder.class).build();
////	    }
////	    
////	    @Bean
////	    public JwtAuthenticationFilter jwtAuthenticationFilter() {
////	        return new JwtAuthenticationFilter(jwtUtils);
////	    }
////}

package com.petfoster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.petfoster.utils.JWTUtils;
import com.petfoster.utils.JwtAuthenticationFilter;
/**
 * Configuration class for Spring Security. This class configures the security
 * settings, including authentication and authorization mechanisms.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private JWTUtils jwtUtils;
	/**
     * Constructor to initialize JWTUtils.
     * 
     * @param jwtUtils the JWT utility class
     */
	public SecurityConfig(JWTUtils jwtUtils) {
		this.jwtUtils = jwtUtils;
	}

	 /**
     * Creates a bean for SecurityFilterChain which configures HTTP security
     * settings.
     * 
     * @param http the HttpSecurity object to configure
     * @return a SecurityFilterChain instance
     * @throws Exception if there is an error during configuration
     */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/users/login", "/users/signup", "/*").permitAll() // Allow
									.anyRequest().permitAll() // Require authentication for other requests
				).addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
	/**
     * Creates a bean for PasswordEncoder to handle password encoding.
     * 
     * @return a BCryptPasswordEncoder instance
     */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // Password encoding bean
	}
	/**
     * Creates a bean for AuthenticationManager to manage authentication.
     * 
     * @param http the HttpSecurity object to configure
     * @return an AuthenticationManager instance
     * @throws Exception if there is an error during configuration
     */
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).build(); // Build authentication manager bean
	}
	/**
     * Creates a bean for JwtAuthenticationFilter to handle JWT authentication.
     * 
     * @return a JwtAuthenticationFilter instance
     */
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter(jwtUtils); // Create JWT filter bean
	}
}
