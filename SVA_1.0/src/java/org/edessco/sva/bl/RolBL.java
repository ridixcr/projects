package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Rol;
import org.edessco.sva.da.RolDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("rolBL")
public class RolBL extends AbstractBL<Rol>{
    
    @Autowired
    @Qualifier("rolDA")
    private RolDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
            }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(RolDA) dao;
    }

    @Override
    public long registrar(Rol bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Rol bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Rol bean) {
        return delete(bean);
    }

    @Override
    public List<Rol> listar() {
        return list();
    }

    @Override
    public List<Rol> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Rol> listar(long id) {
        return list(id);
    }

    @Override
    public Rol buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public Rol buscar(String ref) {
        return search(ref);
    }
    
    public long buscarRol(String rol){
        return dao.buscarRol(rol);
    }
}
