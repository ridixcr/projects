
package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.MiembroComiteInterno;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("miembroComiteInternoDA")
public class MiembroComiteInternoDA extends  AbstractDA<MiembroComiteInterno>{
    @Override
    public long registrar(MiembroComiteInterno bean) {
        return save(bean);
    }

    @Override
    public long actualizar(MiembroComiteInterno bean) {
        return update(bean);
    }

    @Override
    public long eliminar(MiembroComiteInterno bean) {
        return delete(bean);
    }

    @Override
    public List<MiembroComiteInterno> listar() {
        return list(MiembroComiteInterno.class);
    }

    @Override
    public List<MiembroComiteInterno> listar(String ref) {
        return list("from Criterio d left join fetch d.factor");
    }

    @Override
    public List<MiembroComiteInterno> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MiembroComiteInterno buscar(long id) {
        return search(MiembroComiteInterno.class, id);
    }

    @Override
    public MiembroComiteInterno buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
