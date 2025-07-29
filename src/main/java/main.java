import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class main {
    public static void main(String[] args) {
        // Almacenar en variables la información de un producto
        /*
        - IDProducto
        - nombreProducto
        - precioUnitarioProducto
        - cantidadBodegaProducto
        - caducidadProducto
        - fechaVencimientoProducto
        - fotografiaUnoProducto
        - fotografiaDosProducto
        - descripcionProducto
        - categoriaProducto
        - nombreProvedorProducto
        */

        // SI el Producto se vence y han pasado más de 3 días desde la fecha de vencimiento
        // Se debe restar la unidad vencida a la cantidad de bodega

        // Se debe permitir registrar N productos en una BD simulada en JAVA

        // Se debe permitir modificar el precioUnitarioProducto de cualquier producto ingresado previamente

        // Se debe permitir eliminar un producto de la bodega


        System.out.println("\n SUPERMERCADO LA MAYORÍA");

        String uniqueID = UUID.randomUUID().toString();

        String IDProducto;
        String nombreProducto;
        Integer precioUnitarioProducto;

/*
        //Trabajando con listas de Arrays
        ArrayList<String> papelesDeluxe = new ArrayList<>();

        //Agregando Elementos a un arreglo
        papelesDeluxe.add(uniqueID); //0
        papelesDeluxe.add(uniqueID); //1
        papelesDeluxe.add(uniqueID); //2
        System.out.println(papelesDeluxe.get(0));
 */

       /*
        String[] Palabra = new String[3];
        String[] Palabras = {"Juan","Pepe","Camilo"};

        Palabras[0] = "Laura";

        System.out.println(Palabras[0]);
*/

/*
        //Trabajando con diccionarios
        // Rojo Con el Object se pueden usar distintos tipos de dato
        HashMap<String, Object> usuario1 = new HashMap<>();

        //Agregando elementos a un diccionaro
        usuario1.put("Nombre", "Maria");
        usuario1.put("Edad", 30);
        usuario1.put("RH", "O+");
        usuario1.put("Altura", "1.70");
        usuario1.put("Peso", 50);

        // se tiene que Gettear según la Key
        System.out.println(usuario1);
*/

        /*
        //Uniendo las dos vainas
        // Se crea el Array List De EstudianteSSSSSSSSSSSSSSS
        ArrayList<Object> estudiantes = new ArrayList<>();

        HashMap<String,Object> estudiante1 = new HashMap<>();
        HashMap<String,Object> estudiante2 = new HashMap<>();


        estudiante1.put("id",uniqueID);
        estudiante1.put("nombre", "Andrea Insignares");

        estudiante2.put("id",uniqueID);
        estudiante2.put("nombre", "Ese Huevo Quiere sal");

        estudiantes.add(estudiante1);
        estudiantes.add(estudiante2);

        System.out.println(estudiantes);
         */

        /*
        //Chimbeando con Fechas
        LocalDate fechaInicial = LocalDate.now();
        LocalDate fechaFinal = LocalDate.of(2006, 10, 20);
        Period diferencia = Period.between(fechaInicial, fechaFinal);

        System.out.println(diferencia.getYears());
        System.out.println(diferencia.getMonths());
        System.out.println(diferencia.getDays());
        */

    }
}
