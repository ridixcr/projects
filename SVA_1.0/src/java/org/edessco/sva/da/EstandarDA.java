/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.Estandar;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("estandarDA")
public class EstandarDA extends AbstractDA<Estandar> {

    @Override
    public long registrar(Estandar bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Estandar bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Estandar bean) {
        return delete(bean);
    }

    @Override
    public List<Estandar> listar() {
        return list("from Estandar");
    }

    @Override
    public List<Estandar> listar(String ref) {
        return list("from Estandar e left join fetch e.criterio");
    }

    @Override
    public List<Estandar> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Estandar buscar(long id_estandar) {
        return search("from Estandar e"
                    + " where e.idestandar="+id_estandar+"");
    }

    @Override
    public long id() {
        Object o = searchSQL("SELECT max(idautoevaluacion) \n"
                           + " FROM autoevaluacion");
        return o != null ? Long.parseLong(o.toString()) : 0;
    }

    @Override
    public Estandar buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Estandar> listarEstandar(long id) {
        return list("from Estandar e inner join fetch e.criterio c where c.idcriterio=" + id);
    }

    public List respuestaCuestionarioDocente(long id_estandar) {
        //<editor-fold defaultstate="collapsed" desc="CUERPO">  
        return listSQL("SELECT\n"
                + " (SUM(CASE WHEN rc.respuesta='SI' THEN 1 ELSE 0 END)/COUNT(d.iddocente))*100 as porcentaje_si,\n"
                + " (SUM(CASE WHEN rc.respuesta='NO' THEN 1 ELSE 0 END)/COUNT(d.iddocente))*100 as porcentaje_no,\n"
                + " CASE  WHEN  ((SUM(CASE WHEN rc.respuesta='SI' THEN 1 ELSE 0 END)/COUNT(d.iddocente))*100)>= 50 THEN 'SI' ELSE 'NO' END as cumplimiento_segun_porcentaje\n"
                + " FROM estandar e\n"
                + " INNER JOIN pregunta_cuestionario pc\n"
                + " ON e.idestandar = pc.id_estandar\n"
                + " INNER JOIN respuesta_cuestionario rc\n"
                + " ON pc.idpreguntacuestionario = rc.id_preguntacuestionario\n"
                + " INNER JOIN docente d\n"
                + " ON d.iddocente = rc.id_docente\n"
                + " INNER JOIN persona p\n"
                + " ON p.idpersona = d.id_persona\n"
                + " where e.idestandar=" + id_estandar + "\n"
                + " group by e.idestandar");
        //</editor-fold>
    }
}
