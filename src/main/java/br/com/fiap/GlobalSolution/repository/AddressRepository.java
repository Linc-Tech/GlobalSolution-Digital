package br.com.fiap.GlobalSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.GlobalSolution.model.Address;


public interface AddressRepository  extends JpaRepository<Address, Integer> {

}
