package br.com.fiap.GlobalSolution.controller;

import br.com.fiap.GlobalSolution.model.Ong;
import br.com.fiap.GlobalSolution.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("api/v1/login")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Ong> signIn(@RequestBody @Valid Ong ong) {
        return loginService.singIn(ong);
    }
}