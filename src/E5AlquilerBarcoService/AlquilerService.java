/*
En un puerto se alquilan amarres para barcos de distinto tipo. Para cada Alquiler se guarda: el
nombre, documento del cliente, la fecha de alquiler, fecha de devolución, la posición del
amarre y el barco que lo ocupará.
Un Barco se caracteriza por: su matrícula, su eslora en metros y año de fabricación.
Sin embargo, se pretende diferenciar la información de algunos tipos de barcos especiales:
• Número de mástiles para veleros.
• Potencia en CV para barcos a motor.
• Potencia en CV y número de camarotes para yates de lujo.
Un alquiler se calcula multiplicando el número de días de ocupación (calculado con la fecha de
alquiler y devolución), por un valor módulo de cada barco (obtenido simplemente
multiplicando por 10 los metros de eslora).

En los barcos de tipo especial el módulo de cada barco se calcula sacando el módulo normal y
sumándole el atributo particular de cada barco. En los veleros se suma el número de mástiles,
en los barcos a motor se le suma la potencia en CV y en los yates se suma la potencia en CV y
el número de camarotes.
Utilizando la herencia de forma apropiada, deberemos programar en Java, las clases y los
métodos necesarios que permitan al usuario elegir el barco que quiera alquilar y mostrarle el
precio final de su alquiler.
 */
package E5AlquilerBarcoService;

import E5AlquilerBarco.Alquiler;
import E5AlquilerBarco.Barco;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class AlquilerService {

    Random r = new Random();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Alquiler crearCliente() {
        Alquiler alquiler = new Alquiler();
        alquiler.setNombreCliente(crearNombre());
        alquiler.setDocCliente(crearDocCliente());
        alquiler.setFechaAlquiler(crearFechaAlquiler());
        alquiler.setFechaDevolucion(crearFechaDevolucion(alquiler.getFechaAlquiler()));
        alquiler.setAmarre(r.nextInt(60));
        alquiler.setBarco(crearBarco());

        return alquiler;
    }

    public String crearNombre() {
        String[] nombres = {"Juan", "María", "Carlos", "Laura", "Andrés", "Ana", "Pedro", "Sofía", "Alejandro", "Gabriela"};
        String[] apellidos = {"López", "Rodríguez", "García", "Martínez", "González", "Pérez", "Sánchez", "Romero", "Flores"};
        String nombre = nombres[r.nextInt(nombres.length)];
        String apellido = apellidos[r.nextInt(apellidos.length)];

        return nombre + " " + apellido;
    }

    public int crearDocCliente() {
        return (r.nextInt(90000000) + 40000000);
    }

    public LocalDate crearFechaAlquiler() {
        LocalDate hoy = LocalDate.now();
        int diasAleatorios = r.nextInt(30);
        LocalDate nuevaFecha = hoy.plusDays(diasAleatorios);

        return nuevaFecha;
    }
    
    public LocalDate crearFechaDevolucion(LocalDate fechaAlquiler){
        int diasAleatorios = (r.nextInt(30)+1);
        LocalDate fechaDevolucion = fechaAlquiler.plusDays(diasAleatorios);
        
        return fechaDevolucion;
    }
    
    public Barco crearBarco(){
        Barco b = new Barco();
        b.setMatricula(r.nextInt(999)+1);
        b.setEslora(r.nextInt(100)+10);
        b.setAnioFabricacion(Year.of((r.nextInt(2022-1950+1))+1950));
        
        return b;
    }
    
    public int calcularDiasDeOcupacion(LocalDate fechaAlquiler, LocalDate fechaDevolucion){
        int diasDeOcupacion = (int)ChronoUnit.DAYS.between(fechaAlquiler, fechaDevolucion);
        
        return diasDeOcupacion;
    }

    public double calcularModulo(double slora){
        return slora*10;
    }
    
    public double calcularValorAlquiler(Alquiler alquiler){
        int diasDeOcupacion = calcularDiasDeOcupacion(alquiler.getFechaAlquiler(), alquiler.getFechaDevolucion());
        double modulo = calcularModulo(alquiler.getBarco().getEslora());
        return diasDeOcupacion*modulo;
    }
}
