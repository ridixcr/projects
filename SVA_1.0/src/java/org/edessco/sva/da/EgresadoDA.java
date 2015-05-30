
package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Egresado;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;
@Repository("egresadoDA")
public class EgresadoDA extends AbstractDA<Egresado>{
    
    @Override
    public long registrar(Egresado bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Egresado bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Egresado bean) {
        return delete(bean);
    }

    @Override
    public List<Egresado> listar() {
        return list(Egresado.class);
    }

    @Override
    public List<Egresado> listar(String ref) {
        return list("from Criterio d left join fetch d.factor");
    }

    @Override
    public List<Egresado> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Egresado buscar(long id) {
        return search(Egresado.class, id);
    }

    @Override
    public Egresado buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
