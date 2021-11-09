package br.com.fiap.GlobalSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.GlobalSolution.model.Ong;

public interface OngRepository extends JpaRepository<Ong, String>{
	Ong findByCnpj(String cnpj);
}
