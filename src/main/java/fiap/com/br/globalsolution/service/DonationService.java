package fiap.com.br.globalsolution.service;

import fiap.com.br.globalsolution.exception.DonationNotFoundException;
import fiap.com.br.globalsolution.model.Donation;
import fiap.com.br.globalsolution.model.Ong;
import fiap.com.br.globalsolution.repository.DonationRepository;
import fiap.com.br.globalsolution.repository.OngRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
		donation.setPending(true);
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
		donation.get().setPending(false);
		repository.save(donation.get());	
		
		return "succes";		
	}
}
