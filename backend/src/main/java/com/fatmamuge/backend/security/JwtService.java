package com.fatmamuge.backend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import com.fatmamuge.backend.entity.User;
import java.util.Date;


import javax.crypto.SecretKey;

@Service
public class JwtService {

    private final SecretKey secretKey =
            Keys.hmacShaKeyFor(
                    "mySuperSecretKeyForJwtAuthentication123456789".getBytes()
            );
    public String generateToken(User user) {
	  return Jwts.builder()
            .subject(user.getPhoneNumber()) //bunu ilerde .subject(user.getId()... yapariz
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + 86400000)) //token in gecerlilik suresi yani 24 saat.
            .signWith(secretKey)
            .compact();
    }
    public String extractPhoneNumber(String token) {
	    
	    return Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }
    public boolean isTokenValid(String token) {
	    try {
       	        Jwts.parser()
                     .verifyWith(secretKey)
                     .build()
                     .parseSignedClaims(token);

                 return true;

             } catch (Exception e) {
                  return false;
             } 
    }

}
