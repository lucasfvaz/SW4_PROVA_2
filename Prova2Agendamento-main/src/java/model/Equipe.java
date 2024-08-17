/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;


public class Equipe implements Serializable {
    private int id;
    private String nomedaequipe;
    private String responsavel;
    private Double valorservicoperiodo;
    private TipoDeServico tipodeservico;

    public Equipe() {
    }

    public Equipe(int id, String nomedaequipe, String responsavel, Double valorservicoperiodo, TipoDeServico tipodeservico) {
        this.id = id;
        this.nomedaequipe = nomedaequipe;
        this.responsavel = responsavel;
        this.valorservicoperiodo = valorservicoperiodo;
        this.tipodeservico = tipodeservico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomedaequipe() {
        return nomedaequipe;
    }

    public void setNomedaequipe(String nomedaequipe) {
        this.nomedaequipe = nomedaequipe;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Double getValorservicoperiodo() {
        return valorservicoperiodo;
    }

    public void setValorservicoperiodo(Double valorservicoperiodo) {
        this.valorservicoperiodo = valorservicoperiodo;
    }

    public TipoDeServico getTipodeservico() {
        return tipodeservico;
    }

    public void setTipodeservico(TipoDeServico tipodeservico) {
        this.tipodeservico = tipodeservico;
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
        final Equipe other = (Equipe) obj;
        return this.id == other.id;
    }
 

}
