package br.com.fiap.GlobalSolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.GlobalSolution.model.Donation;
import br.com.fiap.GlobalSolution.model.Ong;
import br.com.fiap.GlobalSolution.service.DonationService;
import br.com.fiap.GlobalSolution.service.OngService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/gs")
@AllArgsConstructor(onConstructor = @__( @Autowired ))
public class OngController {
		
	private OngService ongService;
	private DonationService donationService;
	
	@GetMapping
	public List<Ong> getAll() {				
		return ongService.getAllOngs();
	}
		
    @PostMapping("/create")
	public String create(@RequestBody Ong ong) {
		return ongService.addOng(ong);
	}
	
	@PutMapping
	public String update(@RequestBody Ong ong) {
		return ongService.updateOng(ong);
	}
	
	@DeleteMapping("/cnpj={cnpj}")
	public String delete(@PathVariable String cnpj) {
		return ongService.deleteOng(cnpj);
	}
	
	 @PostMapping("/donate")    
	public String donate(@RequestBody Donation donation) {
		return donationService.donate(donation);
	}
		
	
	
}
