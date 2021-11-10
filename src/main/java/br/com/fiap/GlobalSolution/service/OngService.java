package br.com.fiap.GlobalSolution.service;

import br.com.fiap.GlobalSolution.model.Ong;
import br.com.fiap.GlobalSolution.repository.OngRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.fiap.GlobalSolution.model.Ong;
import br.com.fiap.GlobalSolution.repository.OngRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OngService {
	
	private OngRepository repository;

	public List<Ong> getAllOngs() {
		return repository.findAll();		
	}

	public String addOng(Ong ong) {
		ong.setPassword(
				AuthenticationService
						.getPasswordEncoder()
						.encode(ong.getPassword()));

		repository.save(ong);

		return "CRIADO";
	}

	public String updateOng(Ong ong) {
		Ong ongExists = repository.findByCnpj(ong.getCnpj());
		
		if(ongExists != null) { 
			
			repository.save(ong);	
			
			return "ATUALIZADO";
		}
					
		return "ong nao existe";
	}

	public String deleteOng(String cnpj) {
		Ong ong = repository.findByCnpj(cnpj);
		
		if(ong != null) { 
			
			repository.delete(ong);
			
			return "APAGADO";
		}
		
		
		return "ONG NAO EXISTE";
	}
}
