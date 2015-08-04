package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.*;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("matrizRecoleccionDatosDA")
public class MatrizRecoleccionDatosDA extends AbstractDA<MatrizRecoleccionDatos>{

    @Override
    public long registrar(MatrizRecoleccionDatos bean) {
         return save(bean);
    }

    @Override
    public long actualizar(MatrizRecoleccionDatos bean) {
        return update(bean);
    }

    @Override
    public long eliminar(MatrizRecoleccionDatos bean) {
        return delete(bean);
    }

    @Override
    public List<MatrizRecoleccionDatos> listar() {
        return list("from Estandar");
    }

    @Override
    public List<MatrizRecoleccionDatos> listar(String ref) {
        return list("from Estandar e left join fetch e.criterio");
    }

    @Override
    public List<MatrizRecoleccionDatos> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public MatrizRecoleccionDatos buscar(long id_estandar) {
        return search("FROM MatrizRecoleccionDatos mrd "
                    + " inner join fetch mrd.estandar e"
                    + " where e.idestandar="+id_estandar+"");
    }

    @Override
    public long id() {
        return maxId(MatrizRecoleccionDatos.class);
    }

    @Override
    public MatrizRecoleccionDatos buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<MatrizRecoleccionDatos> listarEstandar(long id) {
        return list("from Estandar e inner join fetch e.criterio c where c.idcriterio=" + id);
    }
    public List respuestaCuestionarioDocente(long id_estandar) {
        //<editor-fold defaultstate="collapsed" desc="CUERPO">  
        return listSQL("SELECT\n" +
                    " (SUM(CASE WHEN rc.respuesta='SI' THEN 1 ELSE 0 END)/COUNT(d.iddocente))*100 as porcentaje_si,\n" +
                    " (SUM(CASE WHEN rc.respuesta='NO' THEN 1 ELSE 0 END)/COUNT(d.iddocente))*100 as porcentaje_no,\n" +
                    " CASE  WHEN  ((SUM(CASE WHEN rc.respuesta='SI' THEN 1 ELSE 0 END)/COUNT(d.iddocente))*100)>= 50 THEN 'SI' ELSE 'NO' END as cumplimiento_segun_porcentaje\n" +
                    " FROM estandar e\n" +
                    " INNER JOIN pregunta_cuestionario pc\n" +
                    " ON e.idestandar = pc.id_estandar\n" +
                    " INNER JOIN respuesta_cuestionario rc\n" +
                    " ON pc.idpreguntacuestionario = rc.id_preguntacuestionario\n" +
                    " INNER JOIN docente d\n" +
                    " ON d.iddocente = rc.id_docente\n" +
                    " INNER JOIN persona p\n" +
                    " ON p.idpersona = d.id_persona\n" +
                    " where e.idestandar="+id_estandar+"\n" +
                    " group by e.idestandar");
        //</editor-fold>
    }
    
}
