/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Alumno;
import org.edessco.sva.be.Docente;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("docenteDA")
public class DocenteDA extends AbstractDA<Docente> {

    @Override
    public long registrar(Docente bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Docente bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Docente bean) {
        return delete(bean);
    }

    @Override
    public List<Docente> listar() {
        return list("FROM Docente d"
                    + " inner join fetch d.persona p");
    }
    public List<Docente> listarRespuestasCuestionario() {
        return list("FROM Docente d"
                    + " inner join fetch d.persona p");
    }

    @Override
    public List<Docente> listar(String ref) {
        return list("from Criterio d left join fetch d.factor");
    }

    @Override
    public List<Docente> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Docente buscar(long id) {
        return search(Alumno.class, id);
    }

    @Override
    public long id() {
        return maxId(Alumno.class);
    }

    @Override
    public Docente buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Docente buscarXidPersona(long id) {
        return search("from Docente d inner join fetch d.persona p where p.idpersona="+id);
    }
}
