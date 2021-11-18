package fiap.com.br.globalsolution.controller;

import fiap.com.br.globalsolution.model.Donation;
import fiap.com.br.globalsolution.model.Ong;
import fiap.com.br.globalsolution.repository.DonationRepository;
import fiap.com.br.globalsolution.repository.OngRepository;
import fiap.com.br.globalsolution.service.DonationService;
import fiap.com.br.globalsolution.service.OngService;
import lombok.AllArgsConstructor;
import org.dom4j.rule.Mode;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToStdout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HomeController {

    private OngRepository ongRepository;
    private DonationRepository donationRepository;

    @GetMapping
    public String openHomePage(Model model, Authentication auth) {
        Ong ong = (Ong) auth.getPrincipal();
        List<Donation> doacoes = donationRepository.findDonationByOngCnpj(ong.getCnpj());

        double arrecadado = 0.00;
        int quantidadeDoacoes = 0;
        for (int i = 0; i < doacoes.size(); i++) {
            Donation doacao = doacoes.get(i);

            if (doacao.getConfirmation()) {
                arrecadado += doacao.getValue();
                quantidadeDoacoes += 1;
            }
        }

        model.addAttribute("quantidadeDoacoes", quantidadeDoacoes);
        model.addAttribute("arrecadado", arrecadado);
        return "pages/home/ong";
    }

    @GetMapping("/donations")
    public String openConfirmDonationPage(Model model, Authentication auth) {
        Ong ong = (Ong) auth.getPrincipal();
        List<Donation> doacoes = donationRepository.findDonationByOngCnpj(ong.getCnpj());
        model.addAttribute("doacoes", doacoes);
        return "pages/home/donations/donations";
    }

    @GetMapping("/settings")
    public String openSettingsPage(Model model, Authentication auth) {
        Ong ong = (Ong) auth.getPrincipal();
        model.addAttribute("p",ongRepository.findByCnpj(ong.getCnpj()));
        return "pages/home/settings/settings";
    }
}
