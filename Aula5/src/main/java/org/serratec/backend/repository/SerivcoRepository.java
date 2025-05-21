package org.serratec.backend.repository;

import org.serratec.backend.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerivcoRepository extends JpaRepository<Servico, Long> {
}
