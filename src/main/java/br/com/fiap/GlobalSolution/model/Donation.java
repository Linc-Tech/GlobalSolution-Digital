package br.com.fiap.GlobalSolution.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "T_DOACOES_ONG")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="doacoes", sequenceName = "SQ_TB_DOACOES_ONG", allocationSize = 1)
public class Donation {
	
	@Id
	@Column(name="id_doacao", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doacoes")
	private int id;
	
	@Column(name="valor", nullable = false)
	@NotBlank
	private float value;
	
	@Column(name="confirmacao", nullable = false)
	private boolean confirmation;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ong_cnpj")
	private Ong ong;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_donator")
	private Donator donator;
}
