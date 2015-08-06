package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.*;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("registroResultadoDA")
public class RegistroResultadoDA  extends AbstractDA<RegistroResultado>{
    
    @Override
    public long registrar(RegistroResultado bean) {
         return save(bean);
    }

    @Override
    public long actualizar(RegistroResultado bean) {
        return update(bean);
    }

    @Override
    public long eliminar(RegistroResultado bean) {
        return delete(bean);
    }

    @Override
    public List<RegistroResultado> listar() {
        return list("from Estandar");
    }

    @Override
    public List<RegistroResultado> listar(String ref) {
        return list("from Estandar e left join fetch e.criterio");
    }

    @Override
    public List<RegistroResultado> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public RegistroResultado buscar(long id_estandar) {
        return search("FROM RegistroResultado rr "
                    + " inner join fetch rr.estandar e"
                    + " where e.idestandar="+id_estandar+"");
    }
    public RegistroResultado buscar(long id_estandar,long id_autoevaluacion) {
        return search("FROM RegistroResultado rr "
                    + " inner join fetch rr.estandar e"
                    + " inner join fetch rr.autoevaluacion au"
                    + " where e.idestandar="+id_estandar+" and au.idautoevaluacion="+id_autoevaluacion);
    }

    @Override
    public long id() {
        return maxId(RegistroResultado.class);
    }

    @Override
    public RegistroResultado buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
