package org.serratec.backend.dto;

public record ProcedimentoResponseDTO(String tipoExame, Integer quantidade, Double valorProcedimento, Double subtotal) {
}
