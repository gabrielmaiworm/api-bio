package br.com.biomob.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

	//Feito seguindo a feature https://docs.google.com/document/d/1QH0od0wAPw4XHGiR9o-0PRTfmmnFjUcxMV863JBO3gc/edit

@Data
@Entity
@Table(name = "biomob_plus_avaliacao_estacionamento")
public class AvaliacaoEstacionamento {
	
	@Id
	@Column(name = "avaliacao_estacionamento_id")
	private String avaliacaoEstacionamentoId; 
	
	@Column(name = "estacionamento_id")
	private String estacionamentoId; 
	
	@Column(name = "endereco_estacionamento")
	private String enderecoEstacionamento; 
	
	@Column(name = "user_id")
	private String userId; 
	
	@Column(name = "user_name")
	private String userName; 
	
	@Column(name= "user_image")
	private String user_image; 
	
	@Column(name = "vaga_adequada")
	private Boolean vagaAdequada; 
	
	@Column(name = "ausencia_sinalizacao")
	private Boolean ausenciaSinalizacao;

	@Column(name = "sinalizacao_inadequada")
	private Boolean sinalizacaoInadequada; 
	
	@Column(name = "impossivel_utilizacao")
	private Boolean impossivelUtilizacao; 

	@Column(name = "outros_inadequada")
	private Boolean outrosInadequada;

	@Column(name = "inexistente")
	private Boolean inexistente; 
	
	@Column(name = "comentario")
	private String comentario; 
	
}
