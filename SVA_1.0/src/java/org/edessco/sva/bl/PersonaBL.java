package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.Persona;
import org.edessco.sva.da.PersonaDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("personaBL")
public class PersonaBL extends AbstractBL<Persona> {

    @Autowired
    @Qualifier("personaDA")
    private PersonaDA dao;

    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (PersonaDA) dao;
    }

    @Override
    public long registrar(Persona bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Persona bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Persona bean) {
        return delete(bean);
    }

    @Override
    public List<Persona> listar() {
        return list();
    }

    @Override
    public List<Persona> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Persona> listar(long id) {
        return list(id);
    }

    @Override
    public Persona buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public Persona buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
