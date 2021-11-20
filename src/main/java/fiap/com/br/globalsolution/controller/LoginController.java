package fiap.com.br.globalsolution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fiap.com.br.globalsolution.model.Ong;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String openLoginPage() {
        return "pages/onboarding/login";
    }

    @GetMapping("/registration")
    public String openRegistrationPage(Ong ong) {
        return "pages/onboarding/registration";
    }

    @GetMapping("/index")
    public String openIndexPage() {
        return "index";
    }

    @GetMapping("/")
    public String openIndexPageWithNoUrl() {
        return "index";
    }

}
