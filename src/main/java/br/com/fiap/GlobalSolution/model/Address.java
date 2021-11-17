package br.com.fiap.GlobalSolution.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	@NotBlank(message = "O campo Endereço é obrigatório")
	@Min(value = 10, message = "O campo precisa ter ao menos 10 caracteres")
	@Max(value = 280, message = "O campo não pode ultrapassar 10 caracteres")
	private String address;
	
	@Column(name = "cep", nullable = false, length = 8)
	@NotBlank(message = "O campo CEP é obrigatório")
	@Size(min = 8, max = 8, message = "CEP inválido")
	private String cep;

	@Column(name = "estado", nullable = false, length = 2)
	@NotBlank(message = "O campo Estado é obrigatório")
	@Min(value = 2, message = "O campo precisa ter ao menos 2 caracteres")
	@Max(value = 2, message = "O campo não pode ultrapassar 2 caracteres")
	private String state;
	
	@Column(name = "numero", nullable = false, length = 10)
	@NotBlank(message = "O campo Número é obrigatório")
	@Max(value = 2, message = "O campo não pode ultrapassar 2 caracteres")
	private String number;
	
	
	@Column(name = "complemento", length = 30)
	@Size(min = 10, max = 30)
	@Min(value = 10, message = "O campo precisa ter ao menos 10 caracteres")
	@Max(value = 30, message = "O campo não pode ultrapassar 30 caracteres")
	private String complement;
}
