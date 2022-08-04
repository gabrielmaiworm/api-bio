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

import br.com.biomob.entity.Emprego;
import br.com.biomob.repository.EmpregoRepository;

@CrossOrigin
@RestController
public class EmpregoController {
	
	@Autowired
	private EmpregoRepository empregoRepository;
	
	@PostMapping("/emprego")
	public Emprego insertEmprego(@RequestBody Emprego emprego) {
		emprego.setEmpregoId(UUID.randomUUID().toString());
		return empregoRepository.save(emprego);
	}
	
	@GetMapping("/emprego/lista")
	public ResponseEntity<List<Emprego>> listarTodos() {
		return ResponseEntity.ok(empregoRepository.findAll());
	}
	
	@GetMapping("/emprego/{empregoId}")
	public Optional<Emprego> encontrar(@PathVariable String empregoId) {
		return empregoRepository.findById(empregoId);
	}
	
	@PutMapping("/emprego/{empregoId}")
	public void changeEmprego(@PathVariable String empregoId, @RequestBody Emprego emprego) {
		emprego.setEmpregoId(empregoId);
		empregoRepository.save(emprego);
	}
	
	@DeleteMapping("/emprego/{empregoId}")
	public void removeEmprego(@PathVariable String empregoId) {
		empregoRepository.deleteById(empregoId);
	}	

}
