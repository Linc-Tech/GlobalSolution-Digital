package fiap.com.br.globalsolution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String openLoginPage() {
        return "pages/onboarding/login";
    }

    @GetMapping("/registration")
    public String openRegistrationPage() {
        return "pages/onboarding/registration";
    }

    @GetMapping("/index")
    public String openIndexPage() {
        return "index";
    }


}
