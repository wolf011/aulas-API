package org.serratec.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.serratec.backend.entity.Usuario;
import org.serratec.backend.entity.UsuarioPerfil;

import java.util.HashSet;
import java.util.Set;

public class UsuarioRequestDTO {

    @NotBlank
    private String nome;
    @Email
    private String email;
    @NotBlank
    private String senha;

    private Set<UsuarioPerfil> usuarioPerfis = new HashSet<>();

    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "CEP inválido")
    private String cep;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public UsuarioRequestDTO(String nome, String email, String senha, Set<UsuarioPerfil> usuarioPerfis, String cep) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.usuarioPerfis = usuarioPerfis;
        this.cep = cep;
    }

    public Set<UsuarioPerfil> getUsuarioPerfis() {
        return usuarioPerfis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
