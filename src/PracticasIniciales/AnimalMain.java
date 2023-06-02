/*
Vamos a crear una clase Animal que tenga un método hacerRuido() que devuelva un saludo
“Hola”. Luego haremos clase Perro y clase Gato que extiendan de Animal y sobreescriban el
método hacerRuido() con el ruido que corresponda a cada uno. Luego, en el main vamos a crear
un ArrayList de animales y los siguientes animales
Animal a = new Animal();
Animal b = new Perro();
Animal c = new Gato();
Agregaremos a la lista a cada uno y luego, con un for each, recorreremos la lista llamando al
método hacerRuido() de cada ítem.
 */
package PracticasIniciales;

import java.util.ArrayList;

/**
 *
 * @author AlejaDevelops
 */
public class AnimalMain {

    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Perro();
        Animal c = new Gato();
        
        ArrayList<Animal> animales = new ArrayList();
        animales.add(a);
        animales.add(b);
        animales.add(c);
        
        
        for (Animal aux : animales) {
           aux.hacerRuido();
        }
        
        //Interfase inter = new Interface();
    }

}
