package br.com.fiap.GlobalSolution.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("v1/routes")
public class RoutesController {

    @GetMapping("/index")
    public String openIndexPage() {
        return "index";
    }

}
