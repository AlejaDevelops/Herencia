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
public class Circulo implements CalculosFormas {
    public final double pi = Math.PI;
    private double r;
    
    public void crearCirculo(){
        System.out.println("Cuál es el radio del circulo");
        r = leer.nextDouble();
    }

    @Override
    public double calcularArea() {        
        return pi * Math.pow(r, 2);
    }

    @Override
    public double calcularPerimetro() {        
        return pi * 2 * r;
    }

}
