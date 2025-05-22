package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Conta;
import org.serratec.backend.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService service;

    @PostMapping("/inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public Conta inserir(@RequestBody Conta conta) {
        return service.inserir(conta);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Conta>> listar () {
        return ResponseEntity.ok(service.listar());
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<Conta> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(listarPorId(id).getBody());
    }

    @PutMapping("/substituir/{id}")
    public ResponseEntity<Conta> atualizar(@PathVariable Long id,@Valid @RequestBody Conta conta) {
        return ResponseEntity.ok(service.atualizar(id, conta));
    }


    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Conta> remover(@PathVariable Long id) {
        service.deletaPorId(id);
        return ResponseEntity.noContent().build();
    }

}
