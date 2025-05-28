package org.serratec.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.serratec.backend.dto.ConsultaRequestDTO;
import org.serratec.backend.dto.ConsultaResponseDTO;
import org.serratec.backend.dto.ProcedimentoRequestDTO;
import org.serratec.backend.entity.Consulta;
import org.serratec.backend.entity.Medico;
import org.serratec.backend.entity.Paciente;
import org.serratec.backend.entity.Procedimento;
import org.serratec.backend.exception.ConsultaException;
import org.serratec.backend.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public ConsultaResponseDTO inserir (ConsultaRequestDTO consultaRequestDTO) {
        Optional<Consulta> con1 = repository.findByNomePaciente(consultaRequestDTO.getNomePaciente());
        Optional<Consulta> con2 = repository.findByDataConsulta(consultaRequestDTO.getDataConsulta());

        if (con1.isEmpty() & con2.isEmpty()) {
            throw new ConsultaException("Essa consulta já foi cadastrada");
        }

        Paciente paciente = entityManager.find(Paciente.class, consultaRequestDTO.getNomePaciente());
        Medico medico = entityManager.find(Medico.class, consultaRequestDTO.get);

        List<Procedimento> procedimentos= new ArrayList<>();
        for (ProcedimentoRequestDTO p: consultaRequestDTO.getProcedimentosDTO()){
            Procedimento procedimento = new Procedimento();
            procedimento.setExame(p.);

        }

        Consulta consultaEntity =new Consulta();
        consultaEntity.setDataConsulta(consultaRequestDTO.getDataConsulta());
        consultaEntity.setPaciente(paciente);
        consultaEntity.setMedico();
        consultaEntity.setProcedimentos(procedimentos);

        return;
    };

    public Consulta buscarPorId() {

    };

    public List<Consulta> listar() {

    };
}
