package com.lemisa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseAuthenticationProvider extends DaoAuthenticationProvider {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doAfterPropertiesSet() throws Exception {
		this.setPasswordEncoder(passwordEncoder);
		this.setUserDetailsService(userDetailsService);
		super.doAfterPropertiesSet();
	}
}
