package com.lemisa.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

	@Autowired
    private AuthenticationManager authnManager;
	
	public AuthenticationProcessingFilter() {
		super(new AntPathRequestMatcher("/login", HttpMethod.POST.toString()));
	}
	
	@Override
	public void afterPropertiesSet() {
		this.setAuthenticationManager(authnManager);
		super.afterPropertiesSet();
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		AccountCredentials creds = new ObjectMapper().readValue(request.getInputStream(), AccountCredentials.class);
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		AuthenticationService.addToken(response, authResult.getName());
	}
}
