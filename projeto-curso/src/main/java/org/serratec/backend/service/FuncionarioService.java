package org.serratec.backend.service;

import org.serratec.backend.dto.FuncionarioResponsetDTO;
import org.serratec.backend.entity.Funcionario;
import org.serratec.backend.repository.FuncinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncinarioRepository repository;

    public List<FuncionarioResponsetDTO> listar() {
        List<Funcionario> funcionarios = repository.findAll();
        return funcionarios.stream().map(f -> new FuncionarioResponsetDTO(f)).collect(Collectors.toList());
    }

    public Page<FuncionarioResponsetDTO> listarPorPagina(Pageable pageable) {
        Page<Funcionario> funcionarios = repository.findAll(pageable);
         return funcionarios.map(f -> new FuncionarioResponsetDTO(f));
    }

    public Page<FuncionarioResponsetDTO> listarPorPaginaFaixaSalarial(Pageable pageable, Double faixa1, Double faixa2) {
//        Page<Funcionario> funcionarios = repository.faixaSalarial(faixa1, faixa2, pageable);
        Page<Funcionario> funcionarios = repository.findBySalarioBetween(faixa1, faixa2, pageable);
         return funcionarios.map(f -> new FuncionarioResponsetDTO(f));
    }

    public Page<FuncionarioResponsetDTO> listarPorPaginaPorNome(Pageable pageable, String nome) {
//        Page<Funcionario> funcionarios = repository.buscarPorNome(nome, pageable);
        Page<Funcionario> funcionarios = repository.findByNomeContainingIgnoreCase(nome, pageable);
         return funcionarios.map(f -> new FuncionarioResponsetDTO(f));
    }
}
