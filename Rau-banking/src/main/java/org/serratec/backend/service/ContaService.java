package org.serratec.backend.service;

import org.serratec.backend.entity.Conta;
import org.serratec.backend.exception.ContaException;
import org.serratec.backend.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    //confere se o id existe ou não
    public Boolean buscarPorId(Long id){
        Optional<Conta> c = repository.findById(id);
        if(!c.isPresent()){
            return false;
        }
        return true;
    }

    //retorna o saldo da conta
    public BigDecimal saldoPorId(Long id){
        Optional<Conta> c = repository.findById(id);
        return c.get().getSaldo();
    }

    //Debita o valor
    public void debitar(Long id, BigDecimal valor) {
        Optional<Conta> c = repository.findById(id);
        c.get().setSaldo(c.get().getSaldo().subtract(valor));
    }

    //Soma o valor
    public void soma(Long id, BigDecimal valor) {
        Optional<Conta> c = repository.findById(id);
        c.get().setSaldo(c.get().getSaldo().add(valor));
    }


    public Conta inserir (Conta conta) {
        Optional<Conta> con = repository.findByCpf(conta.getCpf());

        if (con.isPresent()) {
            throw new ContaException("Cpf já cadastrado");
        }
        return repository.save(conta);
    }

   public List<Conta> listar() {
        return repository.findByAtivoTrue();
   }

    //Lista por id
    public Conta listarPorId( Long id) {
        if (buscarPorId(id)) {
            Optional<Conta> cont = repository.findById(id);
            return cont.get();
        }
        throw new ContaException("Usuário não existe!");
    }

    //Substituir
    public Conta atualizar(Long id, Conta contaNova) {
        if (repository.findById(id).isPresent() && repository.findById(id).get().getAtivo()==true) {
            contaNova.setId(id);
            return repository.save(contaNova);
        }
        throw new ContaException("Usuário não existe!");
    }


    //Deleta por id
    public Conta deletaPorId(Long id) {
        if (buscarPorId(id) && repository.findById(id).get().getAtivo() == true) {
            Optional<Conta> cont = repository.findById(id);
            Conta conta = cont.get();
            conta.setAtivo(false);
            repository.save(conta);
            return conta;
        }
        throw new ContaException("Usuário não existe!");
    }


}
