package org.serratec.backend.service;

import jakarta.transaction.Transactional;
import org.hibernate.TransactionException;
import org.serratec.backend.entity.Transacao;
import org.serratec.backend.exception.ContaException;
import org.serratec.backend.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private ContaService cs;

    @Autowired
    private TransacaoRepository repository;

    @Transactional
    public Transacao pix(Transacao transacao) {
        if (cs.buscarPorId(transacao.getContaOrigem().getId()) && cs.buscarPorId(transacao.getContaDestino().getId())) {
            if (transacao.getValor().compareTo(cs.saldoPorId(transacao.getContaOrigem().getId())) > 0) {
                throw new TransactionException("Saldo insuficiente");
            }
            cs.debitar(transacao.getContaOrigem().getId(), transacao.getValor());
            cs.soma(transacao.getContaDestino().getId(), transacao.getValor());
            return repository.save(transacao);
        }
        throw new ContaException("Conta não existente");
    }

    // Lista todos
    public List<Transacao> list() {
        return repository.findAll();
    }

    //  Lista por ID
    public List<Transacao> listarPorId(Long id) {
        if (cs.buscarPorId(id)) {
            List<Transacao> origem = repository.findByContaOrigemId(id);
            List<Transacao> destino = repository.findByContaDestinoId(id);

            List<Transacao> transacoes = new ArrayList<>();
            if (origem.isEmpty() && destino.isEmpty()) {
                throw new ContaException("Conta não possui transações cadastradas");
            } else {
                transacoes.addAll(origem);
                transacoes.addAll(destino);
            }

            return transacoes;

        }
        throw new ContaException("Conta não existente");
    }

}
