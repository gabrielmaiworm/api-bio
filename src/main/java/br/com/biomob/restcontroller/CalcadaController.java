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

import br.com.biomob.entity.Calcada;
import br.com.biomob.repository.CalcadaRepository;

@CrossOrigin
@RestController
public class CalcadaController {
	
	@Autowired
	private CalcadaRepository calcadaRepository;
	
	@PostMapping("/calcada")
	public Calcada insertCalcada(@RequestBody Calcada calcada) {
		calcada.setCalcadaId(UUID.randomUUID().toString());
		return calcadaRepository.save(calcada);
	}
	
	@GetMapping("/calcada/lista")
	public ResponseEntity<List<Calcada>> listarTodos() {
		return ResponseEntity.ok(calcadaRepository.findAll());
	}
	
	@GetMapping("/calcada/{calcadaId}")
	public Optional<Calcada> encontrar(@PathVariable String calcadaId) {
		return calcadaRepository.findById(calcadaId);
	}
	
	@PutMapping("/calcada/{calcadaId}")
	public void changeCalcada(@PathVariable String calcadaId, @RequestBody Calcada calcada) {
		calcada.setCalcadaId(calcadaId);
		calcadaRepository.save(calcada);
	}
	
	@DeleteMapping("/calcada/{calcadaId}")
	public void removeCalcada(@PathVariable String calcadaId) {
		calcadaRepository.deleteById(calcadaId);
	}	

}
