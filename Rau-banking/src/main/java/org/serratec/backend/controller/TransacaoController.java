package org.serratec.backend.controller;

import org.serratec.backend.entity.Transacao;
import org.serratec.backend.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @PostMapping("/inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public Transacao inserir(@RequestBody Transacao transacao) {
        return service.pix(transacao);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<List<Transacao>> listar (@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPorId(id));
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Transacao>> listar () {
        return ResponseEntity.ok(service.list());
    }
}
