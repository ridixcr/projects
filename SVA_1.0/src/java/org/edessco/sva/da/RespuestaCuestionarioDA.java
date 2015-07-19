/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.RespuestaCuestionario;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("respuestaCuestionarioDA")
public class RespuestaCuestionarioDA extends AbstractDA<RespuestaCuestionario>{
    @Override
    public long registrar(RespuestaCuestionario bean) {
         return save(bean);
    }

    @Override
    public long actualizar(RespuestaCuestionario bean) {
        return update(bean);
    }

    @Override
    public long eliminar(RespuestaCuestionario bean) {
        return delete(bean);
    }

    @Override
    public List<RespuestaCuestionario> listar() {
        return list(RespuestaCuestionario.class);
    }

    @Override
    public List<RespuestaCuestionario> listar(String ref) {
        return list("from RespuestaEncuesta re left join fetch re.preguntaEncuesta");
    }

    @Override
    public List<RespuestaCuestionario> listar(long id_estandar) {
        return list("FROM RespuestaCuestionario rc "
                    + " inner join fetch rc.preguntaCuestionario pc"
                    + " inner join fetch pc.estandar e"
                    + " where e.idestandar="+id_estandar+"");
    }
    
    public List<RespuestaCuestionario> reporteCuestionarioDocente() {
        return list("FROM RespuestaCuestionario rc "
                    + " inner join fetch rc.preguntaCuestionario pc"
                    + " inner join fetch rc.docente d"
                    + " inner join fetch d.persona p");
    }
    public List<RespuestaCuestionario> reporteCuestionarioDocente(long id_docente) {
        return list("FROM RespuestaCuestionario rc "
                    + " inner join fetch rc.preguntaCuestionario pc"
                    + " inner join fetch rc.docente d"
                    + " inner join fetch d.persona p"
                    + " where d.iddocente="+id_docente+"");
    }

    @Override
    public RespuestaCuestionario buscar(long id) {
        return search(RespuestaCuestionario.class,id);
    }

    @Override
    public long id() {
        return maxId(RespuestaCuestionario.class);
    }

    @Override
    public RespuestaCuestionario buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
