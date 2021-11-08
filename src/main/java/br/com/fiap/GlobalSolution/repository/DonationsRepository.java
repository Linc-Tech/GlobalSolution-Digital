package br.com.fiap.GlobalSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.GlobalSolution.model.Donations;

public interface DonationsRepository extends JpaRepository<Donations, Integer>{

}
