package org.serratec.backend.repository;

import org.serratec.backend.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
        Optional<Consulta> findByNomePaciente(String nome);
    Optional<Consulta> findByDataConsulta(LocalDate data);
}
