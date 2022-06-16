package com.imedia.config.authentication;

import com.google.gson.Gson;
import com.imedia.config.application.AppConfig;
import com.imedia.config.jwt.CustomUserDetails;
import com.imedia.service.authenticate.model.RoleEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;
    static final Gson gson = new Gson();
    static final Logger logger = LogManager.getLogger(JwtTokenUtil.class);
    @Value("${jwt.token.expiry}")
    public long JWT_TOKEN_VALIDITY;

    @Value("${jwt.secret}")
    private String secret;

    public String getUserDetailsFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public CustomUserDetails getUserToken(String token) {
        String sub = getClaimFromToken(token, Claims::getSubject);
        logger.info(sub);
        return gson.fromJson(sub, CustomUserDetails.class);
    }

    public String getSessionFromToken(String token) {
        Claims claims = getAllClaimsFromToken(token);
        return claims.get("session").toString();
    }

//    public String getWarehouseIdFromToken(String token) {
//        Claims claims = getAllClaimsFromToken(token);
//        return claims.get("warehouseId").toString();
//    }

    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        if (claims == null)
            return null;
        else
            return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }

    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean ignoreTokenExpiration(String token) {
        // here you specify tokens, for that the expiration is ignored
        return false;
    }

    public String generateToken(CustomUserDetails userDetails) throws Exception {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("message", "FU");
        return doGenerateToken(claims, userDetails);
    }

    private String doGenerateToken(HashMap<String, Object> claims, CustomUserDetails userDetails) throws Exception {
        long plus = JWT_TOKEN_VALIDITY * 1000;
        long exDate = new Date().getTime() + plus;
        if (userDetails.getRememberMe() == 1)
            exDate = new Date().getTime() + (AppConfig.getInstance().rememberMeCache * 1000);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(gson.toJson(userDetails))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(exDate))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean canTokenBeRefreshed(String token) {
        return (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String tokenUserDetails = getUserDetailsFromToken(token);
        CustomUserDetails userDetailsObj = gson.fromJson(tokenUserDetails, CustomUserDetails.class);
        if (userDetailsObj.getRole().equals(RoleEnum.MANAGER.toString()))
            if (userDetailsObj.getWarehouseId() == null)
                return false;
        final String username = userDetailsObj.getUsername();
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
