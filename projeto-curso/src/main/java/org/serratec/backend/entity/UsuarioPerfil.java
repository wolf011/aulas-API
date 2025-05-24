package org.serratec.backend.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.serratec.backend.entity.PK.UsuarioPerfilPK;

import java.time.LocalDate;

@Entity
public class UsuarioPerfil {

    @EmbeddedId
    private UsuarioPerfilPK id =new UsuarioPerfilPK();

    private LocalDate dataCriacao;

    public UsuarioPerfil() {
    }

    public UsuarioPerfil(Usuario usuario, Perfil perfil) {
        id.setUsuario(usuario);
        id.setPerfil(perfil);
        this.dataCriacao = dataCriacao;
    }

    public void setUsuario(Usuario usuario) {
        id.setUsuario(usuario);
    }

    public Usuario getUsuario() {
        return id.getUsuario();
    }

    public void setPerfil(Perfil perfil) {
        id.setPerfil(perfil);
    }

    public Perfil getPerfil() {
        return id.getPerfil();
    }

    public UsuarioPerfilPK getId() {
        return id;
    }

    public void setId(UsuarioPerfilPK id) {
        this.id = id;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
