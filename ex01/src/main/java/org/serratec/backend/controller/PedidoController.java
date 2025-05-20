package org.serratec.backend.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import org.serratec.backend.entity.Pedido;
import org.serratec.backend.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping("/listar")
    public List<Pedido> listar() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id){
        Optional<Pedido> pedido = repository.findById(id);
        if(pedido.isPresent()){
            return ResponseEntity.ok(pedido.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido adicionar(@Valid @RequestBody Pedido pedido){
       pedido.setDatahora(LocalDateTime.now());
        return repository.save(pedido);
    }

    @PostMapping("/adicionarLista")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Pedido> adicionarLista(@RequestBody List<Pedido> pedidos){
        return repository.saveAll(pedidos);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pedido> alterar(@Valid @PathVariable Long id, @RequestBody Pedido pedido){
        if(repository.findById(id).isPresent()){
            pedido.setId(id);
            return ResponseEntity.ok(repository.save(pedido));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Pedido> remover(@Valid @PathVariable Long id){
        Optional<Pedido> pedido = repository.findById(id);
        if(pedido.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
