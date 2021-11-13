package br.com.fiap.GlobalSolution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RoutesController {

    @GetMapping("/index")
    public String openIndexPage() {
        return "index";
    }

    @GetMapping("/login")
    public String openLoginPage() {
        return "pages/onboarding/login";
    }

    @GetMapping("/registration")
    public String openRegistrationPage() {
        return "pages/onboarding/registration";
    }

    @GetMapping("/ongs")
    public String openDonationPage() {
        return "pages/donate/donate";
    }

    @GetMapping("/home")
    public String openHomePage() {
        return "pages/home/ong";
    }

    @GetMapping("/home/donations")
    public String openConfirmDonationPage() {
        return "pages/home/donations/donations";
    }

    @GetMapping("/home/settings")
    public String openSettingsPage() {
        return "pages/home/settings/settings";
    }

}
