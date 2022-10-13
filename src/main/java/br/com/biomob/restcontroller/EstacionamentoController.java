package br.com.biomob.restcontroller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.biomob.entity.Estacionamento;
import br.com.biomob.repository.EstacionamentoRepository;

@CrossOrigin
@RestController
public class EstacionamentoController {
	
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
	
	@PostMapping("/estacionamento")
	public Estacionamento insertEstacionamento(@RequestBody Estacionamento estacionamento) {
		estacionamento.setEstacionamentoId(UUID.randomUUID().toString());
		return estacionamentoRepository.save(estacionamento);
	}
	
	@GetMapping("/estacionamento/lista")
	public ResponseEntity<List<Estacionamento>> listarTodos() {
		return ResponseEntity.ok(estacionamentoRepository.findAll());
	}
	
	@GetMapping("/estacionamento/{estacionamentoId}")
	public Optional<Estacionamento> encontrar(@PathVariable String estacionamentoId) {
		return estacionamentoRepository.findById(estacionamentoId);
	}
	
	@PutMapping("/estacionamento/{estacionamentoId}")
	public void changeEstacionamento(@PathVariable String estacionamentoId, @RequestBody Estacionamento estacionamento) {
		estacionamento.setEstacionamentoId(estacionamentoId);
		estacionamentoRepository.save(estacionamento);
	}
	
	@DeleteMapping("/estacionamento/{estacionamentoId}")
	public void removeEstacionamento(@PathVariable String estacionamentoId) {
		estacionamentoRepository.deleteById(estacionamentoId);
	}	

}
