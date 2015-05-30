
package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Administrativo;
import org.edessco.sva.da.AdministrativoDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("administrativoBL")
public class AdministrativoBL extends AbstractBL<Administrativo>{
    @Autowired
    @Qualifier("administrativoDA")
    private AdministrativoDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(AdministrativoDA) dao;
    }

    @Override
    public long registrar(Administrativo bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Administrativo bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Administrativo bean) {
        return delete(bean);
    }

    @Override
    public List<Administrativo> listar() {
        return list();
    }

    @Override
    public List<Administrativo> listar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Administrativo> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Administrativo buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Administrativo buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
