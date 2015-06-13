
package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Egresado;
import org.edessco.sva.da.EgresadoDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("egresadoBL")
public class EgresadoBL extends AbstractBL<Egresado>{
    @Autowired
    @Qualifier("egresadoDA")
    private EgresadoDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(EgresadoDA) dao;
    }

    @Override
    public long registrar(Egresado bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Egresado bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Egresado bean) {
        return delete(bean);
    }

    @Override
    public List<Egresado> listar() {
        return list();
    }

    @Override
    public List<Egresado> listar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Egresado> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Egresado buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Egresado buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
