package br.com.fiap.GlobalSolution.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.persistence.CascadeType;

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
	@NotBlank
	private String cnpj;
	
	@Column(name = "nome", nullable = false, length = 60)
	@NotBlank
	private String name;
	
	@Column(name = "email", nullable = false, length = 190)
	@NotBlank
	private String email;
	
	@Column(name = "senha", nullable = false, length = 15)
	@NotBlank
	private String password;
	
	@Column(name = "descricao", length = 250)
	@NotBlank
	private String description;
	
	@Column(name = "url_ong", length = 4000)
	private String ongUrl;	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_endereco")
	private Address address;	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_conta")
	private BankData account;
}
