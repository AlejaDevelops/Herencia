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
import E8GestionPersonasFacultad.Estudiante;
import E8GestionPersonasFacultad.Persona;
import E8GestionPersonasFacultad.PersonaServicio;
import E8GestionPersonasFacultad.Profesor;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class SistemaGestionService {

    Random r = new Random();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Persona> listaPersonas = new ArrayList();

    public void menu() {

        listaPersonas = crearPersonas();
        System.out.println("*** Bienvenido al sistema de gestión de personas de la Facultad ***");
        int input;

        do {
            System.out.println("Escoge una opción del siguiente menú"
                    + "\n 1- Ver lista completa de personas"
                    + "\n 2- Cambiar el estado civil de una persona"
                    + "\n 3- Reasignar un nuevo despacho a un empleado"
                    + "\n 4- Matricular en nuevo curso a un estudiante"
                    + "\n 5- Cambiar de departamento a un profesor"
                    + "\n 6- Trasladar de seccion a una persona de servicio"
                    + "\n 7- Salir");
            input = leer.nextInt();
            switch (input) {
                case 1:
                    System.out.println(listaPersonas.size());
                    imprimirLista(listaPersonas);
                    break;
                case 2:
                    System.out.println("Ingresa el documento de identidad de la persona a realizar el cambio");
                    long dni = leer.nextLong();
                    boolean flag = false;

                    for (Persona aux : listaPersonas) {
                        if (dni == aux.getDni()) {
                            cambiarEstadoCivil(aux);
                            System.out.println("Estado civil cambiado");
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("El documento de identidad ingresado no es válido");
                    }
                    System.out.println("-----------------------------------------");
                    break;
                case 3:
                    System.out.println("Ingresa el documento de identidad de la persona a realizar el cambio");
                    long dni2 = leer.nextLong();
                    boolean flag2 = false;
                    for (Persona aux : listaPersonas) {
                        if (dni2 == aux.getDni()) {
                            reasignarNuevoDespacho((Empleado) aux);
                            System.out.println("Despacho cambiado");
                            flag2 = true;
                            break;
                        }
                    }
                    if (!flag2) {
                        System.out.println("El documento de identidad ingresado no es válido");
                    }
                    System.out.println("-----------------------------------------");
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opción no válida, intenta nuevamente");
                    break;

            }

        } while (input != 7);

    }

    public ArrayList<Persona> crearPersonas() {
        ArrayList<Persona> listaPersonas = new ArrayList();

        int n = r.nextInt(10) + 5;
        for (int i = 0; i < n; i++) {
            EstudianteService es = new EstudianteService();
            Estudiante estudiante = es.crearEstudiante();
            listaPersonas.add(estudiante);
        }

        n = r.nextInt(5) + 2;
        for (int i = 0; i < n; i++) {
            ProfesorService ps = new ProfesorService();
            Profesor profe = ps.crearProfesor();
            listaPersonas.add(profe);

            PersonaServicioService pss = new PersonaServicioService();
            PersonaServicio personaServicio = pss.crearPersonaServicio();
            listaPersonas.add(personaServicio);
        }

        return listaPersonas;

    }

    public void imprimirLista(ArrayList<Persona> listaPersonas) {
        for (Persona aux : listaPersonas) {
            System.out.println(aux);
            System.out.println("-----------------------------");
        }
    }

    public void cambiarEstadoCivil(Persona p) {
        System.out.println("Ingresa el nuevo estado civil /Casado/Soltero/Union libre");
        p.setEstadoCivil(leer.next());
    }

    public void reasignarNuevoDespacho(Empleado p) {
        System.out.println("Ingresa el número del nuevo despacho");
        p.setNumDespacho(leer.nextInt());
    }

}
