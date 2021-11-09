package br.com.fiap.GlobalSolution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.GlobalSolution.model.Donation;
import br.com.fiap.GlobalSolution.repository.DonationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DonationService {

	private DonationRepository repository;
	
	
	public String donate(Donation donation) {
		repository.save(donation);
		
		return "CRIADO";
	}
}
