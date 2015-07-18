package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.RegistroGradoCumplimiento;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("registroGradoCumplimientoDA")
public class RegistroGradoCumplimientoDA extends AbstractDA<RegistroGradoCumplimiento>{
    @Override
    public long registrar(RegistroGradoCumplimiento bean) {
         return save(bean);
    }

    @Override
    public long actualizar(RegistroGradoCumplimiento bean) {
        return update(bean);
    }

    @Override
    public long eliminar(RegistroGradoCumplimiento bean) {
        return delete(bean);
    }

    @Override
    public List<RegistroGradoCumplimiento> listar() {
        return list(RegistroGradoCumplimiento.class);
    }

    @Override
    public List<RegistroGradoCumplimiento> listar(String ref) {
        return list("from RespuestaEncuesta re left join fetch re.preguntaEncuesta");
    }

    @Override
    public List<RegistroGradoCumplimiento> listar(long id_estandar) {
        return list("FROM RegistroGradoCumplimiento rgc "
                    + " inner join fetch rgc.estandar e"
                    + " where e.idestandar="+id_estandar+"");
    }

    @Override
    public List listarSQL() {
        //<editor-fold defaultstate="collapsed" desc="CUERPO">
        return listSQL("SELECT\n" +
                    " es.numero_estandar,\n" +
                    " es.titulo,\n" +
                    " CASE  WHEN rgc.cumplimiento=1 THEN 'SI'  ELSE 'NO' END as cumplimiento,\n" +
                    " (SUM(CASE WHEN rc.respuesta='SI' THEN 1 ELSE 0 END)/COUNT(dc.iddocente))*100 as porcentaje_si,\n" +
                    " (SUM(CASE WHEN rc.respuesta='NO' THEN 1 ELSE 0 END)/COUNT(dc.iddocente))*100 as porcentaje_no,\n" +
                    " CASE  WHEN  ((SUM(CASE WHEN rc.respuesta='SI' THEN 1 ELSE 0 END)/COUNT(dc.iddocente))*100)>= 50 THEN 'SI' ELSE 'NO' END as cumplimiento_segun_porcentaje,\n" +
                    " rgc.explicacion_consolidada,\n" +
                    " im.alternativa_solucion_consensuada\n" +
                    " FROM estandar es\n" +
                    " inner join  pregunta_cuestionario pc\n" +
                    " on pc.id_estandar=es.idestandar\n" +
                    " inner join  respuesta_cuestionario rc\n" +
                    " on rc.id_preguntacuestionario=pc.idpreguntacuestionario\n" +
                    " inner join  docente dc\n" +
                    " on rc.id_docente=dc.iddocente\n" +
                    " inner join registro_grado_cumplimiento rgc\n" +
                    " on rgc.id_estandar=es.idestandar\n" +
                    " inner join  iniciativa_mejora im\n" +
                    " on im.id_estandar=es.idestandar\n" +
                    " group by es.idestandar");
        //</editor-fold>
    }
    public List reporteProcesadoEstandar() {
        //<editor-fold defaultstate="collapsed" desc="CUERPO">  
        return listSQL("SELECT\n" +
                    " pe.idpreguntaencuesta, pe.pregunta,\n" +
                    " CASE  WHEN rgc.cumplimiento=1 THEN 'SI'  ELSE 'NO' END as cumplimiento,\n" +
                    " rgc.explicacion_consolidada,\n" +
                    " im.alternativa_solucion_consensuada\n" +
                    " FROM estandar e\n" +
                    " INNER JOIN pregunta_encuesta pe\n" +
                    " ON e.idestandar = pe.id_encuesta\n" +
                    " INNER JOIN iniciativa_mejora im\n" +
                    " ON e.idestandar = im.id_estandar\n" +
                    " INNER JOIN registro_grado_cumplimiento rgc\n" +
                    " ON e.idestandar = rgc.id_estandar");
        //</editor-fold>
    }
    public List reporteProcesadoConsolidadoEstandar() {
        //<editor-fold defaultstate="collapsed" desc="CUERPO"> 
        return listSQL("SELECT\n" +
                    " es.numero_estandar,\n" +
                    " es.titulo,\n" +
                    " CASE  WHEN rgc.cumplimiento=1 THEN 'SI'  ELSE 'NO' END as cumplimiento,\n" +
                    " (SUM(CASE WHEN rc.respuesta='SI' THEN 1 ELSE 0 END)/COUNT(dc.iddocente))*100 as porcentaje_si,\n" +
                    " (SUM(CASE WHEN rc.respuesta='NO' THEN 1 ELSE 0 END)/COUNT(dc.iddocente))*100 as porcentaje_no,\n" +
                    " CASE  WHEN  ((SUM(CASE WHEN rc.respuesta='SI' THEN 1 ELSE 0 END)/COUNT(dc.iddocente))*100)>= 50 THEN 'SI' ELSE 'NO' END as cumplimiento_segun_porcentaje,\n" +
                    " rgc.explicacion_consolidada,\n" +
                    " im.alternativa_solucion_consensuada\n" +
                    " FROM estandar es\n" +
                    " inner join  pregunta_cuestionario pc\n" +
                    " on pc.id_estandar=es.idestandar\n" +
                    " inner join  respuesta_cuestionario rc\n" +
                    " on rc.id_preguntacuestionario=pc.idpreguntacuestionario\n" +
                    " inner join  docente dc\n" +
                    " on rc.id_docente=dc.iddocente\n" +
                    " inner join registro_grado_cumplimiento rgc\n" +
                    " on rgc.id_estandar=es.idestandar\n" +
                    " inner join  iniciativa_mejora im\n" +
                    " on im.id_estandar=es.idestandar\n" +
                    " group by es.idestandar");
        //</editor-fold>
    }
    
    @Override
    public RegistroGradoCumplimiento buscar(long id) {
        return search(RegistroGradoCumplimiento.class,id);
    }

    @Override
    public long id() {
        return maxId(RegistroGradoCumplimiento.class);
    }

    @Override
    public RegistroGradoCumplimiento buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
