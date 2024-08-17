/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.TipoServicoDao;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import model.TipoDeServico;


@Named("TipodeServicoConverter")
@ApplicationScoped
public class TipoServicoConverter implements Converter<TipoDeServico>{

    
    @Inject
    TipoServicoDao dao;
    
    @Override
    public TipoDeServico getAsObject(FacesContext fc, UIComponent uic, String value) {
        try {
            Integer id = Integer.parseInt( value );
            return dao.findById( id );
        } catch (Exception t) {
            return null;
        } 
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, TipoDeServico value) {
        if ( value == null) {
            return null;
        }
        return String.valueOf( value.getId() ); 
    }

   
    
}
