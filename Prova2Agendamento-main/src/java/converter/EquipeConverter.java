/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;
import dao.EquipeDao;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import model.Equipe;
/**
 *
 * @author ertel
 */
@Named("EquipeConverter")
@ApplicationScoped
public class EquipeConverter implements Converter<Equipe>{
    
    @Inject
    EquipeDao dao;

    @Override
    public Equipe getAsObject(FacesContext fc, UIComponent uic, String value) {
        try {
            Integer id = Integer.parseInt( value );
            return dao.findById( id );
        } catch (Exception t) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Equipe value) {
        if ( value == null) {
            return null;
        }
        return String.valueOf( value.getId() );  //To change body of generated methods, choose Tools | Templates.
    }

   
   
     
}
