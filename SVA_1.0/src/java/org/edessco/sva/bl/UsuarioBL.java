package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Usuario;
import org.edessco.sva.da.UsuarioDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("usuarioBL")
public class UsuarioBL extends AbstractBL<Usuario>{
    
    @Autowired
    @Qualifier("usuarioDA")
    private UsuarioDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
            }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(UsuarioDA) dao;
    }

    @Override
    public long registrar(Usuario bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Usuario bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Usuario bean) {
        return delete(bean);
    }

    @Override
    public List<Usuario> listar() {
        return list();
    }

    @Override
    public List<Usuario> listar(String ref) {
        return list(ref);
    }
    
    public List<Usuario> listarAll() {
        return dao.listarAll();
    }

    @Override
    public List<Usuario> listar(long id) {
        return list(id);
    }

    @Override
    public Usuario buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public Usuario buscar(String ref) {
        return search(ref);
    }
}
