package org.serratec.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 7, min = 7, message = "Placa inválida")
    private String placa;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @Embedded
    private Caracateristica caracateristica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Caracateristica getCaracateristica() {
        return caracateristica;
    }

    public void setCaracateristica(Caracateristica caracateristica) {
        this.caracateristica = caracateristica;
    }
}
