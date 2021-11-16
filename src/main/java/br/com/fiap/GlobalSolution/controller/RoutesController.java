package br.com.fiap.GlobalSolution.controller;

import br.com.fiap.GlobalSolution.model.Ong;
import br.com.fiap.GlobalSolution.repository.OngRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
@AllArgsConstructor(onConstructor = @__( @Autowired))
public class RoutesController {

    private OngRepository ongRepository;

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
    public String openDonationPage(Model model, Authentication auth) {
        List<Ong> ongs = ongRepository.findAll();
        model.addAttribute("ongs",ongs);
        return "pages/donate/donate";
    }

//    @GetMapping("/ongs/{cnpj}")
//    public ModelAndView openDonationModal(@PathVariable("cnpj") String cnpj, Model model,
//                                    Authentication auth, ModelMap modelMap) {
////        ModelAndView modelAndView = new ModelAndView("ongs");
////        List<Ong> ongs = ongRepository.findAll();
////        modelAndView.addObject("ongs", ongs);
////        System.out.println(ongs);
////        return modelAndView;
//        ModelAndView modelAndView = new ModelAndView("ongsModal");
//        Ong ongs = ongRepository.findByCnpj(cnpj);
//        modelAndView.addObject("ongsModal",ongs);
//        System.out.println(ongs);
////        Ong ong = (Ong) auth.getPrincipal();
////        System.out.println(ong.getName());
////        model.addAttribute("ongsModal",ongRepository.findByCnpj(ong.getCnpj()));
//        return modelAndView;
//    }

    @GetMapping("/home")
    public String openHomePage() {
        return "pages/home/ong";
    }

    @GetMapping("/home/donations")
    public String openConfirmDonationPage() {
        return "pages/home/donations/donations";
    }

    @GetMapping("/home/settings/{cnpj}")
    public String openSettingsPage(@PathVariable("cnpj") String cnpj, String email,
                                   Model model, Authentication auth) {
        Ong ong = (Ong) auth.getPrincipal();
        model.addAttribute("p",ongRepository.findByCnpj(ong.getCnpj()));
        return "pages/home/settings/settings";
    }

//    @GetMapping
//    public ModelAndView index() {
//        ModelAndView modelAndView = new ModelAndView("ongs");
//        List<Ong> ongs = ongRepository.findAll();
//        modelAndView.addObject("ongs", ongs);
//        System.out.println(ongs);
//        return modelAndView;
//    }

}
