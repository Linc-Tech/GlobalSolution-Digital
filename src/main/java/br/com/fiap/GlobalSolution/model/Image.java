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

@Entity(name = "T_IMG_ONG")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="img", sequenceName = "SQ_TB_IMG_ONG", allocationSize = 1)
public class Image {
	
	@Id
	@Column(name = "id_img", unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "img")
	private int id;
	
	@Column(name = "url_img", nullable = false, length = 4000)
	private String url;
	
	@OneToOne
	@JoinColumn(name="cnpj", nullable = false)
	private Ong cnpj;		
}
