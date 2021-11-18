package fiap.com.br.globalsolution.service;

import fiap.com.br.globalsolution.exception.OngAlreedyRegisteredException;
import fiap.com.br.globalsolution.exception.OngNotFoundException;
import fiap.com.br.globalsolution.model.Ong;
import fiap.com.br.globalsolution.repository.OngRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OngService {
	
	private OngRepository repository;

	public List<Ong> getAllOngs() {
		return repository.findAll();
	}

	public String addOng(Ong ong) {
		Optional<Ong> ongExists = repository.findByEmail(ong.getEmail());
		
		if(!ongExists.isEmpty()) 
			throw new OngAlreedyRegisteredException("ONG alreedy registered!");
		
		ong.setPassword(
				AuthenticationService
						.getPasswordEncoder()
						.encode(ong.getPassword()));

		repository.save(ong);
		return "OK";
	}

	public String updateOng(Ong ong) {
		Ong ongExists = repository.findByCnpj(ong.getCnpj());
		
		if(ongExists == null)
			throw new OngNotFoundException("ONG not found");
		
		ong.setPassword(AuthenticationService.getPasswordEncoder().encode(ong.getPassword()));	
		repository.save(ong);	
		
		return "OK";
	}

	public String deleteOng(String cnpj) {
		Ong ong = repository.findByCnpj(cnpj);
		
		if(ong == null) 
			throw new OngNotFoundException("ONG not found");
				
		repository.delete(ong);				
		return "OK";
	}
}
