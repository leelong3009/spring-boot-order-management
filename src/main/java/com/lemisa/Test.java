package com.lemisa;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {

	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("password"));
		System.out.println(passwordEncoder.matches("password", "$2a$10$VKLj7FWspH8stjmInGQZtO3EI5vbpNKzmU.L6KaRU2VZb9SLtrO06"));
	}

}
