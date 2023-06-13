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

import E7SistemaDeConsultaDeAlojamientos.Hotel;
import E7SistemaDeConsultaDeAlojamientos.Hotel4Estrellas;

/**
 *
 * @author AlejaDevelops
 */
public class Hotel4EstrellasService extends HotelService {

    public Hotel4Estrellas crearHotel4Estrellas() {
        Hotel4Estrellas hotel4 = new Hotel4Estrellas();
        hotel4.setGimnasio(r.nextBoolean());
        hotel4.setClasificacionGim(clasificacionGim(hotel4));
        hotel4.setNombreRestaurante(crearNombreRestaurante());
        hotel4.setCapacidadRestaurante(r.nextInt(100) + 15);  

        Hotel hotel = super.crearHotel();
        hotel4.setCantHab(hotel.getCantHab());
        hotel4.setNumCamasTotal(hotel.getNumCamasTotal());
        hotel4.setCantPisos(hotel.getCantPisos());        
        hotel4.setPrecioHab(calcularPrecioHabitacion(hotel4));
        hotel4.setNombre(hotel.getNombre());
        hotel4.setDireccion(hotel.getDireccion());
        hotel4.setLocalidad(hotel.getLocalidad());
        hotel4.setNombreGerente(hotel.getNombreGerente());        
 
        return hotel4;
    }

    public String crearNombreRestaurante() {
        String[] nombres = {"El Bistro Delicioso", "La Cantina Sabrosa", "Sabor Latino", "El Rincón Gourmet", "La Trattoria Bella", "Tacos y Tequila", "The Spice Market", "La Pizzería Mamma Mia", "Fusion Asia", "El Asador Argentino"};
        String nombre = nombres[r.nextInt(nombres.length)];
        return nombre;
    }

    public char clasificacionGim(Hotel4Estrellas hotel4) {
        char x;
        if (hotel4.isGimnasio()) {
            x = (char) (r.nextInt(2) + 'A');
        } else {
            x = '-'; //Clasificación vacía
        }
        return x;
    }

    public double calcularPrecioHabitacion(Hotel4Estrellas hotel4) {
        int valorAgregadoPorRestaurante = 0;
        int valorAgregadoPorGimnasio = 0;

        if (hotel4.getCapacidadRestaurante() < 30) {
            valorAgregadoPorRestaurante = 10;
        } else if (hotel4.getCapacidadRestaurante() >= 30 && hotel4.getCapacidadRestaurante() <= 50) {
            valorAgregadoPorRestaurante = 30;
        } else if (hotel4.getCapacidadRestaurante() > 50) {
            valorAgregadoPorRestaurante = 50;
        }

        if ("A".equals(hotel4.getClasificacionGim())) {
            valorAgregadoPorGimnasio = 50;
        } else if ("B".equals(hotel4.getClasificacionGim())) {
            valorAgregadoPorGimnasio = 30;
        }

        double precio = 50 + (1 * hotel4.getCantHab()) + valorAgregadoPorRestaurante + valorAgregadoPorGimnasio; //Asumiendo que le capacidad del hotel es el numero de habitaciones totales
        
        return precio;
    }

}
