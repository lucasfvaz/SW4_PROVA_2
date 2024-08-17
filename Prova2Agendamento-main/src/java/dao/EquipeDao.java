/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;
import java.util.LinkedList;
import model.Equipe;
import model.TipoDeServico;

/**
 *
 * @author ertel
 */
public class EquipeDao extends GenericDAO<Equipe> implements Serializable {
    
    public LinkedList<Equipe> filtarPorTipoDeServico( TipoDeServico tipodeservico ) {
        LinkedList<Equipe> equipes = new LinkedList<>();
        for ( Equipe eq : lista ) {
            if (eq.getTipodeservico().equals(tipodeservico))
                equipes.add(eq);
        }
        return equipes;
    }
    
    public Equipe findById(int id) {
        for (Equipe e : lista) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    
}
