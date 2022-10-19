package br.com.biomob.model;

import java.util.ArrayList;
import java.util.List;

import br.com.biomob.entity.AvaliacaoEstacionamento;
import lombok.Data;

@Data
public class EstacionamentoFields {

	private List<AvaliacaoEstacionamento> biomobAvaliacaoEstacionamento = new ArrayList<>();
	
	private Boolean vagaAdequada;
	
	private Boolean ausenciaSinalizacao;
	
	private Boolean sinalizacaoInadequada;
	
	private Boolean impossivelUtilizacao;

	private Boolean outrosInadequada;
	
	private Boolean inexistente;
	
	private String comentario;
	
}
