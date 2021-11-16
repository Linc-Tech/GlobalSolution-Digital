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
@AllArgsConstructor(onConstructor = @__( @Autowired ))
public class OngController {
		
	private OngService ongService;
	private DonationService donationService;
	private MessageSource messages;
	private OngRepository ongRepository;
	
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
	public String donate(@RequestBody Donation donation) {
		return donationService.donate(donation);
	}	
	
	@PostMapping("/addImg")    
	public String addImg(@RequestBody Image img) {
		return ongService.addOngImage(img);
	}	
	
	@PostMapping("/update")
	public String update(@RequestBody Ong ong, BindingResult result, RedirectAttributes redirect) {

		return ongService.updateOng(ong);
	}

	@PutMapping("/idDonation={id}&statusDonation={status}")
	public String statusDonation(@PathVariable int id, @PathVariable boolean status) {
		return donationService.setDonationStatus(id, status);
	}
	
	@DeleteMapping("delete/{cnpj}")
	public ResponseEntity<Ong> delete(@PathVariable String cnpj, BindingResult result, RedirectAttributes redirect, Authentication auth) {
		System.out.println("passei aqui");
		Ong ong = (Ong) auth.getPrincipal();
//		Optional<Ong> ongFound = Optional.ofNullable(ongRepository.findByCnpj(ong.getCnpj()));
//		if (ong.isEmpty())
//			ResponseEntity.notFound().build();
//			return ;
		ongService.deleteOng(ong.getCnpj());
		return ResponseEntity.ok().build();
	}

//	@GetMapping("/delete/{cnpj}")
//	public String delete(@PathVariable("cnpj") String cnpj, Model model, BindingResult result, RedirectAttributes redirect ){
//		Ong ong = ongRepository.findByCnpj(cnpj);
//		System.out.println("CNPJ" + ong.getCnpj());
//		ongRepository.deleteById(cnpj);
//		return "redirect:/index";
//	}






}
