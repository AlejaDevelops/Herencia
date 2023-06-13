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
import java.util.Random;

/**
 *
 * @author AlejaDevelops
 */
public class AlojamientosService {

    Random r = new Random();

    public Alojamientos crearAlojamiento() {
        Alojamientos alojamiento = new Alojamientos();
        alojamiento.setNombre(crearNombre());
        alojamiento.setDireccion(crearDireccion());
        alojamiento.setLocalidad(crearLocalidad());
        alojamiento.setNombreGerente(crearNombreGerente());

        return alojamiento;
    }

    public String crearNombre() {
        String[] nombresHoteles = {"Hotel Plaza", "Grand Hyatt", "Marriott Resort", "Hilton Garden Inn", "Ritz Carlton", "Holiday Inn", "Sheraton Suites", "Radisson Blu", "Four Seasons", "The Westin", "InterContinental", "Motel 6", "Fairmont Hotel", "Hyatt Regency", "DoubleTree by Hilton", "Park Plaza", "Hotel Indigo", "Best Western", "Mandarin Oriental", "The Peninsula"};
        String nombre = nombresHoteles[r.nextInt(nombresHoteles.length)];
        return nombre;
    }

    public String crearDireccion() {
        String[] direcciones = {"Calle 10 #25-12", "Avenida Principal #45-10", "Carrera 7 #15-30", "Calle 23 #18-5", "Avenida Central #70-22", "Carrera 12 #8-14", "Calle 35 #40-11", "Avenida Norte #17-9", "Carrera 9 #12-6", "Calle 14 #30-8", "Avenida Sur #25-17", "Carrera 6 #11-3", "Calle 28 #16-20", "Avenida Este #48-7", "Carrera 11 #22-14", "Calle 20 #33-9", "Avenida Oeste #60-12", "Carrera 8 #19-4", "Calle 32 #27-15", "Avenida Central #50-6"};
        String direccion = direcciones[r.nextInt(direcciones.length)];
        return direccion;
    }
    
    public String crearLocalidad(){
        String[] localidadesBogota = { "Usaquén", "Chapinero", "Santa Fe", "San Cristóbal", "Usme", "Tunjuelito", "Bosa", "Kennedy", "Fontibón", "Engativá", "Suba", "Barrios Unidos", "Teusaquillo", "Los Mártires", "Antonio Nariño", "Puente Aranda", "La Candelaria", "Rafael Uribe Uribe", "Ciudad Bolívar", "Sumapaz" };
        String localidad = localidadesBogota[r.nextInt(localidadesBogota.length)];
        return localidad;
    }
    
    public String crearNombreGerente(){
        String[] nombresGerentes = { "Sofía García", "Mateo López", "Isabella Martínez", "Luis González", "Valentina Rodríguez", "Sebastián Fernández", "Mariana Pérez", "Diego Sánchez", "Camila Torres", "Samuel Ramírez", "Lucía Romero", "Daniel Herrera", "Valeria Jiménez", "Juan Silva", "Ana Morales", "Pedro Ortega", "Gabriela Castro", "Andrés Vargas", "Carolina Ríos", "Alejandro Mendoza" };
        String nombreGerente = nombresGerentes[r.nextInt(nombresGerentes.length)];
        return nombreGerente;
    }

}
