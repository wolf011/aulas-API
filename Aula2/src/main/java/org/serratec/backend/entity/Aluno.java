package org.serratec.backend.entity;

public class Aluno {
    private Long matricula;
    private String nome;
    private String email;

    public Aluno(Long matricula, String nome, String email) {
        super();
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
    }

    public Long getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
