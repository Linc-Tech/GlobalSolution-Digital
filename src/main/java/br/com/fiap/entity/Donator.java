package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "T_DOADOR")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Donator {

	@Id
	@Column(name = "cpf", unique = true, length = 11)
	private String cpf;
	
	@Column(name = "name", nullable = false, length = 60)
	private String name;
	
	@Column(name = "email", nullable = false, length = 190)
	private String email;
}
