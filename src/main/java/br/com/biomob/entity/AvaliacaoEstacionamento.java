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
	private String vagaAdequada; 
	
	@Column(name = "ausencia_sinalizacao")
	private String ausenciaSinalizacao;

	@Column(name = "sinalizacao_inadequada")
	private String sinalizacaoInadequada; 
	
	@Column(name = "impossivel_utilizacao")
	private String impossivelUtilizacao; 

	@Column(name = "outros_inadequada")
	private String outrosInadequada;

	@Column(name = "inexistente")
	private String inexistente; 
	
	@Column(name = "comentario")
	private String comentario; 
	
}
