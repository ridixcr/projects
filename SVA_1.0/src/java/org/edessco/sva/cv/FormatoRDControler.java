
package org.edessco.sva.cv;

import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import org.edessco.sva.be.RespuestaEncuesta;
import org.edessco.sva.bl.RespuestaEncuestaBL;

@ManagedBean
@ViewScoped
public class FormatoRDControler {
    @ManagedProperty(value = "#{respuestaEncuestaBL}")
    private RespuestaEncuestaBL respuestaEncuestaBL;
    @ManagedProperty(value = "#{respuestaEncuesta}")
    private RespuestaEncuesta factor;
    
    private List<RespuestaEncuesta> listaRespuestasEncuesta = new LinkedList<>();
    public FormatoRDControler() {
    }
    
}
