
package org.edessco.sva.bl;

import java.util.List;
import org.edessco.sva.be.ModeloCalidad;
import org.edessco.sva.da.ModeloDA;
import org.edessco.sva.util.AbstractBL;
import org.edessco.sva.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("modeloBL")
public class ModeloBL extends AbstractBL<ModeloCalidad>{

    @Autowired
    @Qualifier("modeloDA")
    private ModeloDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }
    
    @Override
    public void setDA(AbstractDA dao) {
        this.dao=(ModeloDA) dao;
    }
    
    @Override
    public long registrar(ModeloCalidad bean) {
        return save(bean);
    }

    @Override
    public long actualizar(ModeloCalidad bean) {
        return update(bean);
    }

    @Override
    public long eliminar(ModeloCalidad bean) {
        return delete(bean);
    }

    @Override
    public List<ModeloCalidad> listar() {
        return list();
    }

    @Override
    public List<ModeloCalidad> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<ModeloCalidad> listar(long id) {
        return list(id);
    }

    @Override
    public ModeloCalidad buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        return maxId();
    }

    @Override
    public ModeloCalidad buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
