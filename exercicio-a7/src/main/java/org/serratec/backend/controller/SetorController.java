package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Setor;
import org.serratec.backend.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/setores")
public class SetorController {

	@Autowired
	private SetorRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Setor inserir(@Valid @RequestBody Setor setor) {
		return repository.save(setor);
	}

	@GetMapping
	public List<Setor> listar() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Setor> listarPorId(@PathVariable Long id) {
		Optional<Setor> setor = repository.findById(id);
		if (!setor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(setor.get());
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Setor> inserir(@Valid @RequestBody List<Setor> setores) {
		return repository.saveAll(setores);

	}

	@PutMapping("{id}")
	public ResponseEntity<Setor> atualizar(@PathVariable Long id, @Valid @RequestBody Setor setor) {
		if (repository.existsById(id)) {
			setor.setId(id);
			return ResponseEntity.ok(repository.save(setor));
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




