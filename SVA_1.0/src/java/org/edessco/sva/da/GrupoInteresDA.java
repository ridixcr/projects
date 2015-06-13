
package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.GrupoInteres;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;
@Repository("grupoInteresDA")
public class GrupoInteresDA extends AbstractDA<GrupoInteres>{
    
    @Override
    public long registrar(GrupoInteres bean) {
        return save(bean);
    }

    @Override
    public long actualizar(GrupoInteres bean) {
        return update(bean);
    }

    @Override
    public long eliminar(GrupoInteres bean) {
        return delete(bean);
    }

    @Override
    public List<GrupoInteres> listar() {
        return list(GrupoInteres.class);
    }

    @Override
    public List<GrupoInteres> listar(String ref) {
        return list("from Criterio d left join fetch d.factor");
    }

    @Override
    public List<GrupoInteres> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GrupoInteres buscar(long id) {
        return search(GrupoInteres.class, id);
    }

    @Override
    public GrupoInteres buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
