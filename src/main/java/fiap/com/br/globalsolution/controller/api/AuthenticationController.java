package fiap.com.br.globalsolution.controller.api;

import fiap.com.br.globalsolution.model.Login;
import fiap.com.br.globalsolution.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/api/auth")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> auth(@RequestBody @Valid Login login) {
        Authentication auth = login.getAuthentication();

        try {
            Authentication authenticate = authenticationManager.authenticate(auth);
            String token = tokenService.createToken(authenticate);

            return ResponseEntity.ok(token);

        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
