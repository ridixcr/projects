
package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.ModeloCalidad;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("modeloDA")
public class ModeloDA extends AbstractDA<ModeloCalidad>{

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
        return list(ModeloCalidad.class);
    }

    @Override
    public List<ModeloCalidad> listar(String ref) {
        return list("from ModeloCalidad as am where am.tituloModelo like '%"+ref+"%'");
    }

    @Override
    public List<ModeloCalidad> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ModeloCalidad buscar(long id) {
        return search(ModeloCalidad.class,id);
    }

    @Override
    public long id() {
        return maxId(ModeloCalidad.class);
    }

    @Override
    public ModeloCalidad buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
