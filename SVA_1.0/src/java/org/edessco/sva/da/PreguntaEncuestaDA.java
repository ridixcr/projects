/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edessco.sva.da;

import java.util.List;
import org.edessco.sva.be.PreguntaEncuesta;
import org.edessco.sva.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLuis
 */
@Repository("preguntaEncuestaDA")
public class PreguntaEncuestaDA extends AbstractDA<PreguntaEncuesta>{
    
    @Override
    public long registrar(PreguntaEncuesta bean) {
         return save(bean);
    }

    @Override
    public long actualizar(PreguntaEncuesta bean) {
        return update(bean);
    }

    @Override
    public long eliminar(PreguntaEncuesta bean) {
        return delete(bean);
    }

    @Override
    public List<PreguntaEncuesta> listar() {
        return list(PreguntaEncuesta.class);
    }
    public List<PreguntaEncuesta> listarEstandaresEncuesta() {
        return list("from PreguntaEncuesta pe"
                + " inner join fetch pe.estandar e");
    }
    
    public List reporteTotalEncuestasEstandar(long id_estandar) {
        //<editor-fold defaultstate="collapsed" desc="CUERPO">  
        return listSQL("select\n" +
                    " es.numero_estandar,\n" +
                    " es.titulo as estandar,\n" +
                    " en.descripcion as encuenta,\n" +
                    " pe.tipo_encuesta,\n" +
                    " count(re.idrespuestaencuesta) as cantidad,\n" +
                    " ((sum(CASE\n" +
                    "     WHEN re.estado=1 THEN 1\n" +
                    "     ELSE 0\n" +
                    " END)/count(re.idrespuestaencuesta))*100) as porcentaje_completados,\n" +
                    " sum(CASE\n" +
                    "     WHEN re.estado=1 THEN 1\n" +
                    "     ELSE 0\n" +
                    " END) as completos,\n" +
                    " ((sum(CASE\n" +
                    "     WHEN re.estado=0 THEN 1\n" +
                    "     ELSE 0\n" +
                    " END)/count(re.idrespuestaencuesta))*100) as porcentaje_pendientes,\n" +
                    " sum(CASE\n" +
                    "     WHEN re.estado=0 THEN 1\n" +
                    "     ELSE 0\n" +
                    " END) as pendientes\n" +
                    " FROM estandar es\n" +
                    " inner join  pregunta_encuesta pe\n" +
                    " on pe.id_estandar=es.idestandar\n" +
                    " inner join encuesta en\n" +
                    " on pe.id_encuesta=en.idencuesta\n" +
                    " inner join   respuesta_encuesta re\n" +
                    " on re.id_preguntaencuesta=pe.idpreguntaencuesta\n" +
                    " where es.idestandar="+ id_estandar +"\n"+
                    " group by es.titulo,en.descripcion,pe.tipo_encuesta");
        //</editor-fold>
    }
    public List reporteEstadisticoEncuestaEstudiantesTabla(long id_estandar) {
        //<editor-fold defaultstate="collapsed" desc="CUERPO">  
        return listSQL("select\n" +
                    " es.numero_estandar,\n" +
                    " en.titulo_encuesta,\n" +                    
                    " es.titulo as estandar,\n" +
                    " sum(CASE WHEN re.respuesta='TA' THEN 1 ELSE 0 END) as c_ta,\n" +
                    " sum(CASE WHEN re.respuesta='DA' THEN 1 ELSE 0 END) as c_da,\n" +
                    " sum(CASE WHEN re.respuesta='PA' THEN 1 ELSE 0 END) as c_pa,\n" +
                    " sum(CASE WHEN re.respuesta='DE' THEN 1 ELSE 0 END) as c_de,\n" +
                    " sum(CASE WHEN re.respuesta='NC' THEN 1 ELSE 0 END) as c_nc,\n" +
                    " (sum(CASE WHEN re.respuesta='TA' THEN 1 ELSE 0 END)/count(re.idrespuestaencuesta))*100  as p_ta,\n" +
                    " (sum(CASE WHEN re.respuesta='DA' THEN 1 ELSE 0 END)/count(re.idrespuestaencuesta))*100  as p_da,\n" +
                    " (sum(CASE WHEN re.respuesta='PA' THEN 1 ELSE 0 END)/count(re.idrespuestaencuesta))*100  as p_pa,\n" +
                    " (sum(CASE WHEN re.respuesta='DE' THEN 1 ELSE 0 END)/count(re.idrespuestaencuesta))*100  as p_de,\n" +
                    " (sum(CASE WHEN re.respuesta='NC' THEN 1 ELSE 0 END)/count(re.idrespuestaencuesta))*100  as p_nc\n" +
                    " from pregunta_encuesta pe\n" +
                    " inner join estandar es\n" +
                    " on pe.id_estandar = es.idestandar\n" +
                    " inner join encuesta en\n" +
                    " on pe.id_encuesta = en.idencuesta\n" +
                    " inner join respuesta_encuesta re\n" +
                    " on re.id_preguntaencuesta = pe.idpreguntaencuesta\n" +
                    " inner join usuario u\n" +
                    " on u.idusuario = re.id_usuario\n" +
                    " inner join persona p\n" +
                    " on u.id_persona=p.idpersona\n" +
                    " where pe.tipo_encuesta='ALUMNO' and es.idestandar="+id_estandar+"\n" +
                    " group by es.idestandar");
        //</editor-fold>
    }
    public List reporteEstadisticoEncuestaEstudiantesChart(long id_estandar) {
        //<editor-fold defaultstate="collapsed" desc="CUERPO">  
        return listSQL("select\n" +
                    " 'TOTALMENTE DE ACUERDO (TA)' as respuesta,\n" +
                    " sum(CASE WHEN re.respuesta='TA' THEN 1 ELSE 0 END) as frecuencia,\n" +
                    " (sum(CASE WHEN re.respuesta='TA' THEN 1 ELSE 0 END)/count(re.idrespuestaencuesta))*100  as porcentaje\n" +
                    " from pregunta_encuesta pe\n" +
                    " inner join estandar es\n" +
                    " on pe.id_estandar = es.idestandar\n" +
                    " inner join encuesta en\n" +
                    " on pe.id_encuesta = en.idencuesta\n" +
                    " inner join respuesta_encuesta re\n" +
                    " on re.id_preguntaencuesta = pe.idpreguntaencuesta\n" +
                    " inner join usuario u\n" +
                    " on u.idusuario = re.id_usuario\n" +
                    " inner join persona p\n" +
                    " on u.id_persona=p.idpersona\n" +
                    " where pe.tipo_encuesta='ALUMNO' and es.idestandar = "+id_estandar+"\n" +
                    " \n" +
                    " union all\n" +
                    " \n" +
                    " select\n" +
                    " 'DE ACUERDO (DA)',\n" +
                    " sum(CASE WHEN re.respuesta='DA' THEN 1 ELSE 0 END),\n" +
                    " (sum(CASE WHEN re.respuesta='DA' THEN 1 ELSE 0 END)/count(re.idrespuestaencuesta))*100\n" +
                    " from pregunta_encuesta pe\n" +
                    " inner join estandar es\n" +
                    " on pe.id_estandar = es.idestandar\n" +
                    " inner join encuesta en\n" +
                    " on pe.id_encuesta = en.idencuesta\n" +
                    " inner join respuesta_encuesta re\n" +
                    " on re.id_preguntaencuesta = pe.idpreguntaencuesta\n" +
                    " inner join usuario u\n" +
                    " on u.idusuario = re.id_usuario\n" +
                    " inner join persona p\n" +
                    " on u.id_persona=p.idpersona\n" +
                    " where pe.tipo_encuesta='ALUMNO' and es.idestandar = "+id_estandar+"\n" +
                    " \n" +
                    " union all\n" +
                    " \n" +
                    " select\n" +
                    " 'POCO DE ACUERDO (PA)',\n" +
                    " sum(CASE WHEN re.respuesta='PA' THEN 1 ELSE 0 END),\n" +
                    " (sum(CASE WHEN re.respuesta='PA' THEN 1 ELSE 0 END)/count(re.idrespuestaencuesta))*100\n" +
                    " from pregunta_encuesta pe\n" +
                    " inner join estandar es\n" +
                    " on pe.id_estandar = es.idestandar\n" +
                    " inner join encuesta en\n" +
                    " on pe.id_encuesta = en.idencuesta\n" +
                    " inner join respuesta_encuesta re\n" +
                    " on re.id_preguntaencuesta = pe.idpreguntaencuesta\n" +
                    " inner join usuario u\n" +
                    " on u.idusuario = re.id_usuario\n" +
                    " inner join persona p\n" +
                    " on u.id_persona=p.idpersona\n" +
                    " where pe.tipo_encuesta='ALUMNO' and es.idestandar = "+id_estandar+"\n" +
                    " \n" +
                    " union all\n" +
                    " \n" +
                    " select\n" +
                    " 'EN DESACUERDO (DE)',\n" +
                    " sum(CASE WHEN re.respuesta='DE' THEN 1 ELSE 0 END),\n" +
                    " (sum(CASE WHEN re.respuesta='DE' THEN 1 ELSE 0 END)/count(re.idrespuestaencuesta))*100\n" +
                    " from pregunta_encuesta pe\n" +
                    " inner join estandar es\n" +
                    " on pe.id_estandar = es.idestandar\n" +
                    " inner join encuesta en\n" +
                    " on pe.id_encuesta = en.idencuesta\n" +
                    " inner join respuesta_encuesta re\n" +
                    " on re.id_preguntaencuesta = pe.idpreguntaencuesta\n" +
                    " inner join usuario u\n" +
                    " on u.idusuario = re.id_usuario\n" +
                    " inner join persona p\n" +
                    " on u.id_persona=p.idpersona\n" +
                    " where pe.tipo_encuesta='ALUMNO' and es.idestandar = "+id_estandar+"\n" +
                    " \n" +
                    " union all\n" +
                    " \n" +
                    " select\n" +
                    " 'NO CONOSCO EL TEMA (NC)',\n" +
                    " sum(CASE WHEN re.respuesta='NC' THEN 1 ELSE 0 END),\n" +
                    " (sum(CASE WHEN re.respuesta='NC' THEN 1 ELSE 0 END)/count(re.idrespuestaencuesta))*100\n" +
                    " from pregunta_encuesta pe\n" +
                    " inner join estandar es\n" +
                    " on pe.id_estandar = es.idestandar\n" +
                    " inner join encuesta en\n" +
                    " on pe.id_encuesta = en.idencuesta\n" +
                    " inner join respuesta_encuesta re\n" +
                    " on re.id_preguntaencuesta = pe.idpreguntaencuesta\n" +
                    " inner join usuario u\n" +
                    " on u.idusuario = re.id_usuario\n" +
                    " inner join persona p\n" +
                    " on u.id_persona=p.idpersona\n" +
                    " where pe.tipo_encuesta='ALUMNO' and es.idestandar = "+id_estandar);
        //</editor-fold>
    }

    @Override
    public List<PreguntaEncuesta> listar(String ref) {
        return list("from PreguntaEncuesta pe left join fetch pe.estandar");
    }

    @Override
    public List<PreguntaEncuesta> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public PreguntaEncuesta buscar(long id) {
        return search(PreguntaEncuesta.class,id);
    }

    @Override
    public long id() {
        return maxId(PreguntaEncuesta.class);
    }

    @Override
    public PreguntaEncuesta buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<PreguntaEncuesta> listarPreguntas(long idEncuesta) {
        return list("from PreguntaEncuesta pe inner join fetch pe.encuesta e where e.idencuesta="+idEncuesta);
    }
}
