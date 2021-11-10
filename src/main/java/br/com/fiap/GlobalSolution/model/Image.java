package br.com.fiap.GlobalSolution.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@NotBlank
	@Size(max = 4000)
	private String url;
	
	@JsonBackReference
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="cnpj", nullable = false)
	@NotBlank
	private Ong ong;		
}
