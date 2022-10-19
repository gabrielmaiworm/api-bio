package br.com.biomob.model;

import java.util.ArrayList;
import java.util.List;

import br.com.biomob.entity.AvaliacaoEstacionamento;
import lombok.Data;

@Data
public class EstacionamentoFields {

	private List<AvaliacaoEstacionamento> biomobAvaliacaoEstacionamento = new ArrayList<>();
	
	private String vagaAdequada;
	
	private String vagaInadequada;
	
	private String vagaInexistente;
	
	private String motivoInadequada;
	
	private String comentario;
	
}
