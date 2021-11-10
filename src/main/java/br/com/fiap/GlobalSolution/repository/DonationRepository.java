package br.com.fiap.GlobalSolution.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.GlobalSolution.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Integer>{
	
	List<Donation> findDonationByOngCnpj(String cnpj);
}
