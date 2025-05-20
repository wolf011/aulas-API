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

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping("/listar")
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        Optional<Cliente> cliente = repository.findById(id);
        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente){
        return repository.save(cliente);
    }

    @PostMapping("/adicionarLista")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Cliente> adicionarLista(@RequestBody List<Cliente> clientes){
        return repository.saveAll(clientes);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> alterar(@Valid @PathVariable Long id, @RequestBody Cliente cliente){
        if(repository.findById(id).isPresent()){
            cliente.setId(id);
            return ResponseEntity.ok(repository.save(cliente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cliente> remover(@Valid @PathVariable Long id){
        Optional<Cliente> cliente = repository.findById(id);
        if(cliente.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
