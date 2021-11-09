package br.com.fiap.GlobalSolution.service;

import br.com.fiap.GlobalSolution.model.Ong;
import io.jsonwebtoken.*;
import org.hibernate.boot.model.source.spi.SingularAttributeNature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Value("${global.jwt.duration}")
    private long duration;

    @Value("${global.jwt.secret}")
    private String secret;

    public String createToken(Authentication authentication) {
        Ong ong = (Ong) authentication.getPrincipal();


        Date today = new Date();
        Date expirationDate = new Date(today.getTime() + duration);

        System.out.println(today);
        System.out.println(expirationDate);

        String token = Jwts.builder().setIssuer("Global API")
                .setSubject(ong.getCnpj().toString())
                .setIssuedAt(today)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
        return token;
    }
    public boolean valid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
                | IllegalArgumentException e) {
            return false;
        }
    }

    public Long getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return Long.valueOf( claims.getSubject() );
    }

}
