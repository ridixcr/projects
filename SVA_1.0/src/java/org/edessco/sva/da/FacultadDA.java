
package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Facultad;
import org.edessco.sva.be.Universidad;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("facultadDA")
public class FacultadDA extends AbstractDA<Facultad>{

    @Override
    public long registrar(Facultad bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Facultad bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Facultad bean) {
        return delete(bean);
    }

    @Override
    public List<Facultad> listar() {
        return list(Facultad.class);
    }

    @Override
    public List<Facultad> listar(String ref) {
        return list("from Facultad f left join fetch f.universidad");
    }

    @Override
    public List<Facultad> listar(long id) {
        return list(Facultad.class, Universidad.class, id);
    }
    
    public List<Facultad> listarFacultad(long idUniversidad) {
        return list("from Facultad f inner join fetch f.universidad u where u.iduniversidad="+idUniversidad);
    }

    @Override
    public Facultad buscar(long id) {
        return search(Facultad.class,id);
    }

    @Override
    public long id() {
        return maxId(Facultad.class);
    }

    @Override
    public Facultad buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
