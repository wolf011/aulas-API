package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Gerente;
import org.serratec.backend.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

	@Autowired
	private GerenteRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Gerente inserir(@Valid @RequestBody Gerente gerente) {
		return repository.save(gerente);
	}

	@GetMapping
	public List<Gerente> listar() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Gerente> listarPorId(@PathVariable Long id) {
		Optional<Gerente> gerente = repository.findById(id);
		if (!gerente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(gerente.get());
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Gerente> inserir(@Valid @RequestBody List<Gerente> gerentes) {
		return repository.saveAll(gerentes);

	}

	@PutMapping("{id}")
	public ResponseEntity<Gerente> atualizar(@PathVariable Long id, @Valid @RequestBody Gerente gerente) {
		if (repository.existsById(id)) {
			gerente.setId(id);
			return ResponseEntity.ok(repository.save(gerente));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}




