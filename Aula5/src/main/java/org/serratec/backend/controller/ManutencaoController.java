package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Manutencao;
import org.serratec.backend.repository.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {

    // Usada para fazer a injeção de dependências(vair criar os objetos)
    @Autowired
    private ManutencaoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manutencao inserir(@Valid @RequestBody Manutencao manutencao) {

        return repository.save(manutencao);
    }

    @PostMapping("/inseirVarios")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Manutencao> inserirVarios(@Valid @RequestBody List<Manutencao> manutencoes) {
        return repository.saveAll(manutencoes);
    }

    @GetMapping
    public List<Manutencao> listar() {

        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Manutencao> listarPorId(@PathVariable Long id) {
        Optional<Manutencao> manutencao = repository.findById(id);
        if (manutencao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(manutencao.get());
    }

    @PutMapping("{id}")
    public ResponseEntity<Manutencao> atualizar(@PathVariable Long id,@Valid @RequestBody Manutencao manutencao) {
        if (repository.findById(id).isPresent()) {
            manutencao.setId(id);
            return ResponseEntity.ok(repository.save(manutencao));
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
