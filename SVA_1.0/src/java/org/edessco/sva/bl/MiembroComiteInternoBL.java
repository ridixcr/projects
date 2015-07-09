
package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.MiembroComiteInterno;
import org.edessco.sva.da.MiembroComiteInternoDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("miembroComiteInternoBL")
public class MiembroComiteInternoBL extends AbstractBL<MiembroComiteInterno>{
    @Autowired
    @Qualifier("miembroComiteInternoDA")
    private MiembroComiteInternoDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(MiembroComiteInternoDA) dao;
    }

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
        return list();
    }

    @Override
    public List<MiembroComiteInterno> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<MiembroComiteInterno> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MiembroComiteInterno buscar(long id) {
        return search(id);
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
