/*
Sistema Gestión Facultad. Se pretende realizar una aplicación para una facultad que gestione
la información sobre las personas vinculadas con la misma y que se pueden clasificar en tres
tipos: estudiantes, profesores y personal de servicio. A continuación, se detalla qué tipo de
información debe gestionar esta aplicación:
• Por cada persona, se debe conocer, al menos, su nombre y apellidos, su número de
identificación y su estado civil.
• Con respecto a los empleados, sean del tipo que sean, hay que saber su año de
incorporación a la facultad y qué número de despacho tienen asignado.
• En cuanto a los estudiantes, se requiere almacenar el curso en el que están
matriculados.
• Por lo que se refiere a los profesores, es necesario gestionar a qué departamento
pertenecen (lenguajes, matemáticas, arquitectura, ...).
• Sobre el personal de servicio, hay que conocer a qué sección están asignados
(biblioteca, decanato, secretaría, ...).
El ejercicio consiste, en primer lugar, en definir la jerarquía de clases de esta aplicación. A
continuación, debe programar las clases definidas en las que, además de los constructores,
hay que desarrollar los métodos correspondientes a las siguientes operaciones:
• Cambio del estado civil de una persona.
• Reasignación de despacho a un empleado.
• Matriculación de un estudiante en un nuevo curso.
• Cambio de departamento de un profesor.
• Traslado de sección de un empleado del personal de servicio.
• Imprimir toda la información de cada tipo de individuo. Incluya un programa de prueba
que instancie objetos de los distintos tipos y pruebe los métodos desarrollados.
 */

package E8GestionPersonasFacultadService;

import E8GestionPersonasFacultad.Empleado;
import E8GestionPersonasFacultad.PersonaServicio;

/**
 *
 * @author AlejaDevelops
 */
public class PersonaServicioService extends EmpleadoService{
    public PersonaServicio crearPersonaServicio(){
        PersonaServicio ps = new PersonaServicio();
        EmpleadoService es = new EmpleadoService();
        Empleado empleado = es.crearEmpleado();
        ps.setNombreCompleto(empleado.getNombreCompleto());
        ps.setDni(empleado.getDni());
        ps.setEstadoCivil(empleado.getEstadoCivil());
        ps.setAnioIngreso(empleado.getAnioIngreso());
        ps.setNumDespacho(empleado.getNumDespacho());
        ps.setSeccionAsignada(asignarSeccion());
        
        return ps;
    }
    
    public String asignarSeccion(){
        String[] secciones = {"Biblioteca", "Decanato", "Secretaría", "Departamento de Admisiones", "Departamento de Finanzas", "Departamento de Recursos Humanos", "Oficina de Estudiantes", "Oficina de Asuntos Académicos", "Oficina de Relaciones Internacionales", "Oficina de Prácticas Profesionales", "Centro de Investigación", "Laboratorio de Informática", "Sala de Conferencias", "Aula Magna", "Comedor Universitario", "Gimnasio", "Oficina de Orientación y Consejería", "Oficina de Extensión Universitaria", "Centro de Bienestar Estudiantil", "Centro de Tecnologías de la Información"};
        return secciones[r.nextInt(secciones.length)];
    }

}
