package br.com.fiap.GlobalSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.GlobalSolution.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
