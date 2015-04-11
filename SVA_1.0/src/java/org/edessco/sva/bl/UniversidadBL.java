package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Universidad;
import org.edessco.sva.da.UniversidadDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("universidadBL")
public class UniversidadBL extends AbstractBL<Universidad>{
    
    @Autowired
    @Qualifier("universidadDA")
    private UniversidadDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
            }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(UniversidadDA) dao;
    }

    @Override
    public long registrar(Universidad bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Universidad bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Universidad bean) {
        return delete(bean);
    }

    @Override
    public List<Universidad> listar() {
        return list();
    }

    @Override
    public List<Universidad> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Universidad> listar(long id) {
        return list(id);
    }

    @Override
    public Universidad buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public Universidad buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
