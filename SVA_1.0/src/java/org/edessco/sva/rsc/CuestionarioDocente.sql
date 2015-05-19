select
p.apellido_paterno,p.nombres,pc.pregunta,rc.respuesta as cumplimiento,
rc.explicacion_docente, rc.alternativa_solucion_docente
from persona p
inner join docente d
on d.id_persona = p.idpersona
inner join usuario u
on u.id_persona = p.idpersona
inner join unidad_academica ua
on p.id_unidad_academica = ua.idunidadacademica
inner join autoevaluacion a
on a.id_unidadacademica = ua.idunidadacademica 
inner join cuestionario c
on c.id_autoevaluacion=a.idautoevaluacion
inner join pregunta_cuestionario pc
on pc.id_cuestionario=c.idcuestionario
inner join estandar es
on pc.id_estandar=es.idestandar
inner join respuesta_cuestionario rc
on rc.id_preguntacuestionario=pc.idpreguntacuestionario
order by p.idpersona asc