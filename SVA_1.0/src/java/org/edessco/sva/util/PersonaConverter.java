package org.edessco.sva.util;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import org.edessco.sva.be.Persona;
import org.edessco.sva.bl.PersonaBL;
import org.edessco.sva.cv.PersonaControler;

@FacesConverter("personaConverter")
public class PersonaConverter implements Converter {

    @ManagedProperty(value = "#{personaControler}")
    private PersonaControler persControler;

    @ManagedProperty(value = "#{personaBL}")
    private PersonaBL personaBL;
    private List<Persona> listaPersonas = new LinkedList<>();

    public void listar() {
        setListaPersonas(getPersonaBL().listar());
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        System.out.println("valeu ..........." + value);
//        listar();
//        System.out.println("lista  tamanio ... " + getListaPersonas().size());
//        for (Persona p : getListaPersonas()) {
//            if (p.getIdpersona().equals(Long.parseLong(value))) {
//                return p;
//            }
//        }
        
//                int number = Integer.parseInt(value);
//                //PersonaControler pers = (PersonaControler) fc.getExternalContext().getApplicationMap().get("personaControler");
//                Persona pers = (Persona) fc.getExternalContext().getApplicationMap().get("persona");
//                //System.out.println("persona "+pers.getPersona().getNombres());
//                return pers.getListaPersonas().get(Integer.parseInt(value));
        return null;

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return String.valueOf(((Persona) object).getIdpersona());
        } else {
            return null;
        }
    }

    public PersonaControler getPersControler() {
        return persControler;
    }

    public void setPersControler(PersonaControler persControler) {
        this.persControler = persControler;
    }

    public PersonaBL getPersonaBL() {
        return personaBL;
    }

    public void setPersonaBL(PersonaBL personaBL) {
        this.personaBL = personaBL;
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
}
