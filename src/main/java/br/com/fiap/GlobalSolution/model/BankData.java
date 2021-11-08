package br.com.fiap.GlobalSolution.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "T_DADOS_BANCARIOS_ONG")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="bankData", sequenceName = "SQ_TB_DADOS_BANCARIOS_ONG", allocationSize = 1)
public class BankData {
	
	@Id
	@Column(name = "id_conta_bancaria", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bankData")
	private int id;
	
	@Column(name = "agencia", nullable = false, length = 9)
	private String agency;	
	
	@Column(name = "conta", nullable = false, length = 15)
	private String account;	
	
	@OneToOne
	@JoinColumn(name="cnpj", nullable = false)
	private Ong ong;
}
