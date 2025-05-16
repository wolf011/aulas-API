package org.serratec.backend.controller;

import org.serratec.backend.entity.Cliente;
import org.serratec.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Clientes")
public class ClienteController {

    //    Instacia os objetos
    @Autowired
    private ClienteRepository repository;

    //    Métodos POST
    @PostMapping("/inserir")
    @ResponseStatus(HttpStatus.CREATED)     // Retorna o código 201 de sucesso do método
    public Cliente inserir(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @PostMapping("/inserirVarios")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Cliente> inserirVarios(@RequestBody List<Cliente> clientes) {
        return repository.saveAll(clientes);
    }

    //    Métodos GET

    @GetMapping("/listarTodos")
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {
        Optional<Cliente> clientes = repository.findById(id);
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes.get());
    }

    //    Métodos POST
    @PutMapping("{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        if (repository.findById(id).isPresent()) {
            cliente.setId(id);
            return ResponseEntity.ok(repository.save(cliente));
        }
        return ResponseEntity.notFound().build();
    }

    //  Métodos DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        return ResponseEntity.notFound().build();
    }
}
