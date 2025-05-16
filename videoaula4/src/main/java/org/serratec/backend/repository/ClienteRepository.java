package org.serratec.backend.repository;

import org.serratec.backend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

//@Repository   // Botei só para lembrar que ele identifica como repository de forma automática
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
