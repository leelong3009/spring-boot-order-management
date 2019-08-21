package com.lemisa.security;

import java.sql.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	static final String SIGNINGKEY = "SecretKey";
	static final String PREFIX = "Bearer";
	static final long EXPIRATIONTIME = 864_000_00; // 1 day in milliseconds

	public static String createJwtToken(String subject) {
		return Jwts.builder().setSubject(subject).setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SIGNINGKEY).compact();
	}

	public static String getSubject(String token) {
		return Jwts.parser().setSigningKey(SIGNINGKEY).parseClaimsJws(token.replace(PREFIX, "")).getBody().getSubject();
	}
}
