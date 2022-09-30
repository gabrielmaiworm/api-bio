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

import br.com.biomob.entity.Evento;
import br.com.biomob.repository.EventoRepository;

@CrossOrigin
@RestController
public class EventoController {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@PostMapping("/evento")
	public Evento insertEvento(@RequestBody Evento evento) {
		evento.setEventoId(UUID.randomUUID().toString());
		return eventoRepository.save(evento);
	}
	
	@GetMapping("/evento/lista")
	public ResponseEntity<List<Evento>> listarTodos() {
		return ResponseEntity.ok(eventoRepository.findAll());
	}
	
	@GetMapping("/evento/{eventoId}")
	public Optional<Evento> encontrar(@PathVariable String eventoId) {
		return eventoRepository.findById(eventoId);
	}
	
	@PutMapping("/evento/{eventoId}")
	public void changeEvento(@PathVariable String eventoId, @RequestBody Evento evento) {
		evento.setEventoId(eventoId);
		eventoRepository.save(evento);
	}
	
	@DeleteMapping("/evento/{eventoId}")
	public void removeEvento(@PathVariable String eventoId) {
		eventoRepository.deleteById(eventoId);
	}	

}
