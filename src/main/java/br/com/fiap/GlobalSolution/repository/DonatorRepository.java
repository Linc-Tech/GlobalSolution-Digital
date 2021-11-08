package br.com.fiap.GlobalSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.GlobalSolution.model.Donator;

public interface DonatorRepository extends JpaRepository<Donator, String> {

}
