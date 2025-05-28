package org.serratec.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProcedimentoRequestDTO {
    @NotBlank
    private String tipoExame;
    @NotNull
    private Integer quantidade;
    @NotNull
    private Double valorProcedimento;
    @NotNull
    private Double subtotal;

    public ProcedimentoRequestDTO() {
    }

    public ProcedimentoRequestDTO(String tipoExame, Integer quantidade, Double valorProcedimento, Double subtotal) {
        this.tipoExame = tipoExame;
        this.quantidade = quantidade;
        this.valorProcedimento = valorProcedimento;
        this.subtotal = subtotal;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
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

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
