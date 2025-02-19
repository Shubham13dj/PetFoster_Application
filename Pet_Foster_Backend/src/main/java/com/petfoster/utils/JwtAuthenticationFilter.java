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

@WebFilter
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private JWTUtils jwtUtils;

	public JwtAuthenticationFilter(JWTUtils jwtUtils) {
		this.jwtUtils = jwtUtils;
	}

	public JwtAuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

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

	private String extractJwtToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if (header != null && header.startsWith("Bearer")) {
			return header.substring(7);
		}
		return null;
	}

}
