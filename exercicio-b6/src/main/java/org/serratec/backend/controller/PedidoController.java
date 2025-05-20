package org.serratec.backend.controller;


import jakarta.validation.Valid;
import org.serratec.backend.entity.Pedido;
import org.serratec.backend.reporsitory.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido inserir(@Valid @RequestBody Pedido pedido) {

        return repository.save(pedido);
    }

    @PostMapping("/inseirVarios")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Pedido> inserirVarios(@Valid @RequestBody List<Pedido> pedidos) {
        return repository.saveAll(pedidos);
    }

    @GetMapping
    public List<Pedido> listar() {

        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Pedido> listarPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = repository.findById(id);
        if (pedido.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedido.get());
    }

    @PutMapping("{id}")
    public ResponseEntity<Pedido> atualizar(@PathVariable Long id,@Valid @RequestBody Pedido pedido) {
        if (repository.findById(id).isPresent()) {
            pedido.setId(id);
            return ResponseEntity.ok(repository.save(pedido));
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
