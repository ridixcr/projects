
package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.GrupoInteres;
import org.edessco.sva.da.GrupoInteresDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("grupoInteresBL")
public class GrupoInteresBL extends AbstractBL<GrupoInteres>{
    @Autowired
    @Qualifier("grupoInteresDA")
    private GrupoInteresDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(GrupoInteresDA) dao;
    }

    @Override
    public long registrar(GrupoInteres bean) {
        return save(bean);
    }

    @Override
    public long actualizar(GrupoInteres bean) {
        return update(bean);
    }

    @Override
    public long eliminar(GrupoInteres bean) {
        return delete(bean);
    }

    @Override
    public List<GrupoInteres> listar() {
        return list();
    }

    @Override
    public List<GrupoInteres> listar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GrupoInteres> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GrupoInteres buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GrupoInteres buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
