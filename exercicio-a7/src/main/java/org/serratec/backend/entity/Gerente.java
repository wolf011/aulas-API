package org.serratec.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.serratec.backend.enums.Tipo;

@Entity
public class Gerente extends Funcionario {

	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
