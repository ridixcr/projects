
package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Administrativo;
import org.edessco.sva.be.Docente;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;
@Repository("administrativoDA")
public class AdministrativoDA extends AbstractDA<Administrativo>{

    @Override
    public long registrar(Administrativo bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Administrativo bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Administrativo bean) {
        return delete(bean);
    }

    @Override
    public List<Administrativo> listar() {
        return list(Administrativo.class);
    }

    @Override
    public List<Administrativo> listar(String ref) {
        return list("from Criterio d left join fetch d.factor");
    }

    @Override
    public List<Administrativo> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Administrativo buscar(long id) {
        return search(Administrativo.class, id);
    }

    @Override
    public Administrativo buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
