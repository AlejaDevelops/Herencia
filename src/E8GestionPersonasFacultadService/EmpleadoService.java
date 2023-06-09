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
import E8GestionPersonasFacultad.Persona;
import java.time.Year;

/**
 *
 * @author AlejaDevelops
 */
public class EmpleadoService extends PersonaService{
    public Empleado crearEmpleado(){
        Empleado empleado = new Empleado();
        PersonaService es = new PersonaService();
        Persona persona = es.crearPersona();
        empleado.setNombreCompleto(persona.getNombreCompleto());
        empleado.setDni(persona.getDni());
        empleado.setEstadoCivil(persona.getEstadoCivil());
        empleado.setAnioIngreso(Year.of(r.nextInt(63)+1960));
        empleado.setNumDespacho(r.nextInt(999)+100);
        
        return empleado;
    }

}
