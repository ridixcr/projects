package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.*;
import org.edessco.sva.da.*;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("iniciativaMejoraBL")
public class IniciativaMejoraBL  extends AbstractBL<IniciativaMejora>{
    
    @Autowired
    @Qualifier("iniciativaMejoraDA")
    private IniciativaMejoraDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(IniciativaMejoraDA) dao;
    }

    @Override
    public long registrar(IniciativaMejora bean) {
        return save(bean);
    }

    @Override
    public long actualizar(IniciativaMejora bean) {
        return update(bean);
    }

    @Override
    public long eliminar(IniciativaMejora bean) {
        return delete(bean);
    }

    @Override
    public List<IniciativaMejora> listar() {
        return list();
    }

    @Override
    public List<IniciativaMejora> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<IniciativaMejora> listar(long id) {
        return list(id);
    }

    @Override
    public IniciativaMejora buscar(long id) {
        return search(id);
    }
    public IniciativaMejora buscar(long id_estandar,long id_autoevaluacion) {
        return dao.buscar(id_estandar, id_autoevaluacion);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public IniciativaMejora buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
