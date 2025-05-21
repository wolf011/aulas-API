package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Servico;
import org.serratec.backend.repository.SerivcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    // Usada para fazer a injeção de dependências(vair criar os objetos)
    @Autowired
    private SerivcoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico inserir(@Valid @RequestBody Servico servico) {

        return repository.save(servico);
    }

    @PostMapping("/inseirVarios")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Servico> inserirVarios(@Valid @RequestBody List<Servico> servicos) {
        return repository.saveAll(servicos);
    }

    @GetMapping
    public List<Servico> listar() {

        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Servico> listarPorId(@PathVariable Long id) {
        Optional<Servico> servico = repository.findById(id);
        if (servico.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servico.get());
    }

    @PutMapping("{id}")
    public ResponseEntity<Servico> atualizar(@PathVariable Long id,@Valid @RequestBody Servico servico) {
        if (repository.findById(id).isPresent()) {
            servico.setId(id);
            return ResponseEntity.ok(repository.save(servico));
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        return ResponseEntity.notFound().build();
    }
}
