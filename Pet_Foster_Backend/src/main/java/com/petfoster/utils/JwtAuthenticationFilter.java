package com.petfoster.utils;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Filter that handles JWT authentication for incoming requests.
 */
@WebFilter
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private JWTUtils jwtUtils;
	/**
     * Constructs a new JwtAuthenticationFilter with the specified JWT utility.
     * 
     * @param jwtUtils the JWT utility used for validating tokens
     */
	public JwtAuthenticationFilter(JWTUtils jwtUtils) {
		this.jwtUtils = jwtUtils;
	}
	 /**
     * Default constructor for JwtAuthenticationFilter.
     */
	public JwtAuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Filters incoming requests to authenticate JWT tokens.
	 * This method extracts the JWT token from the request header,
	 * validates the token, and sets the authentication in the security context.
	 * 
	 * @param request the HttpServletRequest object that contains the request the client made to the servlet
	 * @param response the HttpServletResponse object that contains the response the servlet returns to the client
	 * @param filterChain the FilterChain object that allows the Filter to pass on the request and response to the next entity in the chain
	 * @throws ServletException if the request for the service could not be handled
	 * @throws IOException if an input or output error occurs while the servlet is handling the request
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = extractJwtToken(request);

		if (token != null && jwtUtils.validateToken(token, jwtUtils.extractUsername(token))) {
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
					jwtUtils.extractUsername(token), null, null);
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		filterChain.doFilter(request, response);
	}
	/**
     * Extracts the JWT token from the request header.
     * 
     * @param request the HTTP request from which to extract the token
     * @return the extracted JWT token, or null if not present
     */
	private String extractJwtToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if (header != null && header.startsWith("Bearer")) {
			return header.substring(7);
		}
		return null;
	}

}
