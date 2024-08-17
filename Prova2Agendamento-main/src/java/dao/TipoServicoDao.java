package dao;

import java.io.Serializable;
import model.TipoDeServico;


public class TipoServicoDao extends GenericDAO<TipoDeServico> implements Serializable {
    public TipoDeServico findById( int id ) {
        return findByExample( new TipoDeServico(id, null) );
    }
}
