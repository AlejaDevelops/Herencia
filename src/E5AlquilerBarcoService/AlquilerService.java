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
import E5AlquilerBarco.BarcoaMotor;
import E5AlquilerBarco.Velero;
import E5AlquilerBarco.YatesLujo;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
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
        alquiler.setAmarre(r.nextInt(60)+1);

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

    public LocalDate crearFechaDevolucion(LocalDate fechaAlquiler) {
        int diasAleatorios = (r.nextInt(30) + 1);
        LocalDate fechaDevolucion = fechaAlquiler.plusDays(diasAleatorios);

        return fechaDevolucion;
    }

    public Barco crearBarco() {
        Barco b = new Barco();
        b.setMatricula(r.nextInt(999) + 1);
        b.setEslora(r.nextInt(100) + 10);
        b.setAnioFabricacion(Year.of((r.nextInt(2022 - 1950 + 1)) + 1950));

        return b;
    }

    public int calcularDiasDeOcupacion(LocalDate fechaAlquiler, LocalDate fechaDevolucion) {
        int diasDeOcupacion = (int) ChronoUnit.DAYS.between(fechaAlquiler, fechaDevolucion);

        return diasDeOcupacion;
    }

    public double calcularModulo(double slora) {
        return slora * 10;
    }

    public double calcularValorAlquiler(Alquiler alquiler) {
        int diasDeOcupacion = calcularDiasDeOcupacion(alquiler.getFechaAlquiler(), alquiler.getFechaDevolucion());
        double modulo = calcularModulo(alquiler.getBarco().getEslora());
        return diasDeOcupacion * modulo;
    }

    public void alquilarUnBarco() { // Agreagar un bargo al cliente
        Alquiler alquiler = crearCliente(); //Creación de un cliente genérico sin el barco      
        System.out.println("Hola! " + alquiler.getNombreCliente() + ". Selecciona el tipo de barco que deseas alquilar: "
                + "\n 1- Velero "
                + "\n 2- Barco a motor "
                + "\n 3- Yate");
        int input = leer.nextInt();
        int n;

        switch (input) {
            case 1: //Velero
                n = r.nextInt(5) + 1;
                HashMap<Double, Velero> mapaDeVeleros = new HashMap<>();
                VeleroService vs = new VeleroService();

                System.out.println("Estos son los veleros disponibles: ");
                for (int i = 0; i < n; i++) { //Creando y Agregando veleros a listaDeVeleros
                    Velero velero = vs.crearVelero();
                    double valorAlquiler = vs.calcularValorAlquiler(alquiler);
                    System.out.println("Velero " + (i + 1) + "- " + velero + ", Valor alquiler: $" + valorAlquiler);
                    mapaDeVeleros.put(valorAlquiler, velero);
                }
                System.out.println(" ");
                System.out.println("Ingresa el valor $ del velero que deseas alquilar ");
                Double x = leer.nextDouble();

                if (mapaDeVeleros.containsKey(x)) {
                    Velero velero = mapaDeVeleros.get(x);
                    alquiler.setBarco(velero); //Se guarda el barco elegido en el objeto Alquiler
                    System.out.println("Te confirmo la información del alquiler: " + alquiler + "\n Tipo de barco: Velero" + "\n Valor alquiler: $" + x);
                }

                break;

            case 2:
                n = r.nextInt(5) + 1;
                HashMap<Double, BarcoaMotor> mapaDeMotorizados = new HashMap();
                BarcoaMotorService ms = new BarcoaMotorService();

                System.out.println("Estos son los barcos a motor disponibles: ");
                for (int i = 0; i < n; i++) { //Creando y Agregando barcos a motor a listaDeMotorizados
                    BarcoaMotor motorizado = ms.crearMotorizado();
                    double valorAlquiler = ms.calcularValorAlquiler(alquiler);
                    System.out.println("Barco a motor " + (i + 1) + "- " + motorizado + ", Valor alquiler: $" + valorAlquiler);
                    mapaDeMotorizados.put(valorAlquiler, motorizado);
                }
                System.out.println(" ");
                System.out.println("Ingresa el valor $ del barco a motor que deseas alquilar ");
                Double y = leer.nextDouble();
                if (mapaDeMotorizados.containsKey(y)) {
                    BarcoaMotor motorizado = mapaDeMotorizados.get(y);
                    alquiler.setBarco(motorizado); //Se guarda el barco elegido en el objeto Alquiler
                    System.out.println("Te confirmo la información del alquiler: " + alquiler + "\n Tipo de barco: Barco a motor" + "\n Valor alquiler: $" + y);
                }

                break;

            case 3:
                n = r.nextInt(5) + 1;
                HashMap<Double, YatesLujo> mapaDeYates = new HashMap();
                YatesLujoService ys = new YatesLujoService();
                System.out.println("Estos son los yates disponibles: ");
                for (int i = 0; i < n; i++) { //Creando y Agregando barcos a motor a listaDeMotorizados
                    YatesLujo yate = ys.crearYate();
                    double valorAlquiler = ys.calcularValorAlquiler(alquiler);
                    System.out.println("Yate " + (i + 1) + "- " + yate + ", Valor alquiler: $" + valorAlquiler);
                    mapaDeYates.put(valorAlquiler, yate);
                }
                System.out.println(" ");
                System.out.println("Ingresa el valor $ del yate que deseas alquilar ");
                Double z = leer.nextDouble();
                if (mapaDeYates.containsKey(z)) {
                    YatesLujo yate = mapaDeYates.get(z);
                    alquiler.setBarco(yate); //Se guarda el barco elegido en el objeto Alquiler
                    System.out.println("Te confirmo la información del alquiler: " + alquiler + "\n Tipo de barco: Yate" + "\n Valor alquiler: $" + z);
                }

                break;

            default:
                System.out.println("Opción no válida");

        }

    }
}
