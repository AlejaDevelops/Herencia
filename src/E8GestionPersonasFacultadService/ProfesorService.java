/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package E8GestionPersonasFacultadService;

import E8GestionPersonasFacultad.Empleado;
import E8GestionPersonasFacultad.Profesor;

/**
 *
 * @author AlejaDevelops
 */
public class ProfesorService extends EmpleadoService{
    public Profesor crearProfesor(){
        Profesor profe = new Profesor();
        EmpleadoService es = new EmpleadoService();
        Empleado empleado = es.crearEmpleado();
        profe.setNombreCompleto(empleado.getNombreCompleto());
        profe.setDni(empleado.getDni());
        profe.setEstadoCivil(empleado.getEstadoCivil());
        profe.setAnioIngreso(empleado.getAnioIngreso());
        profe.setNumDespacho(empleado.getNumDespacho());
        profe.setDepartamento(asignarDepartamento());
        
        return profe;
    }
    
    public String asignarDepartamento(){
        String[] departamentos = {"Lenguajes", "Matemáticas", "Arquitectura", "Deportes", "Laboratorios", "Humanidades", "Extensión", "Ciencias básicas", "Dibujo"};
        return departamentos[r.nextInt(departamentos.length)];
    }

}
