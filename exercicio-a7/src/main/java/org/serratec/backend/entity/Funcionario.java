package org.serratec.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import org.serratec.backend.enums.Turno;

@MappedSuperclass

public abstract class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@NotBlank(message = "Nome não pode ser nulo!")
	protected String nome;
	
	@CPF(message = "CPF Inválido!")
	protected String cpf;
	
	@NotNull
	protected Double salario;
	
	
	@Enumerated(EnumType.STRING)
	protected Turno turno;
	
	@ManyToOne
	@JoinColumn(name = "id_setor")
	protected Setor setor;
	
	
		
	public Setor getSetor() {
		return setor;
	}


	public void setSetor(Setor setor) {
		this.setor = setor;
	}


	public String getNome() {
		return nome;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}


	public Turno getTurno() {
		return turno;
	}


	public void setTurno(Turno turno) {
		this.turno = turno;
	}


}
