/*
Tenemos una clase padre Animal junto con sus 3 clases hijas Perro, Gato, Caballo.
La clase Animal tendrá como atributos el nombre, alimento, edad y raza del Animal.
Crear un método en la clase Animal a través del cual cada clase hija deberá mostrar luego un
mensaje por pantalla informando de que se alimenta. Generar una clase Main que realice lo
siguiente:
 */
package E1Animales;

import java.util.ArrayList;

/**
 *
 * @author AlejaDevelops
 */
public class AnimalesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Perro perro1 = new Perro("Pepe", "Dieta BARF", 15, "Doberman");
        Perro perro2 = new Perro("Firulais", "Croquetas", 8, "Criollo");
        Gato gato = new Gato("Gato con botas", "Pescado", 4, "Criollo");
        Caballo caballo = new Caballo("Rocinante", "Heno", 15, "Fino");

        ArrayList<Animal> animales = new ArrayList();
        animales.add(perro1);
        animales.add(perro2);
        animales.add(gato);
        animales.add(caballo);

        for (Animal aux : animales) {
            aux.alimento();
        }
    }

}
