package org.serratec.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.serratec.backend.enums.NivelHierarquico;

@Entity
public class Diretor extends Funcionario {

	@Enumerated(EnumType.STRING)
	private NivelHierarquico nivelHierarquico;

	public NivelHierarquico getNivelHierarquico() {
		return nivelHierarquico;
	}

	public void setNivelHierarquico(NivelHierarquico nivelHierarquico) {
		this.nivelHierarquico = nivelHierarquico;
	}

}
