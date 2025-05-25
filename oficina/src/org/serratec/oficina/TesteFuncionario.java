package org.serratec.oficina;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Carlos", "CPD", 2000.);
        Funcionario f2 = new Funcionario("CarlA", "ADM", 3000.);
        Funcionario f3 = new Funcionario("Roberta", "CPD", 8000.);
        Funcionario f4 = new Funcionario("Sergio", "COMPRAS", 5000.);

        List<Funcionario> funcionarios = Arrays.asList(f1, f2, f3, f4);

        boolean resposta = funcionarios.stream().anyMatch(f -> f.getSetor().equals("COMPRAS"));
        System.out.println(resposta);

        System.out.println("##########################################################################################");

        funcionarios.stream().filter(f-> f.getSetor().equals("COMPRAS")).forEach(f-> System.out.println(f));

        System.out.println("##########################################################################################");

        funcionarios.stream().map(f-> f.getNome().substring(0,3)).forEach(f-> System.out.println(f));

        System.out.println("##########################################################################################");

        funcionarios.stream().sorted((f,g)-> f.getSalario().compareTo(g.getSalario())).forEach(h-> System.out.println(h));

        System.out.println("##########################################################################################");

        funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome).reversed()).forEach(h-> System.out.println(h));
    }
}
