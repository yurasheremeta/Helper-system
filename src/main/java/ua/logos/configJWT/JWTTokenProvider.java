package ua.logos.configJWT;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ua.logos.entity.enums.UserRole;
import static ua.logos.constants.SecurityConstants.*;
@Component
public class JWTTokenProvider {
	@Autowired
	private UserDetailsService userDetailsService;
	
	public String createToken(String username , UserRole role) {
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("auth" , AuthorityUtils.createAuthorityList(String.valueOf(role)));
		
		Date now = new Date();
		Date validity = new Date(now.getTime() + EXPINATION_TIME);
		
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(validity)
				.signWith(SignatureAlgorithm.HS256, TOKEN_SECRET)
				.compact();
	}
	
	public Authentication getAuthentication(String token) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(getUsername(token));
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}
	
	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token).getBody().getSubject();
	}
	
	public String resolvToken(HttpServletRequest req) {
		String bearerToken = req.getHeader(HEADER_STRING);
		if(bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
			return bearerToken.substring(7 , bearerToken.length());
			
		}
		return null;
	}
	
	public boolean vaidateToken(String token) {
		try {
			Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
