/*
 Crear una superclase llamada Edificio con los siguientes atributos: ancho, alto y largo. La clase
edificio tendrá como métodos:
• Método calcularSuperficie(): calcula la superficie del edificio.
• Método calcularVolumen(): calcula el volumen del edifico.
Estos métodos serán abstractos y los implementarán las siguientes clases:
• Clase Polideportivo con su nombre y tipo de instalación que puede ser Techado o
Abierto, esta clase implementará los dos métodos abstractos y los atributos del padre.
• Clase EdificioDeOficinas con sus atributos número de oficinas, cantidad de personas
por oficina y número de pisos. Esta clase implementará los dos métodos abstractos y
los atributos del padre.
De esta clase nos interesa saber cuántas personas pueden trabajar en todo el edificio, el
usuario dirá cuántas personas entran en cada oficina, cuantas oficinas y el número de piso
(suponiendo que en cada piso hay una oficina). 


Crear el método cantPersonas(), que muestre
cuantas personas entrarían en un piso y cuantas en todo el edificio.

Por último, en el main vamos a crear un ArrayList de tipo Edificio. El ArrayList debe contener
dos polideportivos y dos edificios de oficinas. Luego, recorrer este array y ejecutar los
métodos calcularSuperficie y calcularVolumen en cada Edificio. Se deberá mostrar la
superficie y el volumen de cada edificio.Además de esto, para la clase Polideportivo nos interesa saber cuántos polideportivos son
techados y cuantos abiertos. Y para la clase EdificioDeOficinas deberemos llamar al método
cantPersonas() y mostrar los resultados de cada edificio de oficinas.
 */
package E6Edificio;

import java.util.ArrayList;

/**
 *
 * @author AlejaDevelops
 */
public class EdificioMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Edificio> listaEdificios = new ArrayList();
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < 2; i++) {
            listaEdificios.add(new Polideportivo(0, 0, 0));
            listaEdificios.add(new EdificioDeOficinas(0, 0, 0));
        }

        for (Edificio aux : listaEdificios) {

            if (aux instanceof Polideportivo) {
                System.out.println("Datos del polideportivo");
                System.out.println("Nombre: " + ((Polideportivo) aux).getNombre());
                System.out.println("Tipo de instalación: "+((Polideportivo) aux).getTipoDeInstalacion());
                aux.calcularSuperficie();
                aux.calcularVolumen();
                if (((Polideportivo) aux).getTipoDeInstalacion().equalsIgnoreCase("Techado")) {
                    n++;
                } else {
                    n2++;
                }
            }
            if (aux instanceof EdificioDeOficinas) {
                System.out.println("Datos del edificio de oficinas");
                aux.calcularSuperficie();
                aux.calcularVolumen();
                ((EdificioDeOficinas) aux).cantPersonas();

            }
            System.out.println("------------------------------------------");
        }
        System.out.println("------------------------------------------");
        System.out.println("La cantidad de Polideportivos techados es: " + n);
        System.out.println("La cantidad de Polideportivos abiertos es: " + n);

    }

}
