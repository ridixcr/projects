package org.edessco.sva.be;
// Generated 17-ene-2015 17:53:31 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Persona generated by hbm2java
 */
@Component
public class Persona  implements java.io.Serializable {


     private Long idpersona;
     private UnidadAcademica unidadAcademica;
     private String nombres;
     private String apellidoPaterno;
     private String apellidoMaterno;
     private String dni;
     private String telefono;
     private String correo;
     private String sexo;
     private Set<Docente> docentes = new HashSet<Docente>(0);
     private Set<Alumno> alumnos = new HashSet<Alumno>(0);
     private Set<MiembroComiteInterno> comisionInternas = new HashSet<MiembroComiteInterno>(0);
     private Set<Egresado> egresados = new HashSet<Egresado>(0);
     private Set<Usuario> usuarios = new HashSet<Usuario>(0);
     private Set<GrupoInteres> grupoIntereses = new HashSet<GrupoInteres>(0);
     private Set<Administrativo> administrativos = new HashSet<Administrativo>(0);

    public Persona() {
        this.idpersona = null;
        this.unidadAcademica = new UnidadAcademica();
    }

	
    public Persona(UnidadAcademica unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }
    public Persona(UnidadAcademica unidadAcademica, String nombres, String apellidoPaterno, String apellidoMaterno, String dni, String telefono, String correo, String sexo, Set<Docente> docentes, Set<Alumno> alumnos, Set<MiembroComiteInterno> comisionInternas, Set<Egresado> egresados, Set<Usuario> usuarios, Set<GrupoInteres> grupoIntereses, Set<Administrativo> administrativos) {
       this.unidadAcademica = unidadAcademica;
       this.nombres = nombres;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.dni = dni;
       this.telefono = telefono;
       this.correo = correo;
       this.sexo = sexo;
       this.docentes = docentes;
       this.alumnos = alumnos;
       this.comisionInternas = comisionInternas;
       this.egresados = egresados;
       this.usuarios = usuarios;
       this.grupoIntereses = grupoIntereses;
       this.administrativos = administrativos;
    }
   
    public Long getIdpersona() {
        return this.idpersona;
    }
    
    public void setIdpersona(Long idpersona) {
        this.idpersona = idpersona;
    }
    public UnidadAcademica getUnidadAcademica() {
        return this.unidadAcademica;
    }
    
    public void setUnidadAcademica(UnidadAcademica unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }
    
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public Set<Docente> getDocentes() {
        return this.docentes;
    }
    
    public void setDocentes(Set<Docente> docentes) {
        this.docentes = docentes;
    }
    public Set<Alumno> getAlumnos() {
        return this.alumnos;
    }
    
    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    public Set<MiembroComiteInterno> getComisionInternas() {
        return this.comisionInternas;
    }
    
    public void setComisionInternas(Set<MiembroComiteInterno> comisionInternas) {
        this.comisionInternas = comisionInternas;
    }
    public Set<Egresado> getEgresados() {
        return this.egresados;
    }
    
    public void setEgresados(Set<Egresado> egresados) {
        this.egresados = egresados;
    }
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public Set<GrupoInteres> getGrupoIntereses() {
        return this.grupoIntereses;
    }
    
    public void setGrupoIntereses(Set<GrupoInteres> grupoIntereses) {
        this.grupoIntereses = grupoIntereses;
    }
    public Set<Administrativo> getAdministrativos() {
        return this.administrativos;
    }
    
    public void setAdministrativos(Set<Administrativo> administrativos) {
        this.administrativos = administrativos;
    }




}


