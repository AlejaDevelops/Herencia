/*
Una compañía de promociones turísticas desea mantener información sobre la infraestructura
de alojamiento para turistas, de forma tal que los clientes puedan planear sus vacaciones de
acuerdo con sus posibilidades. Los alojamientos se identifican por un nombre, una dirección,
una localidad y un gerente encargado del lugar. La compañía trabaja con dos tipos de
alojamientos: Hoteles y Alojamientos Extrahoteleros.
Los Hoteles tienen como atributos: Cantidad de Habitaciones, Número de Camas, Cantidad de
Pisos, Precio de Habitaciones. Y estos pueden ser de cuatro o cinco estrellas. Las
características de las distintas categorías son las siguientes:
• Hotel **** Cantidad de Habitaciones, Número de camas, Cantidad de Pisos, Gimnasio,
Nombre del Restaurante, Capacidad del Restaurante, Precio de las Habitaciones.
• Hotel ***** Cantidad de Habitaciones, Número de camas, Cantidad de Pisos, Gimnasio,
Nombre del Restaurante, Capacidad del Restaurante, Cantidad Salones de
Conferencia, Cantidad de Suites, Cantidad de Limosinas, Precio de las Habitaciones.
Los gimnasios pueden ser clasificados por la empresa como de tipo “A” o de tipo “B”, de
acuerdo a las prestaciones observadas. Las limosinas están disponibles para cualquier
cliente, pero sujeto a disponibilidad, por lo que cuanto más limosinas tenga el hotel, más caro
será.
El precio de una habitación debe calcularse de acuerdo con la siguiente fórmula:
PrecioHabitación = $50 + ($1 x capacidad del hotel) + (valor agregado por restaurante) + (valor
agregado por gimnasio) + (valor agregado por limosinas).
Donde:
Valor agregado por el restaurante:
• $10 si la capacidad del restaurante es de menos de 30 personas.
• $30 si está entre 30 y 50 personas.
• $50 si es mayor de 50.
Valor agregado por el gimnasio:
• $50 si el tipo del gimnasio es A.
• $30 si el tipo del gimnasio es B.
Valor agregado por las limosinas:
• $15 por la cantidad de limosinas del hotel.
En contraste, los Alojamientos Extra hoteleros proveen servicios diferentes a los de los
hoteles, estando más orientados a la vida al aire libre y al turista de bajos recursos. Por cada
Alojamiento Extrahotelero se indica si es privado o no, así como la cantidad de metros
cuadrados que ocupa. Existen dos tipos de alojamientos extrahoteleros: los Camping y las
Residencias. Para los Camping se indica la capacidad máxima de carpas, la cantidad de baños
disponibles y si posee o no un restaurante dentro de las instalaciones. Para las residencias se
indica la cantidad de habitaciones, si se hacen o no descuentos a los gremios y si posee o no
campo deportivo. Realizar un programa en el que se representen todas las relaciones
descriptas.
Realizar un sistema de consulta que le permite al usuario consultar por diferentes criterios:
• todos los alojamientos.
• todos los hoteles de más caro a más barato.
• todos los campings con restaurante
• todos las residencias que tienen descuento.
 */
package E7SistemaDeConsultaDeAlojamientosService;

import E7SistemaDeConsultaDeAlojamientos.Alojamientos;
import E7SistemaDeConsultaDeAlojamientos.Camping;
import E7SistemaDeConsultaDeAlojamientos.Hotel;
import E7SistemaDeConsultaDeAlojamientos.Hotel4Estrellas;
import E7SistemaDeConsultaDeAlojamientos.Hotel5Estrellas;
import E7SistemaDeConsultaDeAlojamientos.Residencias;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author AlejaDevelops
 */
public class SistemaConsultaAlojamientosService {

    Random r = new Random();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public ArrayList<Alojamientos> crearListaDeAlojamientos() {
        ArrayList<Alojamientos> listaAlojamientos = new ArrayList();

        int n = r.nextInt(20) + 5; //Creación y adición a listaHoteles de n hoteles 4 estrellas
        for (int i = 0; i < n; i++) {
            Hotel4EstrellasService h4es = new Hotel4EstrellasService();
            Hotel4Estrellas hotel4 = h4es.crearHotel4Estrellas();
            listaAlojamientos.add(hotel4);
        }

        n = r.nextInt(20) + 5; //Creación y adición a listaHoteles de n hoteles 5 estrellas
        for (int i = 0; i < n; i++) {
            Hotel5EstrellasService h5es = new Hotel5EstrellasService();
            Hotel5Estrellas hotel5 = h5es.crearHotel5Estrellas();
            listaAlojamientos.add(hotel5);
        }

        n = r.nextInt(15) + 5; //Creación y adición a listaAlojamientosExtraH de n Camping        
        for (int i = 0; i < n; i++) {
            CampingService cs = new CampingService();
            Camping camping = cs.crearCamping();
            listaAlojamientos.add(camping);
        }

        n = r.nextInt(15) + 5; //Creación y adición a listaAlojamientosExtraH de n Residencias        
        for (int i = 0; i < n; i++) {
            ResidenciasService rs = new ResidenciasService();
            Residencias residencia = rs.crearResidencia();
            listaAlojamientos.add(residencia);
        }
        return listaAlojamientos;
    }

