package org.serratec.oficina;

import java.util.function.Consumer;

public class ExibirDadosAluno implements Consumer<Aluno> {
    @Override
    public void accept(Aluno a) {
        System.out.println(a.getNome());
        System.out.println(a.getEmail());
    }
}
