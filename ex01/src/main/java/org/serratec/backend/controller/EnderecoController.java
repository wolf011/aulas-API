package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Endereco;
import org.serratec.backend.repository.EnderecoRepository;
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

    @GetMapping("/listar")
    public List<Endereco> listar() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable Long id){
        Optional<Endereco> endereco = repository.findById(id);
        if(endereco.isPresent()){
            return ResponseEntity.ok(endereco.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco adicionar(@Valid @RequestBody Endereco endereco){
        return repository.save(endereco);
    }

    @PostMapping("/adicionarLista")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Endereco> adicionarLista(@RequestBody List<Endereco> enderecos){
        return repository.saveAll(enderecos);
    }

    @PutMapping("{id}")
    public ResponseEntity<Endereco> alterar(@Valid @PathVariable Long id, @RequestBody Endereco endereco){
        if(repository.findById(id).isPresent()){
            endereco.setId(id);
            return ResponseEntity.ok(repository.save(endereco));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Endereco> remover(@Valid @PathVariable Long id){
        Optional<Endereco> endereco = repository.findById(id);
        if(endereco.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
