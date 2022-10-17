package br.com.biomob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biomob.entity.AvaliacaoEstacionamento;
import br.com.biomob.interfaces.IAvaliacaoEstacionamentoService;
import br.com.biomob.model.EstacionamentoFields;
import br.com.biomob.model.EstacionamentoReturns;
import br.com.biomob.repository.AvaliacaoEstacionamentoRepository;

@Service
public class BiomobEstacionamentoService implements IAvaliacaoEstacionamentoService {
	
	@Autowired
	private AvaliacaoEstacionamentoRepository avaliacaoEstacionamentoRepository;
	
	AvaliacaoEstacionamento avaliacaoEstacionamento = new AvaliacaoEstacionamento();
	
	
	private EstacionamentoFields toEstacionamentoFields() {
		
		EstacionamentoReturns  estacionamentoReturns= new EstacionamentoReturns();
		
		EstacionamentoFields  estacionamentoFields = new EstacionamentoFields();
		
		
		estacionamentoFields.setAvaliacao(avaliacaoField(estacionamentoFields.getBiomobAvaliacaoEstacionamento()));
		
		estacionamentoFields.setMotivoInadequada(motivoInadequadaField(estacionamentoFields.getBiomobAvaliacaoEstacionamento()));
		
		estacionamentoFields.setComentario(comentarioField(estacionamentoFields.getBiomobAvaliacaoEstacionamento()));
		
		
		estacionamentoReturns.getEstacionamentoFields().add(estacionamentoFields);
		
		
		return toEstacionamentoFields();
	}
	
	private String avaliacaoField(List<AvaliacaoEstacionamento> avaliacao) {

		return avaliacaoEstacionamento.getAvaliacao();
	}
	
	private String motivoInadequadaField(List<AvaliacaoEstacionamento> motivoInadequada) {
		
		return avaliacaoEstacionamento.getMotivoInadequada();
	}
	
	private String comentarioField(List<AvaliacaoEstacionamento> comentario) {
			
		return avaliacaoEstacionamento.getComentario();
	}
	
	private List<AvaliacaoEstacionamento> findAvaliacaoEstacionamento(String estacionamento_id) {
		return avaliacaoEstacionamentoRepository.findByEstacionamentoId(estacionamento_id);
	}
		
}