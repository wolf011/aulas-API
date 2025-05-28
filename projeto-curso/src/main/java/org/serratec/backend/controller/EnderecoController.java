package org.serratec.backend.controller;

import org.serratec.backend.dto.EnderecoResponseDTO;
import org.serratec.backend.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping("{cep}")
    public ResponseEntity<EnderecoResponseDTO> buscarCep(@PathVariable String cep) {
        var endereco = service.buscar(cep);
        if (endereco != null) {
            return ResponseEntity.ok(endereco);
        }
//        Erro: não achado
        return ResponseEntity.notFound().build();
    }

}
