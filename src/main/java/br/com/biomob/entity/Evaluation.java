package br.com.biomob.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.biomob.model.evaluation.ValuesType;
import lombok.Data;

@Data
@Entity
@Table(name = "biomob_plus_evaluator")
public class Evaluation {
	
	@Id
	@Column(name = "evaluation_id")
	private String evaluationId; //id da avaliacao
	
	@Column(name = "place_id")
	private String placeId; //id do lugar (google)
	
	@Column(name = "place_name")
	private String placeName; //nome do lugar
	
	@Column(name = "user_id")
	private String userId; //id do usuario biomob plus
	
	@Column(name = "user_name")
	private String userName; //nome do usuario biomob plus
	
	@Column(name= "user_image")
	private String user_image; //avatar usuario
	
	@Column(name = "comentario")
	private String comentario; //comentario 
	
	@Column(name = "data")
	private String data; //data 
	
	@Column(name = "circulacao_interna")
	private Double circulacaoInterna; 
	
	@Column(name = "circulacao_interna_na")
	private boolean circulacaoInternaNA; 
	
	@Column(name = "estacionamento")
	private Double estacionamento;
	
	@Column(name = "estacionamento_na")
	private boolean estacionamentoNA;
	
	@Column(name = "calcada")
	private Double calcada;
	
	@Column(name = "calcada_na")
	private boolean calcadaNA;
	
	@Column(name = "audio_visual")
	private Double audioVisual;
	
	@Column(name = "audio_visual_na")
	private boolean audioVisualNA;
	
	@Column(name = "entrada_principal")
	private Double entradaPrincipal;
	
	@Column(name = "entrada_principal_na")
	private boolean entradaPrincipalNA;
	
	@Column(name = "banheiro_acessivel")
	private Double banheiroAcessivel;
	
	@Column(name = "banheiro_acessivel_na")
	private boolean banheiroAcessivelNA;
	
	@Column(name = "star")
	private Double star; //nota

	
	

	
}
