
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;



public class Agendamento implements Serializable{
    private TipoDeServico tipodeservico;
    private Equipe equipe;
    private Date data;
    private String periodo;
    private String contratante;
    private String telefonecontato;
    private String email;
    private String enderecodoservico;
    private Double totalservico;

    public Agendamento() {
    }

    public Agendamento(TipoDeServico tipodeservico, Equipe equipe, Date data, String periodo, String contratante, String telefonecontato, String email, String enderecodoservico, Double totalservico) {
        this.tipodeservico = tipodeservico;
        this.equipe = equipe;
        this.data = data;
        this.periodo = periodo;
        this.contratante = contratante;
        this.telefonecontato = telefonecontato;
        this.email = email;
        this.enderecodoservico = enderecodoservico;
        this.totalservico = totalservico;
    }

    public Agendamento(Agendamento agendamento) {
       this.tipodeservico = agendamento.tipodeservico;
       this.equipe = agendamento.equipe;
       this.data = agendamento.data;
       this.periodo = agendamento.periodo;
       this.contratante = agendamento.contratante;
       this.telefonecontato = agendamento.telefonecontato;
       this.email = agendamento.email;
       this.enderecodoservico = agendamento.enderecodoservico;
       this.totalservico = agendamento.totalservico; //To change body of generated methods, choose Tools | Templates.
    }

   

    

    public TipoDeServico getTipodeservico() {
        return tipodeservico;
    }

    public void setTipodeservico(TipoDeServico tipodeservico) {
        this.tipodeservico = tipodeservico;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getContratante() {
        return contratante;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getTelefonecontato() {
        return telefonecontato;
    }

    public void setTelefonecontato(String telefonecontato) {
        this.telefonecontato = telefonecontato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnderecodoservico() {
        return enderecodoservico;
    }

    public void setEnderecodoservico(String enderecodoservico) {
        this.enderecodoservico = enderecodoservico;
    }

    public Double getTotalservico() {
        return totalservico;
    }

    public void setTotalservico(Double totalservico) {
        this.totalservico = totalservico;
    }



    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.periodo);
        hash = 61 * hash + Objects.hashCode(this.equipe);
        hash = 61 * hash + Objects.hashCode(this.data);
        
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
        final Agendamento other = (Agendamento) obj;
        if (!Objects.equals(this.periodo, other.periodo)) {
            return false;
        }
        if (!Objects.equals(this.equipe, other.equipe)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }


    
  
    

     

    

    
}
