package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.UsuarioRol;
import org.edessco.sva.da.UsuarioRolDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("usuarioRolBL")
public class UsuarioRolBL extends AbstractBL<UsuarioRol>{
    
    @Autowired
    @Qualifier("usuarioRolDA")
    private UsuarioRolDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
            }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(UsuarioRolDA) dao;
    }

    @Override
    public long registrar(UsuarioRol bean) {
        return save(bean);
    }

    @Override
    public long actualizar(UsuarioRol bean) {
        return update(bean);
    }

    @Override
    public long eliminar(UsuarioRol bean) {
        return delete(bean);
    }

    @Override
    public List<UsuarioRol> listar() {
        return list();
    }

    @Override
    public List<UsuarioRol> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<UsuarioRol> listar(long id) {
        return list(id);
    }

    @Override
    public UsuarioRol buscar(long id) {        
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public UsuarioRol buscar(String ref) {
        return search(ref);
    }
}
