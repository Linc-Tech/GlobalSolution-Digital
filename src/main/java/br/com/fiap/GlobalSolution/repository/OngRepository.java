package br.com.fiap.GlobalSolution.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.GlobalSolution.model.Ong;

import java.util.Optional;
    
public interface OngRepository extends JpaRepository<Ong, String>{
	Ong findByCnpj(String cnpj);
    Optional<Ong> findByEmail(String email);
}
