package org.serratec.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class ConsultaRequestDTO {

    @NotBlank
    private LocalDate dataConsulta;
    @NotBlank
    private String nomePaciente;
    @NotBlank
    private List<ProcedimentoRequestDTO> procedimentosDTO;
    @NotNull
    private Double totalGeral;

    public ConsultaRequestDTO() {
    }

    public ConsultaRequestDTO(LocalDate dataConsulta, String nomePaciente, List<ProcedimentoRequestDTO> procedimentosDTO, Double totalGeral) {
        this.dataConsulta = dataConsulta;
        this.nomePaciente = nomePaciente;
        this.procedimentosDTO = procedimentosDTO;
        this.totalGeral = totalGeral;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public List<ProcedimentoRequestDTO> getProcedimentosDTO() {
        return procedimentosDTO;
    }

    public void setProcedimentosDTO(List<ProcedimentoRequestDTO> procedimentosDTO) {
        this.procedimentosDTO = procedimentosDTO;
    }

    public Double getTotalGeral() {
        return totalGeral;
    }

    public void setTotalGeral(Double totalGeral) {
        this.totalGeral = totalGeral;
    }
}
