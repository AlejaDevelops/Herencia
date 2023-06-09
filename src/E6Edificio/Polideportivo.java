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
(suponiendo que en cada piso hay una oficina). Crear el método cantPersonas(), que muestre
cuantas personas entrarían en un piso y cuantas en todo el edificio.
Por último, en el main vamos a crear un ArrayList de tipo Edificio. El ArrayList debe contener
dos polideportivos y dos edificios de oficinas. Luego, recorrer este array y ejecutar los
métodos calcularSuperficie y calcularVolumen en cada Edificio. Se deberá mostrar la
superficie y el volumen de cada edificio.
Además de esto, para la clase Polideportivo nos interesa saber cuántos polideportivos son
techados y cuantos abiertos. Y para la clase EdificioDeOficinas deberemos llamar al método
cantPersonas() y mostrar los resultados de cada edificio de oficinas.
 */
package E6Edificio;

import java.util.Random;

/**
 *
 * @author AlejaDevelops
 */
public class Polideportivo extends Edificio {

    private String nombre;
    private String tipoDeInstalacion;

    public Polideportivo() {
    }

    public Polideportivo(double ancho, double alto, double largo) {
        super(ancho, alto, largo);
        super.ancho = r.nextInt(15) + 5;
        super.alto = r.nextInt(40) + 5;
        super.largo = r.nextInt(20) + 10; 
        this.nombre = crearNombre();
        this.tipoDeInstalacion = crearTipoDeInstalacion();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDeInstalacion() {
        return tipoDeInstalacion;
    }

    public void setTipoDeInstalacion(String tipoDeInstalacion) {
        this.tipoDeInstalacion = tipoDeInstalacion;
    }

    @Override
    public String toString() {
        return "Polideportivo{" + "nombre=" + nombre + ", tipoDeInstalacion=" + tipoDeInstalacion + '}';
    }

    //Metodos
  
    
    public String crearNombre() {
        String[] nombres = {"Estadio Nacional", "Centenario Arena", "Camp Nou", "Maracaná", "Wembley Stadium", "Old Trafford", "Santiago Bernabéu", "San Siro", "Allianz Arena", "Emirates Stadium"};
        String nombre = nombres[r.nextInt(nombres.length)];
        return nombre;
    }

    public String crearTipoDeInstalacion() {
        String[] tipos = {"Techado", "Abierto"};
        String tipo = tipos[r.nextInt(tipos.length)];
        return tipo;
    }

    @Override
    public void calcularVolumen() {        
        System.out.println("Volúmen edificación: " +getAlto() * getAncho() * getLargo()+"m3");
        
    }

    @Override
    public void calcularSuperficie() {
        System.out.println("Superficie: " +getAncho() * getLargo()+"m2");        
    }

    
}
