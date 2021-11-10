package br.com.fiap.GlobalSolution.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Data

public class Login {
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public Authentication getAuthentication() {
        return new UsernamePasswordAuthenticationToken(this.email, this.password);
    }
}
