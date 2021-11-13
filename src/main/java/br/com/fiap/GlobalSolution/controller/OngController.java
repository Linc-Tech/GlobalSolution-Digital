package br.com.fiap.GlobalSolution.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.GlobalSolution.model.Donation;
import br.com.fiap.GlobalSolution.model.Image;
import br.com.fiap.GlobalSolution.model.Ong;
import br.com.fiap.GlobalSolution.service.DonationService;
import br.com.fiap.GlobalSolution.service.OngService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/ong")
@AllArgsConstructor(onConstructor = @__( @Autowired ))
public class OngController {
		
	private OngService ongService;
	private DonationService donationService;
	private MessageSource messages;
	
	@GetMapping
	public List<Ong> getOngs() {				
		return ongService.getAllOngs();
	}
		
	@GetMapping("/cnpj={cnpj}")
	public List<Donation> getDonations(@PathVariable String cnpj) {				
		return donationService.getAllDonations(cnpj);
	}
	
    @PostMapping("/create")   
	public String create(@Valid  Ong ong, BindingResult result, RedirectAttributes redirect) {
    	if(result.hasErrors()) {
			return "registration";
		}
    	
    	ongService.addOng(ong);    	
    	return "redirect:/v1/routes/registration";
	}
    
	@PostMapping("/donate")    
	public String donate(@RequestBody Donation donation) {
		return donationService.donate(donation);
	}	
	
	@PostMapping("/addImg")    
	public String addImg(@RequestBody Image img) {
		return ongService.addOngImage(img);
	}	
	
	@PutMapping
	public String update(@RequestBody Ong ong) {
		return ongService.updateOng(ong);
	}
	
	@PutMapping("/idDonation={id}&statusDonation={status}")
	public String statusDonation(@PathVariable int id, @PathVariable boolean status) {
		return donationService.setDonationStatus(id, status);
	}
	
	@DeleteMapping("/cnpj={cnpj}")
	public String delete(@PathVariable String cnpj) {
		return ongService.deleteOng(cnpj);
	}		

}
