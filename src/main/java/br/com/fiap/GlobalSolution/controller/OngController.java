package br.com.fiap.GlobalSolution.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.fiap.GlobalSolution.repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@CrossOrigin(origins = "*")
@AllArgsConstructor(onConstructor = @__( @Autowired ))
public class OngController {
		
	private OngService ongService;
	private DonationService donationService;
	
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
	
	@PostMapping("/addImg")    
	public String addImg(@RequestBody Image img) {		
		return "redirect:/ongs";//ongService.addOngImage(img);
	}	
	
	@PostMapping("/update")
	public String update(@Valid Ong ong, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {
			return "redirect:/error";
		}
				
		ongService.updateOng(ong);		
		return "redirect:/home/settings/" + ong.getCnpj(); 
	}

	@PutMapping("/idDonation={id}&statusDonation={status}")
	public String statusDonation(@PathVariable int id, @PathVariable boolean status) {
		return donationService.setDonationStatus(id, status);
	}
	
	@GetMapping("/delete/{cnpj}")
	public String delete(@PathVariable("cnpj") String cnpj){
		if(cnpj.length() == 0) {
			return "redirect:/error";
			
		}
		ongService.deleteOng(cnpj);
		return "redirect:/index";
	}






}
