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
		
		
		estacionamentoFields.setVagaAdequada(vagaAdequadaField(estacionamentoFields.getBiomobAvaliacaoEstacionamento()));
		
		estacionamentoFields.setAusenciaSinalizacao(ausenciaSinalizacaoField(estacionamentoFields.getBiomobAvaliacaoEstacionamento()));
		
		estacionamentoFields.setSinalizacaoInadequada(sinalizacaoInadequadaField(estacionamentoFields.getBiomobAvaliacaoEstacionamento()));
		
		estacionamentoFields.setImpossivelUtilizacao(impossivelUtilizacaoField(estacionamentoFields.getBiomobAvaliacaoEstacionamento()));
		
		estacionamentoFields.setOutrosInadequada(outrosInadequadaField(estacionamentoFields.getBiomobAvaliacaoEstacionamento()));
		
		estacionamentoFields.setInexistente(inexistenteField(estacionamentoFields.getBiomobAvaliacaoEstacionamento()));
		
		estacionamentoFields.setComentario(comentarioField(estacionamentoFields.getBiomobAvaliacaoEstacionamento()));
		
		
		estacionamentoReturns.getEstacionamentoFields().add(estacionamentoFields);
		
		
		return toEstacionamentoFields();
	}
	
	private String ausenciaSinalizacaoField(List<AvaliacaoEstacionamento> ausenciaSinalizacao) {

		return avaliacaoEstacionamento.getAusenciaSinalizacao();
	}
	
	private String vagaAdequadaField(List<AvaliacaoEstacionamento> vagaAdequada) {

		return avaliacaoEstacionamento.getVagaAdequada();
	}
	
	private String sinalizacaoInadequadaField(List<AvaliacaoEstacionamento> sinalizacaoInadequada) {

		return avaliacaoEstacionamento.getSinalizacaoInadequada();
	}
	

	private String impossivelUtilizacaoField(List<AvaliacaoEstacionamento> impossivelUtilizacao) {
		
		return avaliacaoEstacionamento.getImpossivelUtilizacao();
	}

	private String outrosInadequadaField(List<AvaliacaoEstacionamento> outrosInadequada) {
		
		return avaliacaoEstacionamento.getOutrosInadequada();
	}

	private String inexistenteField(List<AvaliacaoEstacionamento> inexistente) {
		
		return avaliacaoEstacionamento.getInexistente();
	}
	
	private String comentarioField(List<AvaliacaoEstacionamento> comentario) {
			
		return avaliacaoEstacionamento.getComentario();
	}
	
	private List<AvaliacaoEstacionamento> findAvaliacaoEstacionamento(String estacionamento_id) {
		return avaliacaoEstacionamentoRepository.findByEstacionamentoId(estacionamento_id);
	}
		
}
