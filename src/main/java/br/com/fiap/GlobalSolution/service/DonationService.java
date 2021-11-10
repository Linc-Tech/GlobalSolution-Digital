package br.com.fiap.GlobalSolution.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.GlobalSolution.exception.DonationNotFoundException;
import br.com.fiap.GlobalSolution.model.Donation;
import br.com.fiap.GlobalSolution.repository.DonationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DonationService {

	private DonationRepository repository;
		
	public String donate(@Valid Donation donation) {
		repository.save(donation);
		
		return "CRIADO";
	}

	public List<Donation> getAllDonations(String cnpj) {
		return repository.findDonationByOngCnpj(cnpj);
	}

	public String setDonationStatus(int id, boolean status) {
		Optional<Donation> donation = repository.findById(id);
		
		if(!donation.isPresent()) {
			throw new DonationNotFoundException("Donation not found");
		}
		
		donation.get().setConfirmation(status);
		repository.save(donation.get());	
		
		return "succes";		
	}
}
