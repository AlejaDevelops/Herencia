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
package E5AlquilerBarco;

import E5AlquilerBarcoService.AlquilerService;
import E5AlquilerBarcoService.BarcoaMotorService;
import E5AlquilerBarcoService.VeleroService;
import E5AlquilerBarcoService.YatesLujoService;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class AlquilerBarcoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AlquilerService as = new AlquilerService(); 
        Alquiler alquiler = as.crearCliente(); //Creación de un cliente genérico
        
        System.out.println("Selecciona el tipo de barco que deseas alquilar: "
                + "\n 1- Velero "
                + "\n 2- Barco a motor "
                + "\n 3- Yate");
        int input = leer.nextInt();        
        
        switch(input){
            case 1:
                VeleroService vs = new VeleroService();
                Velero velero = vs.crearVelero(alquiler);
                System.out.println("El velero disponible es: "+alquiler.getBarco()+" "+velero);
                System.out.println("Valor alquiler: $"+String.format("%,d", (int)vs.calcularValorAlquiler(alquiler)));   
                break;
            case 2:
                BarcoaMotorService ms = new BarcoaMotorService();
                BarcoaMotor motorizado = new BarcoaMotor();  
                ms.moduloMotorizado(alquiler);
                ms.calcularValorAlquiler(alquiler);
                break;
            case 3:
                YatesLujoService ys = new YatesLujoService();
                ys.moduloYate(alquiler);
                ys.calcularValorAlquiler(alquiler);
                break;
            default:
                System.out.println("Opción no válida");
                
        }           
                
              
    }
    
}
