/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ertel
 */
public class TipoDeServico implements Serializable {
    private int id;
    private String descricaodoservico;

    public TipoDeServico() {
    }

    public TipoDeServico(int id, String descricaodoservico) {
        this.id = id;
        this.descricaodoservico = descricaodoservico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricaodoservico() {
        return descricaodoservico;
    }

    public void setDescricaodoservico(String descricaodoservico) {
        this.descricaodoservico = descricaodoservico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoDeServico other = (TipoDeServico) obj;
        return this.id == other.id;
    }

     
    
}
