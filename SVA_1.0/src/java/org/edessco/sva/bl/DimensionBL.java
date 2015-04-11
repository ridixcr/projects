package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Dimension;
import org.edessco.sva.da.DimensionDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("dimensionBL")
public class DimensionBL extends AbstractBL<Dimension>{

    @Autowired
    @Qualifier("dimensionDA")
    private DimensionDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(DimensionDA) dao;
    }

    @Override
    public long registrar(Dimension bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Dimension bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Dimension bean) {
        return delete(bean);
    }

    @Override
    public List<Dimension> listar() {
        return list();
    }

    @Override
    public List<Dimension> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Dimension> listar(long id) {
        return list(id);
    }

    @Override
    public Dimension buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public Dimension buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
