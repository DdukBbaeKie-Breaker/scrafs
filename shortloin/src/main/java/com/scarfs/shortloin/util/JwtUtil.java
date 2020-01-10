package com.scarfs.shortloin.util;

import com.scarfs.shortloin.exception.ExpiredTokenException;
import com.scarfs.shortloin.exception.InvalidTokenException;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

public class JwtUtil {
    private static final String SECURITY_KEY = "qweqweasdasd";

    private static String generateToken(Object data, Long expire) {

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(data.toString())
                .setHeaderParam("typ", "JWT")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expire))
                .signWith(SignatureAlgorithm.HS256, SECURITY_KEY);

        return builder.compact();
    }

    public static String getAccessToken(Object data) {

        return generateToken(data, 1000L * 3600 * 24);
    }
    public static String getRefreshToken(Object data) {

        return generateToken(data, 1000L * 3600 * 24 * 30);
    }

    public static Integer parseToken(String token) {
        try {
            token = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody().getSubject();
        } catch (ExpiredJwtException e) {
            throw new ExpiredTokenException();
        } catch (MalformedJwtException e) {
            throw new InvalidTokenException();
        }
        return Integer.parseInt(token);
    }
}
