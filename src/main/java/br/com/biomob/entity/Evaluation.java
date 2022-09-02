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
	private Double circulacaoInterna; 
	
	@Column(name = "estacionamento")
	private Double estacionamento;
	
	@Column(name = "calcada")
	private Double calcada;
	
	@Column(name = "audioVisual")
	private Double audioVisual;
	
	@Column(name = "entradaPrincipal")
	private Double entradaPrincipal;
	
	@Column(name = "banheiroAcessivel")
	private Double banheiroAcessivel;
	
	@Column(name = "star")
	private Double star; //nota
	

	
}
