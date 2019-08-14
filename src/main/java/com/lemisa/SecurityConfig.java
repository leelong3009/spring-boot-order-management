package com.lemisa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lemisa.security.JwtParsingFilter;
import com.lemisa.security.AuthenticationProcessingFilter;
import com.lemisa.security.DatabaseAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DatabaseAuthenticationProvider databaseAuthenticationProvider;
	
	@Autowired
	private JwtParsingFilter jwtParsingFilter;
	
	@Autowired
	private AuthenticationProcessingFilter authenticationProcessingFilter;
	
	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean(name = "authenticationManager")
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		ProviderManager providerManager = new ProviderManager(Arrays.asList(databaseAuthenticationProvider));
		return providerManager;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/login").permitAll().anyRequest().authenticated()
		.and()
		.addFilterBefore(authenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(jwtParsingFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
