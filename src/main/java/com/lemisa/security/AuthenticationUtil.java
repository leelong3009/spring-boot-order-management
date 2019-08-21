package com.lemisa.security;

import static java.util.Collections.emptyList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class AuthenticationUtil {

	static public void addToken(HttpServletResponse res, String username) {
		String JwtToken = JwtUtil.createJwtToken(username);
		res.addHeader("Authorization", JwtUtil.PREFIX + " " + JwtToken);
		res.addHeader("Access-Control-Expose-Headers", "Authorization");
	}

	static public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token != null) {
			String user = JwtUtil.getSubject(token);

			if (user != null)
				return new UsernamePasswordAuthenticationToken(user, null, emptyList());
		}
		return null;
	}
}
