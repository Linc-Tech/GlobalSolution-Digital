package br.com.fiap.GlobalSolution.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.GlobalSolution.exception.DonationNotFoundException;
import br.com.fiap.GlobalSolution.model.Donation;
import br.com.fiap.GlobalSolution.model.Ong;
import br.com.fiap.GlobalSolution.repository.DonationRepository;
import br.com.fiap.GlobalSolution.repository.OngRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DonationService {

	private DonationRepository repository;
	private OngRepository ongRepository;

		
	public void donate(@Valid Donation donation) {
		Ong ong = ongRepository.findByCnpj(donation.getOng().getCnpj());
		
		if(ong == null) 
			return;
		
		donation.setOng(ong);		
		repository.save(donation);
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
