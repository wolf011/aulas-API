package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Cliente;
import org.serratec.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    // Usada para fazer a injeção de dependências(vair criar os objetos)
    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente inserir(@Valid @RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @PostMapping("/inseirVarios")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Cliente> inserirVarios(@RequestBody List<Cliente> clientes) {
        return repository.saveAll(clientes);
    }

    @GetMapping
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable UUID id) {
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente.get());
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable UUID id, @RequestBody Cliente cliente) {
        if (repository.findById(id).isPresent()) {
            cliente.setId(id);
            return ResponseEntity.ok(repository.save(cliente));
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover(@PathVariable UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        return ResponseEntity.notFound().build();
    }
}
