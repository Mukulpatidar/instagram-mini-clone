package com.smart.instagram.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtUtil {

    // ✅ 32+ characters (>= 256 bits)
    private static final String SECRET =
            "my_super_secret_jwt_key_which_is_256_bits_long";

    private static final long EXPIRATION_TIME =
            1000 * 60 * 60; // 1 hour

    public static String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                // ✅ IMPORTANT FIX
                .signWith(
                        SignatureAlgorithm.HS256,
                        SECRET.getBytes(StandardCharsets.UTF_8)
                )
                .compact();
    }

    public static String extractUsername(String token) {

        return Jwts.parser()
                // ✅ SAME FIX HERE
                .setSigningKey(
                        SECRET.getBytes(StandardCharsets.UTF_8)
                )
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
