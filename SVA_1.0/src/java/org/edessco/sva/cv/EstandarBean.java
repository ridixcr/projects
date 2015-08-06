/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edessco.sva.cv;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import org.edessco.sva.be.*;
import org.edessco.sva.bl.*;
import org.edessco.sva.util.Tarea;
import static org.edessco.sva.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class EstandarBean {

    @ManagedProperty(value = "#{estandarBL}")
    private EstandarBL estandarBL;
    @ManagedProperty(value = "#{estandar}")
    private Estandar estandar;
    private List<Estandar> listaEstandares = new LinkedList<>();
    private List<SelectItem> selectOneItemsEstandar;

    @ManagedProperty(value = "#{matrizRecoleccionDatosBL}")
    private MatrizRecoleccionDatosBL matrizRecoleccionDatosBL;
    @ManagedProperty(value = "#{matrizRecoleccionDatos}")
    private MatrizRecoleccionDatos matrizRecoleccionDatos;
    
    @ManagedProperty(value = "#{registroResultadoBL}")
    private RegistroResultadoBL registroResultadoBL;
    @ManagedProperty(value = "#{registroResultado}")
    private RegistroResultado registroResultado;
    
    @ManagedProperty(value = "#{registroGradoCumplimientoBL}")
    private RegistroGradoCumplimientoBL registroGradoCumplimientoBL;
    @ManagedProperty(value = "#{registroGradoCumplimiento}")
    private RegistroGradoCumplimiento registroGradoCumplimiento;
    
    @ManagedProperty(value = "#{iniciativaMejoraBL}")
    private IniciativaMejoraBL iniciativaMejoraBL;
    @ManagedProperty(value = "#{iniciativaMejora}")
    private IniciativaMejora iniciativaMejora;

    @ManagedProperty(value = "#{autoevaluacionBL}")
    private AutoevaluacionBL autoevaluacionBL;
    @ManagedProperty(value = "#{autoevaluacion}")
    private Autoevaluacion autoevaluacion;

    private List listaResultadosEncuestaDocente = new LinkedList<>();

    @PostConstruct
    public void init() {
        setAutoevaluacion(getAutoevaluacionBL().buscar(getAutoevaluacionBL().maxId()));
        listar();
    }

    public void recuperarResultadosFMR(long id_estandar) {
        setMatrizRecoleccionDatos(getMatrizRecoleccionDatosBL().buscar(id_estandar, getAutoevaluacion().getIdautoevaluacion()));
        if (getMatrizRecoleccionDatos() == null) {
            setMatrizRecoleccionDatos(new MatrizRecoleccionDatos());
            getMatrizRecoleccionDatos().setEstandar(getEstandarBL().buscar(id_estandar));
            getMatrizRecoleccionDatos().setAutoevaluacion(getAutoevaluacion());
            getMatrizRecoleccionDatos().setFechaRegistro(new Date());
            listaResultadosEncuestaDocente.clear();
            listaResultadosEncuestaDocente.addAll(getEstandarBL().respuestaCuestionarioDocente(id_estandar));
            for (Object item : listaResultadosEncuestaDocente) {
                Object[] o = (Object[]) item;
                if (Double.parseDouble(o[0].toString()) >= 50) {
                    getMatrizRecoleccionDatos().setResultadoCuestionario(true);
                } else {
                    getMatrizRecoleccionDatos().setResultadoCuestionario(false);
                }
            }
        }
    }
    public void recuperarResultadosFRR(long id_estandar) {
        setRegistroResultado(getRegistroResultadoBL().buscar(id_estandar, getAutoevaluacion().getIdautoevaluacion()));
        if (getRegistroResultado() == null) {
            setRegistroResultado(new RegistroResultado());
            getRegistroResultado().setEstandar(getEstandarBL().buscar(id_estandar));
            getRegistroResultado().setAutoevaluacion(getAutoevaluacion());
            getRegistroResultado().setFechaTaller(new Date());
            listaResultadosEncuestaDocente.clear();
            listaResultadosEncuestaDocente.addAll(getEstandarBL().respuestaCuestionarioDocente(id_estandar));
            for (Object item : listaResultadosEncuestaDocente) {
                Object[] o = (Object[]) item;
                if (Double.parseDouble(o[0].toString()) >= 50) {
                    getRegistroResultado().setEstado(true);
                } else {
                    getRegistroResultado().setEstado(false);
                }
            }
        }
    }
    public void recuperarResultadosFRC(long id_estandar) {
        setRegistroGradoCumplimiento(getRegistroGradoCumplimientoBL().buscar(id_estandar, getAutoevaluacion().getIdautoevaluacion()));
        if (getRegistroGradoCumplimiento() == null) {
            setRegistroGradoCumplimiento(new RegistroGradoCumplimiento());
            getRegistroGradoCumplimiento().setEstandar(getEstandarBL().buscar(id_estandar));
            getRegistroGradoCumplimiento().setAutoevaluacion(getAutoevaluacion());            
            listaResultadosEncuestaDocente.clear();
            listaResultadosEncuestaDocente.addAll(getEstandarBL().respuestaCuestionarioDocente(id_estandar));
            for (Object item : listaResultadosEncuestaDocente) {
                Object[] o = (Object[]) item;
                if (Double.parseDouble(o[0].toString()) >= 50) {
                    getRegistroGradoCumplimiento().setCumplimiento(true);
                } else {
                    getRegistroGradoCumplimiento().setCumplimiento(false);
                }
            }
        }
    }
    public void recuperarResultadosFRM(long id_estandar) {
        setIniciativaMejora(getIniciativaMejoraBL().buscar(id_estandar, getAutoevaluacion().getIdautoevaluacion()));
        if (getIniciativaMejora() == null) {
            setIniciativaMejora(new IniciativaMejora());
            getIniciativaMejora().setEstandar(getEstandarBL().buscar(id_estandar));
            getIniciativaMejora().setAutoevaluacion(getAutoevaluacion());            
            listaResultadosEncuestaDocente.clear();
            listaResultadosEncuestaDocente.addAll(getEstandarBL().respuestaCuestionarioDocente(id_estandar));
            for (Object item : listaResultadosEncuestaDocente) {
                Object[] o = (Object[]) item;
                if (Double.parseDouble(o[0].toString()) >= 50) {
                    getIniciativaMejora().setEstado(true);
                } else {
                    getIniciativaMejora().setEstado(false);
                }
            }
        }
    }

    public void guardarMatrizRecoleccionDatos() {
        if (getMatrizRecoleccionDatos().getIdmatriz() <= 0) {
            setTareaEvento(new Tarea(Tarea.REGISTRO,  getMatrizRecoleccionDatosBL().registrar(getMatrizRecoleccionDatos())) {
                @Override
                public void proceso() {
                    setMatrizRecoleccionDatos(new MatrizRecoleccionDatos());
                }
            });
        } else {
            setTareaEvento(new Tarea(Tarea.ACTUALIZACION,getMatrizRecoleccionDatosBL().actualizar(getMatrizRecoleccionDatos())) {
                @Override
                public void proceso() {}
            });
            ;
        }
        setMatrizRecoleccionDatos(new MatrizRecoleccionDatos());
    }
    public void guardarRegistroResultados() {
        if (getRegistroResultado().getIdregistroresultado() <= 0) {
            setTareaEvento(new Tarea(Tarea.REGISTRO,  getRegistroResultadoBL().registrar(getRegistroResultado())) {
                @Override
                public void proceso() {
                    setMatrizRecoleccionDatos(new MatrizRecoleccionDatos());
                }
            });
        } else {
            setTareaEvento(new Tarea(Tarea.ACTUALIZACION,getRegistroResultadoBL().actualizar(getRegistroResultado())) {
                @Override
                public void proceso() {}
            });
            ;
        }
        setMatrizRecoleccionDatos(new MatrizRecoleccionDatos());
    }
    public void guardarRegistroGradoCumplimiento() {
        if (getRegistroGradoCumplimiento().getIdgradocumplimiento() <= 0) {
            setTareaEvento(new Tarea(Tarea.REGISTRO,  getRegistroGradoCumplimientoBL().registrar(getRegistroGradoCumplimiento())) {
                @Override
                public void proceso() {
                    setRegistroGradoCumplimiento(new RegistroGradoCumplimiento());
                }
            });
        } else {
            setTareaEvento(new Tarea(Tarea.ACTUALIZACION,getRegistroGradoCumplimientoBL().actualizar(getRegistroGradoCumplimiento())) {
                @Override
                public void proceso() {}
            });
            ;
        }
        setMatrizRecoleccionDatos(new MatrizRecoleccionDatos());
    }
    public void guardarIniciativaMejora() {
        if (getIniciativaMejora().getIdiniciativa() <= 0) {
            setTareaEvento(new Tarea(Tarea.REGISTRO,  getIniciativaMejoraBL().registrar(getIniciativaMejora())) {
                @Override
                public void proceso() {
                    setIniciativaMejora(new IniciativaMejora());
                }
            });
        } else {
            setTareaEvento(new Tarea(Tarea.ACTUALIZACION,getIniciativaMejoraBL().actualizar(getIniciativaMejora())) {
                @Override
                public void proceso() {}
            });
            ;
        }
        setMatrizRecoleccionDatos(new MatrizRecoleccionDatos());
    }

    public void registrar() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getEstandarBL().registrar(getEstandar())) {
            @Override
            public void proceso() {
                estandar = new Estandar();
                listar();
            }
        });
    }

    public void listar() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if (httpSession.getAttribute("idCriterio") != null) {
            setListaEstandares(getEstandarBL().listarEstandar(Long.parseLong(httpSession.getAttribute("idCriterio").toString())));
        } else {
            setListaEstandares(getEstandarBL().listar(""));
        }
    }

    public void actualizar() {
        Estandar temp = new Estandar();
        String msg;
        temp = buscarId();

        temp.setNumeroEstandar(getEstandar().getNumeroEstandar());
        temp.setTitulo(getEstandar().getTitulo());
        temp.setDescripcion(getEstandar().getDescripcion());
        temp.setTipoEstandar(getEstandar().getTipoEstandar());
        temp.setEstado(getEstandar().getEstado());
        temp.setCriterio(getEstandar().getCriterio());

        long res = getEstandarBL().actualizar(temp);
        if (res == 0) {
            msg = "Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listar();
    }

    public void eliminar() {
        Estandar temp = new Estandar();
        String msg;
        temp = buscarId();
        long res = getEstandarBL().eliminar(temp);
        if (res == 0) {
            msg = "Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al eliminar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        listar();
    }

    public Estandar buscarId() {
        return estandarBL.buscar(getEstandar().getIdestandar());
    }

    public void limpiar() {
        this.estandar.setIdestandar(null);
        this.estandar.setNumeroEstandar(null);
        this.estandar.setTitulo("");
        this.estandar.setDescripcion("");
        this.estandar.setEstado(false);
        estandar.setCriterio(new Criterio());
    }

    public EstandarBL getEstandarBL() {
        return estandarBL;
    }

    public void setEstandarBL(EstandarBL estandarBL) {
        this.estandarBL = estandarBL;
    }

    public Estandar getEstandar() {
        return estandar;
    }

    public void setEstandar(Estandar estandar) {
        this.estandar = estandar;
    }

    public List<Estandar> getListaEstandares() {
        return listaEstandares;
    }

    public void setListaEstandares(List<Estandar> listaEstandares) {
        this.listaEstandares = listaEstandares;
    }

    public List<SelectItem> getSelectOneItemsEstandar() {
        this.selectOneItemsEstandar = new LinkedList<SelectItem>();
        for (Estandar estandar1 : listaEstandares) {
            this.setEstandar(estandar1);
            SelectItem selectItem = new SelectItem(estandar.getIdestandar(), estandar.getTitulo());
            this.selectOneItemsEstandar.add(selectItem);
        }
        return selectOneItemsEstandar;
    }

    public void setSelectOneItemsEstandar(List<SelectItem> selectOneItemsEstandar) {
        this.selectOneItemsEstandar = selectOneItemsEstandar;
    }

    public MatrizRecoleccionDatosBL getMatrizRecoleccionDatosBL() {
        return matrizRecoleccionDatosBL;
    }

    public void setMatrizRecoleccionDatosBL(MatrizRecoleccionDatosBL matrizRecoleccionDatosBL) {
        this.matrizRecoleccionDatosBL = matrizRecoleccionDatosBL;
    }

    public MatrizRecoleccionDatos getMatrizRecoleccionDatos() {
        return matrizRecoleccionDatos;
    }

    public void setMatrizRecoleccionDatos(MatrizRecoleccionDatos matrizRecoleccionDatos) {
        this.matrizRecoleccionDatos = matrizRecoleccionDatos;
    }

    public AutoevaluacionBL getAutoevaluacionBL() {
        return autoevaluacionBL;
    }

    public void setAutoevaluacionBL(AutoevaluacionBL autoevaluacionBL) {
        this.autoevaluacionBL = autoevaluacionBL;
    }

    public Autoevaluacion getAutoevaluacion() {
        return autoevaluacion;
    }

    public void setAutoevaluacion(Autoevaluacion autoevaluacion) {
        this.autoevaluacion = autoevaluacion;
    }

    public RegistroResultadoBL getRegistroResultadoBL() {
        return registroResultadoBL;
    }

    public void setRegistroResultadoBL(RegistroResultadoBL registroResultadoBL) {
        this.registroResultadoBL = registroResultadoBL;
    }

    public RegistroResultado getRegistroResultado() {
        return registroResultado;
    }

    public void setRegistroResultado(RegistroResultado registroResultado) {
        this.registroResultado = registroResultado;
    }

    public RegistroGradoCumplimientoBL getRegistroGradoCumplimientoBL() {
        return registroGradoCumplimientoBL;
    }

    public void setRegistroGradoCumplimientoBL(RegistroGradoCumplimientoBL registroGradoCumplimientoBL) {
        this.registroGradoCumplimientoBL = registroGradoCumplimientoBL;
    }

    public RegistroGradoCumplimiento getRegistroGradoCumplimiento() {
        return registroGradoCumplimiento;
    }

    public void setRegistroGradoCumplimiento(RegistroGradoCumplimiento registroGradoCumplimiento) {
        this.registroGradoCumplimiento = registroGradoCumplimiento;
    }

    public IniciativaMejoraBL getIniciativaMejoraBL() {
        return iniciativaMejoraBL;
    }

    public void setIniciativaMejoraBL(IniciativaMejoraBL iniciativaMejoraBL) {
        this.iniciativaMejoraBL = iniciativaMejoraBL;
    }

    public IniciativaMejora getIniciativaMejora() {
        return iniciativaMejora;
    }

    public void setIniciativaMejora(IniciativaMejora iniciativaMejora) {
        this.iniciativaMejora = iniciativaMejora;
    }

}
