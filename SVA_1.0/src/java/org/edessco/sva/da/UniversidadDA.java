
package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Universidad;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("universidadDA")
public class UniversidadDA extends AbstractDA<Universidad>{

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
        return list(Universidad.class);
    }

    @Override
    public List<Universidad> listar(String ref) {
        return list("from Universidad as u where u.nombre like '%"+ref+"%'");
    }

    @Override
    public List<Universidad> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Universidad buscar(long id) {
        return search(Universidad.class,id);
    }

    @Override
    public long id() {
        return maxId(Universidad.class);
    }

    @Override
    public Universidad buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
