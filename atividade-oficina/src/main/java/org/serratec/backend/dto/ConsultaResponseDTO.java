package org.serratec.backend.dto;

import java.time.LocalDate;

public record ConsultaResponseDTO(LocalDate dataConsulta, String nomePaciente, ProcedimentoResponseDTO procedimentosDTO, Double totalGeral) {
}
