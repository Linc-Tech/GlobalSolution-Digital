package fiap.com.br.globalsolution.controller;

import fiap.com.br.globalsolution.exception.OngAlreedyRegisteredException;
import fiap.com.br.globalsolution.model.Donation;
import fiap.com.br.globalsolution.model.Ong;
import fiap.com.br.globalsolution.repository.DonationRepository;
import fiap.com.br.globalsolution.repository.OngRepository;
import fiap.com.br.globalsolution.service.AuthenticationService;
import fiap.com.br.globalsolution.service.DonationService;
import fiap.com.br.globalsolution.service.OngService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ong")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OngController {

    private OngService ongService;
    private DonationService donationService;
    private OngRepository ongRepository;

    @PostMapping("/create")
    public String create(@Valid Ong ong, BindingResult result, RedirectAttributes redirect) {
        if(result.hasErrors()) {
            return "registration";
        }

        ongService.addOng(ong);
        return "redirect:/index";
    }

    @PostMapping("/donate")
    public String donate(@Valid Donation donation, BindingResult result, RedirectAttributes redirect) {
        if(result.hasErrors()) {
            return "error";
        }

        donationService.donate(donation);

        return "redirect:/ongs";
    }

    @GetMapping("/ongs")
    public String openDonationPage(Model model, Authentication auth) {
        List<Ong> ongs = ongRepository.findAll();
        model.addAttribute("ongs",ongs);
        return "pages/donate/donate";
    }

    @GetMapping("/ongs/{cnpj}")
    public String openDonationModal(Model model, Authentication auth) {


        return "pages/donate/donate";
    }

}
