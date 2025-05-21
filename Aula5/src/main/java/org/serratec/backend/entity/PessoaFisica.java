package org.serratec.backend.entity;

import jakarta.persistence.Entity;

@Entity
public class PessoaFisica extends Fornecedor{

    private String cpf;
    private String rg;
    private String prgapExpedidor;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getPrgapExpedidor() {
        return prgapExpedidor;
    }

    public void setPrgapExpedidor(String prgapExpedidor) {
        this.prgapExpedidor = prgapExpedidor;
    }
}
