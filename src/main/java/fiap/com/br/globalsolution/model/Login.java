package fiap.com.br.globalsolution.model;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

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
