package br.com.fiap.GlobalSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.GlobalSolution.model.BankData;

public interface BankDataRepositoy extends JpaRepository<BankData, Integer> {

}
