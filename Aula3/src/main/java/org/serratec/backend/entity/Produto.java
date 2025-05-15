package org.serratec.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
//@Table(name = "tbl_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double valor;
    private LocalDate dataCadastro;

//    private transient Integer total; //Não vai ser inserido no banco

//    public Produto(Long id, String descricao, Double valor, LocalDate dataCadastro) {
//        super();
//        this.id = id;
//        this.descricao = descricao;
//        this.valor = valor;
//        this.dataCadastro = dataCadastro;
//    }
//
//    public Produto() {
//
//    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao=" + descricao +
                ", valor=" + valor +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
