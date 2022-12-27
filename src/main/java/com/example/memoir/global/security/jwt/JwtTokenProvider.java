package com.example.memoir.global.security.jwt;

import com.example.memoir.global.exception.ExpiredJwtException;
import com.example.memoir.global.exception.InvalidJwtException;
import com.example.memoir.global.security.auth.AuthDetails;
import com.example.memoir.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private String secretKey = "7J2067KI7ZSE66Gc7KCd7Yq47JeQ7ISc7YWM7Iqk7Yq47L2U65Oc7J6Y7Kec66m07KKL6rKg64uk7ZWY7KeA66eM7Ja066C164uk";

    private int accessTokenTime = 86400;

    private final AuthDetailsService authDetailsService;

    // 토큰 생성
    public String generateAccessToken(String userId) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenTime * 1000)) //만료일
                .setIssuedAt(new Date()) // 생성일
                .setHeaderParam("typ", "access")
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setSubject(userId)
                .compact();
    }

    // 권한 가져오기
    public Authentication authentication(String token) {
        AuthDetails authDetails = authDetailsService.loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(authDetails, "", authDetails.getAuthorities());
    }

    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(secretKey)
                    .parseClaimsJws(token).getBody();
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            throw ExpiredJwtException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidJwtException.EXCEPTION;
        }
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.replace("Bearer ", "");
        }
        return null;
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");
        return parseToken(bearer);
    }
}
