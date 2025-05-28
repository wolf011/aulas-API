package org.serratec.backend.entity;

import jakarta.persistence.*;

@Entity
public class Procedimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer quantidade;

    private Double valorProcedimento;

    @ManyToOne
    private Consulta consulta;

    @ManyToOne
    private Exame exame;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorProcedimento() {
        return valorProcedimento;
    }

    public void setValorProcedimento(Double valorProcedimento) {
        this.valorProcedimento = valorProcedimento;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    @Override
    public String toString() {
        return "Procedimento: " +
                " id: " + id +
                ", quantidade: " + quantidade +
                ", valorProcedimento: " + valorProcedimento +
                ", consulta: " + consulta +
                ", exame: " + exame;
    }
}
