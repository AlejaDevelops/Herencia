/*
Se plantea desarrollar un programa que nos permita calcular el área y el perímetro de formas
geométricas, en este caso un círculo y un rectángulo. Ya que este cálculo se va a repetir en las
dos formas geométricas, vamos a crear una Interfaz, llamada calculosFormas que tendrá, los
dos métodos para calcular el área, el perímetro y el valor de PI como constante.
Desarrollar el ejercicio para que las formas implementen los métodos de la interfaz y se
calcule el área y el perímetro de los dos. En el main se crearán las formas y se mostrará el
resultado final.
Área circulo: PI * radio ^ 2 / Perímetro circulo: PI * diámetro.
Área rectángulo: base * altura / Perímetro rectángulo: (base + altura) * 2.
 */
package E4FormasGeometricas;

/**
 *
 * @author AlejaDevelops
 */
public class FormasGeometricasMain {

    
    public static void main(String[] args) {
        Rectangulo rectangulo = new Rectangulo();
        rectangulo.crearRectangulo();
        System.out.println("El área del rectangulo es: "+rectangulo.calcularArea());
        System.out.println("El perímetro del rectangulo es: "+rectangulo.calcularPerimetro());
        System.out.println(" ");
        Circulo circulo = new Circulo();
        circulo.crearCirculo();
        System.out.println("El área del circulo es: "+circulo.calcularArea());
        System.out.println("El perímetro del circulo es: "+circulo.calcularPerimetro());
    }
    
}
