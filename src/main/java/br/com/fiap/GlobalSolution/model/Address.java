package br.com.fiap.GlobalSolution.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "T_ENDERECO_ONG")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="end", sequenceName = "SQ_TB_ENDERECO_ONG", allocationSize = 1)
public class Address {
	
	@Id
	@Column(name = "id_endereco", unique = true)   
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "end")
	private int id;
	
	@Column(name = "endereco", nullable = false, length = 280)
	@NotBlank
	@Size(min = 10, max = 280)
	private String address;
	
	@Column(name = "cep", nullable = false, length = 8)
	@NotBlank
	@Size(min = 8, max = 8)
	private String cep;

	@Column(name = "estado", nullable = false, length = 2)
	@NotBlank
	@Size(min = 2, max = 2)
	private String state;
	
	@Column(name = "numero", nullable = false, length = 10)
	@NotBlank
	@Size(min = 1, max = 10)
	private String number;
	
	
	@Column(name = "complemento", length = 30)
	@Size(min = 10, max = 30)
	private String complement;
}
