package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Persona;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;
@Repository("personaDA")
public class PersonaDA extends AbstractDA<Persona> {

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
        return list(Persona.class);
    }

    @Override
    public List<Persona> listar(String ref) {
        return list("from Persona f left join fetch f.universidad");
    }

    @Override
    public List<Persona> listar(long id) {
        return list(Persona.class, Persona.class, id);
    }

    @Override
    public Persona buscar(long id) {
        return search(Persona.class, id);
    }

    @Override
    public long id() {
        return Long.parseLong(searchSQL("SELECT max(idpersona) FROM persona").toString());
    }
    
    public int maxId(){
        return 5;
    }

    @Override
    public Persona buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
