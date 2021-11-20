package fiap.com.br.globalsolution.controller;

import java.awt.Image;
import java.util.List;

import javax.validation.Valid;

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

import fiap.com.br.globalsolution.model.Donation;
import fiap.com.br.globalsolution.model.Ong;
import fiap.com.br.globalsolution.repository.OngRepository;
import fiap.com.br.globalsolution.service.DonationService;
import fiap.com.br.globalsolution.service.OngService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/ong")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OngController {

	private OngService ongService;
	private DonationService donationService;
	private OngRepository ongRepository;

	@GetMapping
	public List<Ong> getOngs() {
		return ongService.getAllOngs();
	}

	@GetMapping("/cnpj={cnpj}")
	public List<Donation> getDonations(@PathVariable String cnpj, Model model) {
		return donationService.getAllDonations(cnpj);
	}
	
	@PostMapping("/create")
	public String create(@Valid Ong ong, BindingResult result, RedirectAttributes redirect, Model model) {
		ong.toString();
		
		if (result.hasErrors()) {
			return "pages/onboarding/registration";
		}

		ongService.addOng(ong);		
		return "redirect:/index";
	}

	@PostMapping("/donate")
	public String donate(@Valid Donation donation, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "error";
		}

		donationService.donate(donation);
		return "redirect:/ong/ongs";
	}

	@PostMapping("/addImg")
	public String addImg(Image img) {
		return "redirect:/ongs";// ongService.addOngImage(img);
	}

	@PostMapping("/update")
	public String update(@Valid Ong ong, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "pages/home/settings";
		}

		ongService.updateOng(ong);
		return "redirect:/home/settings/";
	}

	@GetMapping("/statusDonation={status}&idDonation={id}")
	public String statusDonation(@PathVariable boolean status, @PathVariable int id) {
		donationService.setDonationStatus(id, status);

		return "redirect:/home/donations/";
	}

	@GetMapping("/delete/{cnpj}")
	public String delete(@PathVariable("cnpj") String cnpj) {
		if (cnpj.length() == 0) {
			return "redirect:/error";

		}
		ongService.deleteOng(cnpj);
		return "redirect:/index";
	}

	@GetMapping("/ongs")
	public String openDonationPage(Model model, Authentication auth) {
		List<Ong> ongs = ongRepository.findAll();
		model.addAttribute("ongs", ongs);
		return "pages/donate/donate";
	}

	@GetMapping("/ongs/{cnpj}")
	public String openDonationModal(Model model, Authentication auth) {
		return "pages/donate/donate";
	}

}
