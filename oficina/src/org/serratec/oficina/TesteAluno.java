package org.serratec.oficina;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TesteAluno {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Marcos", "marcos@gmail.com");
        Aluno aluno2 = new Aluno("Ana", "ana@gmail.com");

        List<Aluno> alunos = Arrays.asList(aluno1, aluno2);

//        for (Aluno aluno: alunos) {
//            System.out.println(aluno);
//
//        }

        //Mais trabalho
//        ExibirDadosAluno ex = new ExibirDadosAluno();

        //Menos trabalho
//        Consumer<Aluno> ex = new Consumer<Aluno>() {
//            @Override
//            public void accept(Aluno aluno) {
//                System.out.println(aluno.getNome());
//                System.out.println(aluno.getEmail());
//            }
//        };

        //Menos trabalho ainda
//        Consumer<Aluno> ex = aluno -> {
//            System.out.println(aluno.getNome());
//            System.out.println(aluno.getEmail());
//        };

//        alunos.forEach(ex);

        //Method Reference
        alunos.forEach(System.out::println);
    }
}
