package org.serratec.oficina;

public class Funcionario {
    private String nome;
    private String setor;
    private Double salario;

    public Funcionario(String nome, String setor, Double salario) {
        this.nome = nome;
        this.setor = setor;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", setor='" + setor + '\'' +
                ", salario=" + salario +
                '}';
    }
}
