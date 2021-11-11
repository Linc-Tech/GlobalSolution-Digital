package br.com.fiap.GlobalSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.GlobalSolution.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {
	
}
