package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.*;
import org.edessco.sva.da.*;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("registroResultadoBL")
public class RegistroResultadoBL   extends AbstractBL<RegistroResultado>{
    @Autowired
    @Qualifier("registroResultadoDA")
    private RegistroResultadoDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(RegistroResultadoDA) dao;
    }

    @Override
    public long registrar(RegistroResultado bean) {
        return save(bean);
    }

    @Override
    public long actualizar(RegistroResultado bean) {
        return update(bean);
    }

    @Override
    public long eliminar(RegistroResultado bean) {
        return delete(bean);
    }

    @Override
    public List<RegistroResultado> listar() {
        return list();
    }

    @Override
    public List<RegistroResultado> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<RegistroResultado> listar(long id) {
        return list(id);
    }

    @Override
    public RegistroResultado buscar(long id) {
        return search(id);
    }
    public RegistroResultado buscar(long id_estandar,long id_autoevaluacion) {
        return dao.buscar(id_estandar, id_autoevaluacion);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public RegistroResultado buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
