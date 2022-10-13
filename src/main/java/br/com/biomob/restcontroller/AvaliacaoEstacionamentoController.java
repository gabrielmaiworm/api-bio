package br.com.biomob.restcontroller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.biomob.entity.AvaliacaoEstacionamento;
import br.com.biomob.repository.AvaliacaoEstacionamentoRepository;

@CrossOrigin
@RestController
public class AvaliacaoEstacionamentoController {
	
	@Autowired
	private AvaliacaoEstacionamentoRepository avaliacaoEstacionamentoRepository;
	
	@PostMapping("/avaliacao-estacionamento")
	public AvaliacaoEstacionamento insertAvaliacaoEstacionamentoo(@RequestBody AvaliacaoEstacionamento avaliacaoEstacionamento) {
		avaliacaoEstacionamento.setAvaliacaoEstacionamentoId(UUID.randomUUID().toString());
		return avaliacaoEstacionamentoRepository.save(avaliacaoEstacionamento);
	}
	
	@GetMapping("/avaliacao-estacionamento/estacionamento/{estacionamentoId}")
	public List<AvaliacaoEstacionamento> findAvaliacaoEstacionamentoByEstacionamentoId(@PathVariable String estacionamentoId) {
		return avaliacaoEstacionamentoRepository.findByEstacionamentoId(estacionamentoId);
	}
	
	@GetMapping("/avaliacao-estacionamento/user/{userId}")
	public List<AvaliacaoEstacionamento> findAvaliacaoEstacionamentoByUserId(@PathVariable String userId) {
		return avaliacaoEstacionamentoRepository.findByUserId(userId);
	}
	
	@PutMapping("/avaliacao-estacionamento/{avaliacaoEstacionamentoId}")
	public void changeAvaliacaoEstacionamento(@PathVariable String avaliacaoEstacionamentoId, @RequestBody AvaliacaoEstacionamento avaliacaoEstacionamento) {
		avaliacaoEstacionamento.setAvaliacaoEstacionamentoId(avaliacaoEstacionamentoId);
		avaliacaoEstacionamentoRepository.save(avaliacaoEstacionamento);
	}
	
	@DeleteMapping("/avaliacao-estacionamento/{avaliacaoEstacionamentoId}")
	public void removeAvaliacaoEstacionamento(@PathVariable String avaliacaoEstacionamentoId) {
		avaliacaoEstacionamentoRepository.deleteById(avaliacaoEstacionamentoId);
	}	

}
