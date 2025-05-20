package org.serratec.backend.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {
    private Integer status;
    private String titulo;
    private LocalDateTime dataHora;
    private List<String> erros;

    public ErroResposta(Integer status, String titulo, LocalDateTime dataHora, List<String> erros) {
        this.status = status;
        this.titulo = titulo;
        this.dataHora = dataHora;
        this.erros = erros;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getStatus() {
        return status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public List<String> getErros() {
        return erros;
    }
}
