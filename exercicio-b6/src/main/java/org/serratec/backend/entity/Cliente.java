package org.serratec.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 8, max=30, message = "Nome inválido")
    private String nome;

    @CPF(message = "CPF inválido")
    @Column(nullable = false)
    private String CPF;

    @Email(message = "Email inválido")
    @Column(nullable = false)
    private String email;

    @JsonManagedReference
    @OneToOne(mappedBy = "cliente")
    private Endereco endereco;

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
