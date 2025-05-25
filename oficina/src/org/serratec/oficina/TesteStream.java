package org.serratec.oficina;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TesteStream {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Marcos", "marcos@gmail.com", 70);
        Aluno aluno2 = new Aluno("Ana", "ana@gmail.com", 15);
        Aluno aluno3 = new Aluno("Maria", "maria@gmail.com", 15);
        Aluno aluno4 = new Aluno("Adriano", "adriano@gmail.com", 15);

        List<Aluno> alunos = Arrays.asList(aluno1, aluno2, aluno3, aluno4);

        alunos.stream().filter(a -> a.getIdade() > 20).forEach(a -> System.out.println(a));

        List<Aluno> alunosFilter = alunos.stream().filter(a->a.getNome().startsWith("A")).collect(Collectors.toList());
        System.out.println(alunosFilter);

    }
}
