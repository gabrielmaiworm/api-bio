package br.com.biomob.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

	//Feito seguindo a feature https://docs.google.com/document/d/1QH0od0wAPw4XHGiR9o-0PRTfmmnFjUcxMV863JBO3gc/edit

@Data
@Entity
@Table(name = "biomob_plus_estacionamento")
public class Estacionamento {
	
	@Id
	@Column(name = "estacionamento_id")
	private String estacionamentoId;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "tipo_vaga")
	private String tipoVaga;
	
	@Column(name = "qntd_vagas")
	private Integer qntdVagas;
	
	@Column(name = "detalhes")
	private String detalhes;

}
