package org.serratec.backend.controller;

import org.serratec.backend.dto.FuncionarioResponsetDTO;
import org.serratec.backend.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<FuncionarioResponsetDTO> listar() {
        return service.listar();
    }

    @GetMapping("/pagina")
    public Page<FuncionarioResponsetDTO> listarPorPagina(@PageableDefault(page = 1, size = 10, sort = {"nome", "salario"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return service.listarPorPagina(pageable);
    }

    @GetMapping("/faixa")
    public Page<FuncionarioResponsetDTO> listarPorPaginaFaixaSalarial(@RequestParam(defaultValue = "1000") Double faixa1, @RequestParam(defaultValue = "2000") Double faixa2, Pageable pageable) {
        return service.listarPorPaginaFaixaSalarial(pageable, faixa1, faixa2);
    }

    @GetMapping("/nome")
    public Page<FuncionarioResponsetDTO> listarPorPaginaPorNome(@RequestParam(defaultValue = "") String nome, Pageable pageable) {
        return service.listarPorPaginaPorNome(pageable, nome);
    }
}
