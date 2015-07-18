package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.IniciativaMejora;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("iniciativaMejoraDA")
public class IniciativaMejoraDA extends AbstractDA<IniciativaMejora>{
    @Override
    public long registrar(IniciativaMejora bean) {
         return save(bean);
    }

    @Override
    public long actualizar(IniciativaMejora bean) {
        return update(bean);
    }

    @Override
    public long eliminar(IniciativaMejora bean) {
        return delete(bean);
    }

    @Override
    public List<IniciativaMejora> listar() {
        return list(IniciativaMejora.class);
    }

    @Override
    public List<IniciativaMejora> listar(String ref) {
        return list("from RespuestaEncuesta re left join fetch re.preguntaEncuesta");
    }

    @Override
    public List<IniciativaMejora> listar(long id_estandar) {
        return list("FROM IniciativaMejora im "
                    + " inner join fetch im.estandar e"
                    + " where e.idestandar="+id_estandar+"");
    }
    
    @Override
    public IniciativaMejora buscar(long id) {
        return search(IniciativaMejora.class,id);
    }

    @Override
    public long id() {
        return maxId(IniciativaMejora.class);
    }

    @Override
    public IniciativaMejora buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
