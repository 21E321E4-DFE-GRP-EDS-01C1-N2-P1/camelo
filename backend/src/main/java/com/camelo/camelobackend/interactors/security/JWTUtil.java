package com.camelo.camelobackend.interactors.security;

import com.camelo.camelobackend.domain.UserLocalStorage;
import com.camelo.camelobackend.ports.UserPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	private final UserPort userPort;
	private final ObjectMapper objectMapper;

	public JWTUtil(UserPort userPort, ObjectMapper objectMapper) {
		this.userPort = userPort;
		this.objectMapper = objectMapper;
	}

	public String generateToken(String email) {

		var user = userPort.buscarPor(email);
		var localStorage = new UserLocalStorage(
				user.getName(),
				user.getEmail(),
				user.getEndereco(),
				user.getCep(),
				user.getBairro(),
				user.getCidade()
		);

		try {
			var json = objectMapper.writeValueAsString(localStorage);
			return Jwts
					.builder()
					.setSubject(json)
					.setExpiration(
							new Date(System.currentTimeMillis() + expiration)
					).signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();

		} catch (JsonProcessingException e) {
			throw new RuntimeException("ERRO AO CONVERTER USUARIO");
		}
	}

	public boolean tokenValido(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if (username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}
		return false;
	}

	public String getUsername(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			return claims.getSubject();
		}
		return null;
	}

	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}
	}
}
