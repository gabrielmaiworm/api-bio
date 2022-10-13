package br.com.biomob.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class EstacionamentoReturns {
	
	private List<EstacionamentoFields> estacionamentoFields = new ArrayList<>();
	
}
