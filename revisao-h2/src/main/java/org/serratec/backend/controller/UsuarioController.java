package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Usuario;
import org.serratec.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario inserir(@Valid @RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @PostMapping("/inseirVarios")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Usuario> inserirVarios(@RequestBody List<Usuario> usuarios) {
        return repository.saveAll(usuarios);
    }

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable UUID id) {
        Optional<Usuario> cliente = repository.findById(id);
        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente.get());
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable UUID id, @RequestBody Usuario usuario) {
        if (repository.findById(id).isPresent()) {
            usuario.setId(id);
            return ResponseEntity.ok(repository.save(usuario));
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
