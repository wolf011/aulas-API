package org.serratec.backend.controller;


import jakarta.validation.Valid;
import org.serratec.backend.entity.Endereco;
import org.serratec.backend.reporsitory.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    
    @Autowired
    private EnderecoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco inserir(@Valid @RequestBody Endereco endereco) {

        return repository.save(endereco);
    }

    @PostMapping("/inseirVarios")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Endereco> inserirVarios(@Valid @RequestBody List<Endereco> enderecos) {
        return repository.saveAll(enderecos);
    }

    @GetMapping
    public List<Endereco> listar() {

        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Endereco> listarPorId(@PathVariable Long id) {
        Optional<Endereco> endereco = repository.findById(id);
        if (endereco.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(endereco.get());
    }

    @PutMapping("{id}")
    public ResponseEntity<Endereco> atualizar(@PathVariable Long id,@Valid @RequestBody Endereco endereco) {
        if (repository.findById(id).isPresent()) {
            endereco.setId(id);
            return ResponseEntity.ok(repository.save(endereco));
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
