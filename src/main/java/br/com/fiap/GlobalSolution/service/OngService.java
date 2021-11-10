package br.com.fiap.GlobalSolution.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.GlobalSolution.exception.OngAlreedyRegisteredException;
import br.com.fiap.GlobalSolution.exception.OngNotFoundException;
import br.com.fiap.GlobalSolution.model.Ong;
import br.com.fiap.GlobalSolution.repository.OngRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OngService {
	
	private OngRepository repository;

	public List<Ong> getAllOngs() {
		return repository.findAll();
			
	}

	public String addOng(Ong ong) {
		Ong ongExists = repository.findByCnpjAndEmail(ong.getCnpj(), ong.getEmail());
		
		if(ongExists != null) 
			throw new OngAlreedyRegisteredException("ONG alreedy registered!");		
		
		repository.save(ong);			
		return "OK";
	}

	public String updateOng(Ong ong) {
		Ong ongExists = repository.findByCnpj(ong.getCnpj());
		
		if(ongExists == null) 
			throw new OngNotFoundException("ONG not found");
		
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
