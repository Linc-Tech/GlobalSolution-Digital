package br.com.fiap.GlobalSolution.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "T_ONG")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ong {
	@Id
	@Column(name = "cnpj", unique = true, length = 14)
	private String cnpj;
	
	@Column(name = "nome", nullable = false, length = 60)
	private String name;
	
	@Column(name = "email", nullable = false, length = 190)
	private String email;
	
	@Column(name = "senha", nullable = false, length = 15)
	private String password;
	
	@Column(name = "descricao", length = 250)
	private String description;
	
	@Column(name = "url_ong", length = 4000)
	private String ongUrl;	
}
