package br.com.fiap.GlobalSolution.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.fiap.GlobalSolution.exception.OngAlreedyRegisteredException;
import br.com.fiap.GlobalSolution.exception.OngNotFoundException;
import br.com.fiap.GlobalSolution.model.Image;
import br.com.fiap.GlobalSolution.model.Ong;
import br.com.fiap.GlobalSolution.repository.ImageRepository;
import br.com.fiap.GlobalSolution.repository.OngRepository;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OngService {
	
	private OngRepository repository;
	private ImageRepository repoImage;

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
		
		ong.setDonations(ongExists.getDonations());
		ong.setPassword(
				AuthenticationService
						.getPasswordEncoder()
						.encode(ong.getPassword()));

		
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

	public String addOngImage(@Valid Image img) {
		repoImage.save(img);
		
		return "OK";
	}



//	public String getOngLogada(){
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		String nome;
//
//		if (principal instanceof UserDetails) {
//			nome = ((UserDetails)principal).getUsername();
//		} else {
//			nome = principal.toString();
//		}
//		return nome;
//	}
}
