/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;
import java.util.List;
import model.Agendamento;

public class AgendamentoDao  extends GenericDAO<Agendamento> implements Serializable{
    
    
    
     public List<Agendamento> listarAgendamentos(){
         List<Agendamento> resp;
         resp = listar();
         return resp;
     }
}