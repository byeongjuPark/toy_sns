package com.bangil.toy_sns.util;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.security.Key;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


public class JwtProvider {

    //@Value("${jwt.secret-key}")

    private String sceretKey;

    public JwtProvider(){
        sceretKey = "tlzmfltzlsmsrlfrpgodiwldhfbrkskwldksgsmsek";
    }

    public String create(String id) {
        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
        Key key = Keys.hmacShaKeyFor(sceretKey.getBytes(StandardCharsets.UTF_8));

        // 알고리즘, 주체, 생성시간, 만료시간, 압축 순
        String jwt = Jwts.builder() 
                .signWith(key, SignatureAlgorithm.HS256)
                .setSubject(id).setIssuedAt(new Date())
                .setExpiration(expiredDate)
                .compact();

        return jwt;
    }


    public String validate(String jwt) {
        Claims claims = null;
        Key key = Keys.hmacShaKeyFor(sceretKey.getBytes(StandardCharsets.UTF_8));
        try {
            claims = Jwts.parserBuilder().setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return claims.getSubject();
    }
}
