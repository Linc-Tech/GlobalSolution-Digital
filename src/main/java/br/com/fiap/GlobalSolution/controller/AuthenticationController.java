package br.com.fiap.GlobalSolution.controller;

import br.com.fiap.GlobalSolution.model.Login;
import br.com.fiap.GlobalSolution.model.Ong;
import br.com.fiap.GlobalSolution.repository.OngRepository;
import br.com.fiap.GlobalSolution.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
@RequestMapping("api/v1/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> auth(@RequestBody @Valid Login login) {
        Authentication auth = login.getAuthentication();
        try {

            Authentication authenticate = authManager.authenticate(auth);

            String token = tokenService.createToken(authenticate);

            return ResponseEntity.ok(token);

        } catch (AuthenticationException e) {

            return ResponseEntity.badRequest().build();
        }
    }
}
