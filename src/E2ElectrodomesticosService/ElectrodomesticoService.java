/*
Crear una superclase llamada Electrodoméstico con los siguientes atributos: precio, color,
consumo energético (letras entre A y F) y peso.
Los constructores que se deben implementar son los siguientes:
• Un constructor vacío.
• Un constructor con todos los atributos pasados por parámetro.
Los métodos a implementar son:
• Métodos getters y setters de todos los atributos.
• Método comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta,
sino es correcta usara la letra F por defecto. Este método se debe invocar al crear el
objeto y no será visible.
• Método comprobarColor(String color): comprueba que el color es correcto, y si no lo es,
usa el color blanco por defecto. Los colores disponibles para los electrodomésticos son
blanco, negro, rojo, azul y gris. No importa si el nombre está en mayúsculas o en
minúsculas. Este método se invocará al crear el objeto y no será visible.
* Metodo crearElectrodomestico(): le pide la información al usuario y llena el
electrodoméstico, también llama los métodos para comprobar el color y el consumo. Al
precio se le da un valor base de $1000.
• Método precioFinal(): según el consumo energético y su tamaño, aumentará el valor del
precio. Esta es la lista de precios:

************************

A continuación, se debe crear una subclase llamada Lavadora, con el atributo carga,
además de los atributos heredados.
Los constructores que se implementarán serán:
• Un constructor vacío.
• Un constructor con la carga y el resto de los atributos heredados. Recuerda que debes
llamar al constructor de la clase padre.
Los métodos que se implementara serán:
• Método get y set del atributo carga.
• Método crearLavadora (): este método llama a crearElectrodomestico() de la clase
padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
el atributo propio de la lavadora.
• Método precioFinal(): este método será heredado y se le sumará la siguiente
funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500, si la
carga es menor o igual, no se incrementará el precio. Este método debe llamar al
método padre y añadir el código necesario. Recuerda que las condiciones que hemos
visto en la clase Electrodoméstico también deben afectar al precio.
Se debe crear también una subclase llamada Televisor con los siguientes atributos:
resolución (en pulgadas) y sintonizador TDT (booleano), además de los atributos
heredados.
Los constructores que se implementarán serán:
• Un constructor vacío.
• Un constructor con la resolución, sintonizador TDT y el resto de los atributos
heredados. Recuerda que debes llamar al constructor de la clase padre.
Los métodos que se implementara serán:
• Método get y set de los atributos resolución y sintonizador TDT.
• Método crearTelevisor(): este método llama a crearElectrodomestico() de la clase
padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
los atributos del televisor.
• Método precioFinal(): este método será heredado y se le sumará la siguiente
funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
incrementará el precio un 30% y si tiene un sintonizador TDT incorporado, aumentará
$500. Recuerda que las condiciones que hemos visto en la clase Electrodomestico
también deben afectar al precio.
Finalmente, en el main debemos realizar lo siguiente:
Vamos a crear una Lavadora y un Televisor y llamar a los métodos necesarios para mostrar
el precio final de los dos electrodomésticos.
 */
package E2ElectrodomesticosService;

import E2Electrodomesticos.Electrodomestico;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class ElectrodomesticoService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public double asignarPrecioConsumoEnergetico(char letra) {
        double precio = 0;
        switch (letra) {
            case 'A':
                precio = 1000;
                break;
            case 'B':
                precio = 800;
                break;
            case 'C':
                precio = 600;
                break;
            case 'D':
                precio = 500;
                break;
            case 'E':
                precio = 300;
                break;
            case 'F':
                precio = 100;
                break;
            default:
                precio = 100;
        }

        return precio;
    }
    
    public double asignarPrecioPeso(double peso){
        double precioPeso = 0;
        if (peso>=1 && peso<=19) {
            precioPeso = 100;            
        }
        if (peso>=20 && peso<=49) {
            precioPeso = 500;            
        }
        if (peso>=50 && peso<=79) {
            precioPeso = 800;            
        }
        if (peso>80) {
            precioPeso = 1000;            
        }
        return precioPeso;
    }

    public String comprobarColor(String color) {
        List<String> coloresDisponibles = Arrays.asList("blanco", "negro", "rojo", "azul", "gris");
        if (!coloresDisponibles.contains(color.toLowerCase())) {
            System.out.println("El color ingresado no está disponible. Se asignará el color blanco");
            color = "blanco";
        }
        return color;
    }
    
    public char comprobarConsumoEnergetico(char letra){
        List<Character> letrasDisponibles = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');
        if (!letrasDisponibles.contains(Character.toLowerCase(letra))) {
            System.out.println("La letra ingresada no está disponible. Se asignará la letra F");
            letra = 'F';
        }
        return letra;
    }
    
    public Electrodomestico crearElectrodomestico(){
        Electrodomestico electro = new Electrodomestico();        
        electro.setPrecio(1000); //Precio base
        System.out.println("Ingresa la letra del consumo: ");
        char letra = leer.next().charAt(0);        
        electro.setConsumoEnergetico(comprobarConsumoEnergetico(letra));
        System.out.println("Ingresa el color deseado: ");
        String color = leer.next();                 
        electro.setColor(comprobarColor(color));
        System.out.println("Ingresa el peso en kilogramos: ");
        double peso = leer.nextDouble();
        electro.setPeso(peso);
        return electro;
        
    }
    
    public Electrodomestico precioFinal(Electrodomestico electro){
        
        double pce = asignarPrecioConsumoEnergetico(electro.getConsumoEnergetico());
        electro.setPrecio(electro.getPrecio()+pce);
        double pp = asignarPrecioPeso(electro.getPeso());
        electro.setPrecio(electro.getPrecio()+pp);
        
        return electro;
    }
    
    public void imprimirElectro(Electrodomestico electro){
        System.out.println(electro);
    }
    
}
