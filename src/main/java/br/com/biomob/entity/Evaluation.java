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
	
	//@Column(name = "internal_circulation")
	//@Enumerated(EnumType.STRING)
	//private ValuesType internalCirculation; //circulacão interna - Resultados possiveis: YES | NO | NOT_APPLICABLE | NONE
	
	//@Column(name = "parking")
	//@Enumerated(EnumType.STRING)
	//private ValuesType parking; //estacionamento - Resultados possiveis: YES | NO | NOT_APPLICABLE | NONE
	
	//@Column(name = "sidewalk")
	//@Enumerated(EnumType.STRING)
	//private ValuesType sidewalk; //calcada - Resultados possiveis: YES | NO | NOT_APPLICABLE | NONE
	
	//@Column(name = "audio_visual")
	//@Enumerated(EnumType.STRING)
	//private ValuesType audioVisual; //audio/visual - Resultados possiveis: YES | NO | NOT_APPLICABLE | NONE
	
	//@Column(name = "main_entrance")
	//@Enumerated(EnumType.STRING)
	//private ValuesType mainEntrance; //entrada principal - Resultados possiveis: YES | NO | NOT_APPLICABLE | NONE
	
	//@Column(name = "accessible_bathroom")
	//@Enumerated(EnumType.STRING)
	//private ValuesType accessibleBathroom; //banheiro acessivel - Resultados possiveis: YES | NO | NOT_APPLICABLE | NONE
	
	@Column(name = "circulacao_interna")
	private Double circulacaoInterna = 2.5; 
	
	@Column(name = "circulacao_interna_na")
	private boolean circulacaoInternaNA; 
	
	@Column(name = "estacionamento")
	private Double estacionamento = 2.5;
	
	@Column(name = "estacionamento_na")
	private boolean estacionamentoNA;
	
	@Column(name = "calcada")
	private Double calcada = 2.5;
	
	@Column(name = "calcada_na")
	private boolean calcadaNA;
	
	@Column(name = "audio_visual")
	private Double audioVisual = 2.5;
	
	@Column(name = "audio_visual_na")
	private boolean audioVisualNA;
	
	@Column(name = "entrada_principal")
	private Double entradaPrincipal = 2.5;
	
	@Column(name = "entrada_principal_na")
	private boolean entradaPrincipalNA;
	
	@Column(name = "banheiro_acessivel")
	private Double banheiroAcessivel = 2.5;
	
	@Column(name = "banheiro_acessivel_na")
	private boolean banheiroAcessivelNA;
	
	@Column(name = "star")
	private Double star; //nota

	
	

	
}
