package org.serratec.oficina;

public class Autor {
    private String nome;
    private String telefone;

    public Autor(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public void imprimir () {
        System.out.println("Dados do Autor:");
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
    }
}
