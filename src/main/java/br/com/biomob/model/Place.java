package br.com.biomob.model;

import java.util.ArrayList;
import java.util.List;

import br.com.biomob.entity.Evaluation;
import br.com.biomob.model.google.GoogleResult;
import lombok.Data;

@Data
public class Place {

	private GoogleResult googleFields = new GoogleResult();

	private List<Evaluation> biomobEvaluation = new ArrayList<>();
	
	private Double biomobCirculacaoAverage;
	
	private Double biomobEstacionamentoAverage;
	
	private Double biomobCalcadaAverage;
	
	private Double biomobAudioVisualAverage;
	
	private Double biomobEntradaAverage;
	
	private Double biomobBanheiroAverage;
	
	private Double biomobStarAverage;
	
	private Double biomobCirculacaoCount;
	
	private Double biomobEstacionamentoCount;
	
	private Double biomobCalcadaCount;
	
	private Double biomobAudioVisualCount;
	
	private Double biomobEntradaCount;
	
	private Double biomobBanheiroCount;

}
