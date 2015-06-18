
package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.ComiteInterno;
import org.edessco.sva.da.ComiteInternoDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("comiteInternoBL")
public class ComiteInternoBL extends AbstractBL<ComiteInterno>{
    @Autowired
    @Qualifier("comiteInternoDA")
    private ComiteInternoDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(ComiteInternoDA) dao;
    }

    @Override
    public long registrar(ComiteInterno bean) {
        return save(bean);
    }

    @Override
    public long actualizar(ComiteInterno bean) {
        return update(bean);
    }

    @Override
    public long eliminar(ComiteInterno bean) {
        return delete(bean);
    }

    @Override
    public List<ComiteInterno> listar() {
        return list();
    }

    @Override
    public List<ComiteInterno> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<ComiteInterno> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ComiteInterno buscar(long id) {
        return search(id);
    }

    @Override
    public ComiteInterno buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