    public void consultarTodosLosAlojamientos(ArrayList<Alojamientos> listaAlojamientos) {
        for (Alojamientos aux : listaAlojamientos) {
            if (aux instanceof Hotel4Estrellas && !(aux instanceof Hotel5Estrellas)) {
                System.out.println("Hotel 4 estrellas" + aux + "\n Precio por habitación: $" + ((Hotel4Estrellas) aux).getPrecioHab());
                System.out.println("-----------------------------------");
            } else{ 
                System.out.println(aux);
                System.out.println("-----------------------------------");
            }
        }
    }

    public void consultarCampingConRestaurante(ArrayList<Alojamientos> listaAlojamientos) {
        System.out.println("Los campings con restaurantes son: ");
        for (Alojamientos aux : listaAlojamientos) {
            if (aux instanceof Camping) {
                if (((Camping) aux).isTieneRestaurante()) {
                    System.out.println(aux);
                    System.out.println("-----------------------------------");
                }

            }
        }
    }

    public void consultarResidenciasDescuento(ArrayList<Alojamientos> listaAlojamientos) {
        System.out.println("Las residencias que aplican descuentos a gremios son: ");
        for (Alojamientos aux : listaAlojamientos) {
            if (aux instanceof Residencias) {
                if (((Residencias) aux).isTieneDescuentoParaGremios()) {
                    System.out.println(aux);
                    System.out.println("-----------------------------------");
                }
            }
        }
    }

    public void MostrarHotelesOrdenadosPorPrecio(ArrayList<Alojamientos> listaAlojamientos) {
        ArrayList<Hotel> listaHoteles = new ArrayList();

        for (Alojamientos auxAloja : listaAlojamientos) {
            if (auxAloja instanceof Hotel) {
                listaHoteles.add((Hotel) auxAloja);
            }
        }

        Comparator<Hotel> priceComparator = new Comparator<Hotel>() {
            @Override
            public int compare(Hotel hotel1, Hotel hotel2) {
                if (hotel1.getPrecioHab() < hotel2.getPrecioHab()) {
                    return -1;
                } else if (hotel1.getPrecioHab() > hotel2.getPrecioHab()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        Collections.sort(listaHoteles, priceComparator);
        for (Hotel aux : listaHoteles) {
            if (aux instanceof Hotel4Estrellas && !(aux instanceof Hotel5Estrellas)) {
                System.out.println("Hotel 4 estrellas" + aux + "\n Precio por habitación: $" + aux.getPrecioHab());
                System.out.println("-----------------------------------");
            } else {
                System.out.println(aux);
                System.out.println("-----------------------------------");
            }

        }

    }

    public void menu() {
        System.out.println("*** Bienvenido al sistema de consulta de hospedaje de la agencia Viajes la Vuelta al Mundo ***\n");
        int input = 0;
        System.out.println("Se está cargando la lista de alojamientos disponibles...\n");
        ArrayList<Alojamientos> listaAlojamientos = crearListaDeAlojamientos();

        do {
            System.out.println("Elige una opción de acuerdo al siguiente menú: "
                    + "\n 1- Consultar todos los hoteles y alojamientos disponibles"
                    + "\n 2- Consultar hoteles ordenados por precio"
                    + "\n 3- Consultar campings con restaurante"
                    + "\n 4- Consultar residencias que aplican descuento a gremios"
                    + "\n 5- Salir");
            input = leer.nextInt();

            switch (input) {
                case 1:
                    consultarTodosLosAlojamientos(listaAlojamientos);
                    break;
                case 2:
                    MostrarHotelesOrdenadosPorPrecio(listaAlojamientos);
                    break;
                case 3:
                    consultarCampingConRestaurante(listaAlojamientos);
                    break;
                case 4:
                    consultarResidenciasDescuento(listaAlojamientos);
                    break;
                case 5:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Opción no válida, intenta nuevamente");
            }

        } while (input != 5);

    }
}
