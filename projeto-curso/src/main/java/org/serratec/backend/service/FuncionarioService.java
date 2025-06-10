package org.serratec.backend.service;

import jakarta.transaction.Transactional;
import org.serratec.backend.dto.FuncionarioFotoDTO;
import org.serratec.backend.dto.FuncionarioResponsetDTO;
import org.serratec.backend.entity.Funcionario;
import org.serratec.backend.exception.FuncionarioException;
import org.serratec.backend.repository.FuncinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncinarioRepository repository;

    @Autowired
    private FotoService fotoService;

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

    public FuncionarioFotoDTO adicionarImageUri(Funcionario funcionario) {
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/funcionarios/{id}/foto").buildAndExpand(funcionario.getId()).toUri();
        FuncionarioFotoDTO dto = new FuncionarioFotoDTO();
        dto.setUrl(uri.toString());
        return dto;
    }

    public FuncionarioFotoDTO buscar(Long id) {
       Optional<Funcionario> funcionario = repository.findById(id);

       if (funcionario.isEmpty()) {
           throw new FuncionarioException("Funcionario não encontrado");
       }

       return adicionarImageUri(funcionario.get());
    }

    @Transactional
    public FuncionarioFotoDTO inserir(Funcionario funcionario, MultipartFile file) throws IOException {
        funcionario = repository.save(funcionario);
        fotoService.inserir(funcionario, file);
        return adicionarImageUri(funcionario);
    }
}
