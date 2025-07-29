import java.time.temporal.ChronoUnit;
import java.util.*;
import misUtilidades.*;
import java.time.*;


public class supermercadoSencillo {

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

    // Si el Producto se vence y han pasado más de 3 días desde la fecha de vencimiento ✅

    // Se debe restar la unidad vencida a la cantidad de bodega ✅

    // Se debe permitir registrar N productos en una BD simulada en JAVA ✅

    // Se debe permitir modificar el precioUnitarioProducto de cualquier producto ingresado previamente ✅

    // Se debe permitir eliminar un producto de la bodega ✅

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UUID idAleatorio = UUID.randomUUID();

        System.out.println(
                """
                         ▄█▀▀▀▄█                                                                                   ▀██            \s
                         ██▄▄  ▀  ▄▄▄ ▄▄▄  ▄▄▄ ▄▄▄    ▄▄▄▄  ▄▄▄ ▄▄  ▄▄ ▄▄ ▄▄     ▄▄▄▄  ▄▄▄ ▄▄    ▄▄▄▄   ▄▄▄▄     ▄▄ ██    ▄▄▄     \s
                          ▀▀███▄   ██  ██   ██▀  ██ ▄█▄▄▄██  ██▀ ▀▀  ██ ██ ██  ▄█▄▄▄██  ██▀ ▀▀ ▄█   ▀▀ ▀▀ ▄██  ▄▀  ▀██  ▄█  ▀█▄   \s
                        ▄     ▀██  ██  ██   ██    █ ██       ██      ██ ██ ██  ██       ██     ██      ▄█▀ ██  █▄   ██  ██   ██   \s
                        █▀▄▄▄▄█▀   ▀█▄▄▀█▄  ██▄▄▄▀   ▀█▄▄▄▀ ▄██▄    ▄██ ██ ██▄  ▀█▄▄▄▀ ▄██▄     ▀█▄▄▄▀ ▀█▄▄▀█▀ ▀█▄▄▀██▄  ▀█▄▄█▀   \s
                                            ██                                                                                    \s
                                           ▀▀▀▀                                                                                   \s
                        """);

        System.out.println("""
                ▀██▀                 ▀██▀  ▀█▀                            ██    ▄          \s
                 ██        ▄▄▄▄       ▀█▄  ▄▀   ▄▄▄▄     ▄▄▄ ▄  ▄▄▄ ▄▄▄  ▄▄▄  ▄██▄   ▄▄▄▄  \s
                 ██       ▀▀ ▄██       ██  █   ▀▀ ▄██  ▄▀   ██   ██  ██   ██   ██   ▀▀ ▄██ \s
                 ██       ▄█▀ ██        ███    ▄█▀ ██  █▄   ██   ██  ██   ██   ██   ▄█▀ ██ \s
                ▄██▄▄▄▄▄█ ▀█▄▄▀█▀        █     ▀█▄▄▀█▀ ▀█▄▄▀██   ▀█▄▄▀█▄ ▄██▄  ▀█▄▀ ▀█▄▄▀█▀\s
                                                            ██                             \s
                                                           ▀▀▀▀                            \s
                """);

        System.out.println(
                """
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⡟⠷⢦⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡶⢶⡦⣄⡀⠀⠀⠀⢀⣤⠞⠻⠛⠃⠀⠈⠛⢦⡀⠀⠀⠀⠀⠀⢀⣀⣀⡀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠉⠒⠬⢍⡉⠉⣹⠃⠀⠀⠀⠀⠀⠀⠀⠀⢹⠒⢶⣶⡾⠛⠛⠁⠀⠙
                        ⠀⠀⠀⠀⠀⠀⠀⢀⣠⠾⠋⠉⠉⠉⠛⠲⠤⢤⣀⣀⣀⡘⣧⡀⠀⠀⠀⠀⠈⣹⠁⠀⠀⠀⠀⠀⠀⠀⢀⠀⠸⡦⠊⠁⠀⠀⠀⠀⢄⡼
                        ⠀⠀⠀⢀⣀⡤⠶⠿⠅⠀⢀⠀⠔⠊⠀⠀⠀⠀⠀⠀⠈⠉⠙⠛⠮⣄⣀⣠⣼⣧⡄⠀⠀⠀⠆⠀⠀⣤⣼⠲⣄⢀⡀⢀⣀⣤⣤⠴⠋⠀
                        ⠀⠀⢀⡟⠁⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢘⣧⠀⠀⠀⠀⠀⠀⠉⠀⢰⠃⠈⠉⠉⠉⠁⠀⠀⠀⠀
                        ⠀⠀⣸⠁⠀⠀⡰⠁⠀⠀⠀⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡴⠀⠀⠀⠀⠀⣸⠃⠀⠀⠀⠀⠀⠁⠀⠀⣼⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⢰⣿⠀⠀⣰⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠞⠀⠀⠀⠀⠀⣰⡃⠀⠀⠀⠀⠀⠀⠀⢀⣴⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⢠⠇⣿⠀⢠⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠎⠀⠀⠀⠀⠀⠀⢿⢻⡍⢠⡄⠀⠀⢠⣠⠎⣼⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⡸⢰⡏⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡏⠀⠀⠀⠀⠀⠀⠀⠈⠻⣗⣚⣿⣴⣺⠟⢁⡼⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⣇⣸⡇⠀⠸⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠀⠀⠀⢀⡔⠀⠀⠀⠀⠀⠀⠉⠉⠉⠀⢀⡞⠁⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⣇⢸⡇⠀⠀⢿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠇⠀⠀⠀⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠊⠀⠀⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⢹⣸⡇⠀⠀⠘⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠞⠁⠀⠀⠀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠈⡏⢷⠀⠀⠀⠘⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠃⠀⠀⠀⠀⣼⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠘⣼⡀⠀⠀⠀⣼⢷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠈⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⢻⡇⠀⠀⢠⢿⠀⠉⠛⢷⠶⠤⢤⣄⣀⣀⣀⣹⠰⠀⠀⠀⠀⣠⠄⠀⠀⠀⠀⠀⣀⡀⠀⢠⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⢸⠁⠀⠀⡏⢸⠀⠀⠀⡿⠀⠀⠀⠀⠀⠀⠈⠙⡇⠀⠀⠀⢰⣇⠀⠀⠀⢀⡠⢾⠉⠀⠀⣸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⢺⠀⠀⢸⠇⢸⠀⠀⣼⠃⠀⠀⠀⠀⠀⠀⠀⠀⢻⡀⠀⠀⠀⡏⠓⠦⠴⠋⠁⢸⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⢸⡄⠀⡾⠀⡞⠀⢰⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⠀⠀⠀⡇⠀⠀⠀⠀⠀⣼⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠘⠃⢀⡇⢰⠁⠀⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⢰⠃⠀⠀⠀⠀⠀⢻⠀⠀⢰⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⢀⡀⠈⣇⡸⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⢸⠀⠀⠀⠀⠀⠀⢸⡀⠀⡜⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⣼⠀⠀⢸⡇⠀⠠⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⠀⠀⢸⠀⠀⠀⠀⠀⠀⢸⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⢰⡟⠀⠀⠚⡧⣄⣀⣸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡆⠀⣼⠀⠀⠀⠀⠀⠀⣸⠀⠀⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠻⠤⠤⠖⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⢹⡀⠀⠀⠀⠀⠀⢹⡀⠀⠸⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠃⠀⠈⣇⠀⠀⠀⠀⠀⠀⣧⡀⠐⠻⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡞⠒⠀⠐⠻⡄⠀⠀⠀⠀⠀⠙⠒⠒⠊⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠳⣤⣠⠤⠴⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀""");


        System.out.println( ColoresConsola.TEXTO_MAGENTA + "\n\uD835\uDCAB\uD835\uDCC7ℯ\uD835\uDCC8\uD835\uDCBEℴ\uD835\uDCC3ℯ ℯ\uD835\uDCC3\uD835\uDCC9ℯ\uD835\uDCC7 \uD835\uDCC5\uD835\uDCB6\uD835\uDCC7\uD835\uDCB6 \uD835\uDCB8ℴ\uD835\uDCC3\uD835\uDCC9\uD835\uDCBE\uD835\uDCC3\uD835\uDCCA\uD835\uDCB6\uD835\uDCC7");
        scanner.nextLine();

        // VARIABLES

        // Menú
        byte opcionUsuario;
        boolean banderaOpciones = false;

        // HashMaps De Productos
        HashMap<String, HashMap<String, Object>> DiccionarioProductos = new HashMap<>();

        while (true) {
            // El Texto de abajo dice "Menu de productos"
            System.out.println(ColoresConsola.TEXTO_AMARILLO + "\n\uD835\uDE48\uD835\uDE5A\uD835\uDE63\uD835\uDE6A \uD835\uDE3F\uD835\uDE5A \uD835\uDE4B\uD835\uDE67\uD835\uDE64\uD835\uDE59\uD835\uDE6A\uD835\uDE58\uD835\uDE69\uD835\uDE64\uD835\uDE68 🛒");
            System.out.println("❗ Ingresa el número de la opción que deseas selecionar ❗" + ColoresConsola.TEXTO_ROJO + "[1-2-3-4-5-6]\n" + ColoresConsola.TEXTO_CIAN);
            System.out.println("🔷 1️⃣ AGREGAR PRODUCTO ➕");
            System.out.println("🔷 2️⃣ MOSTRAR PRODUCTO 👀");
            System.out.println("🔷 3️⃣ MODIFICAR PRODUCTO 🔃");
            System.out.println("🔷 4️⃣ ELIMINAR PRODUCTO ✖️");
            System.out.println("🔷 5️⃣ CALCULAR VENCIMIENTO 🤢");
            System.out.println("🔷 6️⃣ SALIR DEL MENÚ 🚫");
            System.out.print(ColoresConsola.TEXTO_AMARILLO + "\n 🔶 Ingrese su opción → ");

            opcionUsuario = ValidadorEntrada.leerByte(scanner);
            scanner.nextLine(); // Limpia el buffer

            if (DiccionarioProductos.isEmpty()) {banderaOpciones=false;}

            // Esta validación funciona para comprobar que el usuario haya escogido como primera opción el número 1 o el 6

            if (opcionUsuario != 1 && opcionUsuario != 6 && !banderaOpciones) {
                System.out.println(ColoresConsola.TEXTO_ROJO + "︵‿︵‿︵‿︵︵‿︵‿︵‿︵︵‿︵‿︵‿︵︵‿︵‿︵‿︵︵‿︵‿︵‿︵︵‿︵‿︵‿︵︵‿︵‿︵‿︵︵‿︵‿︵‿︵︵︵‿︵‿︵‿︵︵‿︵‿︵‿︵");
                System.out.println("\n❗👀 Añade algún producto antes de poder ejecutar esta opción | " + ColoresConsola.TEXTO_AMARILLO + " Selecciona la primera opción 1️⃣");
                System.out.println(ColoresConsola.TEXTO_ROJO + "︵‿︵‿︵‿︵︵‿︵‿︵‿︵︵‿︵‿︵‿︵︵‿︵‿︵‿︵︵‿︵‿︵‿︵︵‿︵‿︵‿︵︵‿︵‿︵‿︵︵‿︵‿︵‿︵︵︵‿︵‿︵‿︵︵‿︵‿︵‿︵" + ColoresConsola.TEXTO_AMARILLO);
                continue;
            } else banderaOpciones = true;


            switch (opcionUsuario) {
                case 1:
                    String respuesta = "";
                    while (!respuesta.equalsIgnoreCase("NO")) {

                        HashMap<String, Object> producto = new HashMap<>();

                        System.out.println(ColoresConsola.TEXTO_VERDE + "\n📋 LISTA DE PRODUCTOS REGISTRADOS " + ColoresConsola.TEXTO_AMARILLO);

                        producto.put("ID", idAleatorio.toString());

                        System.out.print("🛍️ Nombre del producto: ");
                        String nombreProducto = scanner.nextLine();

                        System.out.print("💰 Precio: ");
                        producto.put("precio", ValidadorEntrada.leerEntero(scanner));

                        System.out.print("📦 Cantidad en bodega: ");
                        producto.put("cantidad", ValidadorEntrada.leerEntero(scanner));

                        scanner.nextLine(); // Limpia el buffer

                        // Función para poder tener la fecha de vencimiento en el formato correcto
                        producto.put("vencimiento", ValidadorEntrada.leerFecha(scanner));

                        System.out.print("📷 URL De primera foto del producto: ");
                        producto.put("foto Uno", scanner.nextLine());

                        System.out.print("📷 URL De segunda foto del producto: ");
                        producto.put("foto Dos", scanner.nextLine());

                        System.out.print("📎 Descripción del producto: ");
                        producto.put("descripcion", scanner.nextLine());

                        System.out.print("☢️ Categoría del producto: ");
                        producto.put("categoría", scanner.nextLine());

                        System.out.print("🏭 Nombre del Provedor: ");
                        producto.put("provedor", scanner.nextLine());

                        // Guardar en el mapa general
                        DiccionarioProductos.put(nombreProducto, producto);

                        System.out.print("\n¿Deseas agregar otro producto? (SI/NO) → ");
                        respuesta = scanner.nextLine();

                        while (!respuesta.trim().equalsIgnoreCase("SI")) {

                            if (respuesta.trim().equalsIgnoreCase("NO")) {
                                break;
                            } else {
                                System.out.print(ColoresConsola.TEXTO_ROJO + "❌ Respuesta inválida | " + ColoresConsola.TEXTO_AMARILLO
                                        + "Deseas agregar otro producto? (SI/NO) → ");
                                respuesta = scanner.nextLine();
                            }
                        }
                    }
                    continue;
                case 2:
                    System.out.println(ColoresConsola.TEXTO_VERDE + "\n📋 LISTA DE PRODUCTOS REGISTRADOS:");

                    // Map.Entry es la "página" del diccionario en cuestión
                    // .entrySet Retorna todas las entradas de la página del diccionario
                    for (Map.Entry<String, HashMap<String, Object>> entrada : DiccionarioProductos.entrySet()) {
                        String nombreProducto = entrada.getKey();
                        HashMap<String, Object> datos = entrada.getValue();

                        System.out.println(ColoresConsola.TEXTO_CIAN +
                                "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                        System.out.println("📦 Nombre: " + nombreProducto);
                        System.out.println("🆔 ID: " + datos.get("ID"));
                        System.out.println("💰 Precio: $" + datos.get("precio"));
                        System.out.println("📦 Cantidad: " + datos.get("cantidad"));
                        System.out.println("📅 Vencimiento: " + datos.get("vencimiento"));
                        System.out.println("🖼️ Foto 1: " + datos.get("foto Uno"));
                        System.out.println("🖼️ Foto 2: " + datos.get("foto Dos"));
                        System.out.println("📎 Descripción: " + datos.get("descripcion"));
                        System.out.println("🏷️ Categoría: " + datos.get("categoría"));
                        System.out.println("🏭 Proveedor: " + datos.get("provedor"));
                        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                    }
                    continue;
                case 3:
                    System.out.println(ColoresConsola.TEXTO_VERDE + "\n🔃 MODIFICAR PRECIO DE PRODUCTO\n");

                    for (Map.Entry<String, HashMap<String, Object>> entrada : DiccionarioProductos.entrySet()) {
                        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                        String nombreProducto = entrada.getKey();
                        HashMap<String, Object> datos = entrada.getValue();
                        System.out.println("📦 " + nombreProducto + " - Precio actual: $" + datos.get("precio"));
                    }
                    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

                    // Solicitar el nombre del producto a modificar
                    System.out.print(ColoresConsola.TEXTO_AMARILLO + "\n🛍️ Ingrese el nombre exacto del producto a modificar → ");
                    String nombreProductoModificar = scanner.nextLine().trim();

                    // Verificar si el producto existe
                    while (true) {
                        if (!DiccionarioProductos.containsKey(nombreProductoModificar)) {
                            System.out.print(ColoresConsola.TEXTO_ROJO + "❌ Producto no encontrado. Verifique que el nombre sea exacto → ");
                            nombreProductoModificar = scanner.nextLine().trim();
                            continue;
                        }
                        break;
                    }

                    // Obtener el producto a modificar
                    HashMap<String, Object> productoModificar = DiccionarioProductos.get(nombreProductoModificar);
                    int precioActual = (Integer) productoModificar.get("precio");

                    // Mostrar información actual del producto
                    System.out.println(ColoresConsola.TEXTO_CIAN + "\n📋 INFORMACIÓN ACTUAL DEL PRODUCTO:");
                    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                    System.out.println("📦 Nombre: " + nombreProductoModificar);
                    System.out.println("💰 Precio actual: $" + precioActual);
                    System.out.println("📦 Cantidad: " + productoModificar.get("cantidad"));
                    System.out.println("📅 Vencimiento: " + productoModificar.get("vencimiento"));
                    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

                    // Solicitar el nuevo precio
                    System.out.print(ColoresConsola.TEXTO_AMARILLO + "\n💰 Ingrese el nuevo precio → $");
                    int nuevoPrecio = ValidadorEntrada.leerEntero(scanner);

                    // Validar que el precio sea positivo
                    if (nuevoPrecio <= 0) {
                        System.out.println(ColoresConsola.TEXTO_ROJO + "❌ El precio debe ser mayor a 0. Operación cancelada.");
                        continue;
                    }

                    // Confirmar la modificación
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print(ColoresConsola.TEXTO_AMARILLO + "\n⚠️ ¿Está seguro de cambiar el precio de $" + precioActual +
                            " a $" + nuevoPrecio + "? (SI/NO) → ");
                    String confirmacion = scanner.nextLine().trim();

                    if (confirmacion.equalsIgnoreCase("SI")) {
                        // Actualizar el precio
                        productoModificar.put("precio", nuevoPrecio);

                        System.out.println(ColoresConsola.TEXTO_VERDE + "\n✅ ¡PRECIO MODIFICADO EXITOSAMENTE!");
                        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                        System.out.println("📦 Producto: " + nombreProductoModificar);
                        System.out.println("💰 Precio anterior: $" + precioActual);
                        System.out.println("💰 Precio nuevo: $" + nuevoPrecio);
                        System.out.println("📈 Diferencia: $" + (nuevoPrecio - precioActual));
                        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

                    } else if (confirmacion.equalsIgnoreCase("NO")) {
                        System.out.println(ColoresConsola.TEXTO_AMARILLO + "\n🚫 Operación cancelada. El precio no fue modificado.");
                    } else {
                        System.out.println(ColoresConsola.TEXTO_ROJO + "❌ Respuesta inválida. Operación cancelada.");
                    }

                    continue;
                case 4:
                    System.out.println(ColoresConsola.TEXTO_VERDE + "\n❎ PRODUCTOS DISPONBILES PARA ELIMINAR");

                    for (Map.Entry<String, HashMap<String, Object>> entrada : DiccionarioProductos.entrySet()) {
                        String nombreProducto = entrada.getKey();
                        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                        System.out.println("📦 " + nombreProducto);
                    }
                    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

                    // Solicitar el nombre del producto a modificar
                    System.out.print(ColoresConsola.TEXTO_AMARILLO + "\n🛍️ Ingrese el nombre exacto del producto que desea ELIMINAR → ");
                    String nombreProductoEliminar = scanner.nextLine().trim();

                    // Verificar si el producto existe
                    while (true) {
                        if (!DiccionarioProductos.containsKey(nombreProductoEliminar)) {
                            System.out.print(ColoresConsola.TEXTO_ROJO + "❌ Producto no encontrado. Verifique que el nombre sea exacto → ");
                            nombreProductoEliminar = scanner.nextLine().trim();
                            continue;
                        }
                        break;
                    }

                    // Confirmar la modificación
                    System.out.print(ColoresConsola.TEXTO_AMARILLO + "\n⚠️ ¿Está seguro que quieres eliminar el producto" + nombreProductoEliminar + "? (SI/NO) → ");
                    String confirmacionEliminar = scanner.nextLine().trim();

                    if (confirmacionEliminar.equalsIgnoreCase("SI")) {
                        System.out.println(ColoresConsola.TEXTO_ROJO + "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                        System.out.println("✖❎ ¡SE ELIMINÓ EL PRODUCTO " + nombreProductoEliminar + " EXITOSAMENTE !");
                        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

                        DiccionarioProductos.remove(nombreProductoEliminar);

                        // Verificar si el diccionario quedó vacío
                        if (DiccionarioProductos.isEmpty()) {
                            System.out.println(ColoresConsola.TEXTO_AMARILLO + "\n📦 La bodega está ahora vacía.");
                            System.out.println("💡 Puede agregar nuevos productos usando la opción 1.");
                        } else {
                            // Mostrar productos restantes
                            System.out.println(ColoresConsola.TEXTO_CIAN + "\n📋 PRODUCTOS RESTANTES EN BODEGA:");
                            for (String nombreRestante : DiccionarioProductos.keySet()) {
                                System.out.println("📦 " + nombreRestante);
                            }
                        }


                    } else if (confirmacionEliminar.equalsIgnoreCase("NO")) {
                        System.out.println(ColoresConsola.TEXTO_AMARILLO + "\n🚫 Operación cancelada. El objeto no se eliminó el producto.");
                    } else {
                        System.out.println(ColoresConsola.TEXTO_ROJO + "❌ Respuesta inválida. Operación cancelada.");
                    }

                    continue;
                case 5:
                    System.out.println(ColoresConsola.TEXTO_VERDE + "\n🔍 VERIFICAR ESTADO DE VENCIMIENTO DE PRODUCTOS");

                    // Mostrar productos disponibles para seleccionar
                    System.out.println(ColoresConsola.TEXTO_CIAN + "\n📋 PRODUCTOS DISPONIBLES PARA VERIFICAR:");
                    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

                    int contador = 1;
                    List<String> nombresProductos = new ArrayList<>();

                    for (Map.Entry<String, HashMap<String, Object>> entrada : DiccionarioProductos.entrySet()) {
                        String nombreProducto = entrada.getKey();
                        HashMap<String, Object> datos = entrada.getValue();

                        nombresProductos.add(nombreProducto);

                        System.out.println(ColoresConsola.TEXTO_AMARILLO + contador + "️⃣ " +
                                ColoresConsola.TEXTO_BLANCO + nombreProducto +
                                ColoresConsola.TEXTO_CIAN + " (Vence: " + datos.get("vencimiento") + ")");
                        contador++;
                    }


                    if (nombresProductos.size() == 1) {
                        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                        System.out.print(ColoresConsola.TEXTO_AMARILLO + "\n🔢 Seleccione el número del producto a verificar (1)");
                    } else {
                        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                        System.out.print(ColoresConsola.TEXTO_AMARILLO + "\n🔢 Seleccione el número del producto a verificar (1-" +
                                nombresProductos.size() + ") → ");
                    }

                    try {
                        int seleccion = ValidadorEntrada.leerEntero(scanner);
                        scanner.nextLine(); // Limpiar buffer

                        // Validar que la selección esté en rango
                        if (seleccion < 1 || seleccion > nombresProductos.size()) {
                            System.out.println(ColoresConsola.TEXTO_ROJO +
                                    "❌ Selección inválida. Debe estar entre 1 y " + nombresProductos.size());
                            continue;
                        }

                        // Obtener el producto seleccionado
                        String nombreSeleccionado = nombresProductos.get(seleccion - 1);
                        HashMap<String, Object> productoSeleccionado = DiccionarioProductos.get(nombreSeleccionado);

                        // Obtener datos del producto
                        LocalDate fechaVencimiento = (LocalDate) productoSeleccionado.get("vencimiento");
                        int cantidad = (int) productoSeleccionado.get("cantidad");
                        int precio = (int) productoSeleccionado.get("precio");

                        // Calcular días hasta/desde el vencimiento
                        LocalDate hoy = LocalDate.now();
                        long diasDiferencia = ChronoUnit.DAYS.between(hoy, fechaVencimiento);

                        // Mostrar información detallada del producto
                        System.out.println(ColoresConsola.TEXTO_CIAN + "\n" +
                                "╔══════════════════════════════════════════════════════════════════════════════╗");
                        System.out.println("║                           📊 REPORTE DE VENCIMIENTO                          ║");
                        System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");

                        System.out.println(ColoresConsola.TEXTO_BLANCO + "\n📦 Producto: " + ColoresConsola.TEXTO_AMARILLO + nombreSeleccionado);
                        System.out.println(ColoresConsola.TEXTO_BLANCO + "📅 Fecha actual: " + ColoresConsola.TEXTO_CIAN + hoy);
                        System.out.println(ColoresConsola.TEXTO_BLANCO + "📅 Fecha de vencimiento: " + ColoresConsola.TEXTO_CIAN + fechaVencimiento);
                        System.out.println(ColoresConsola.TEXTO_BLANCO + "📦 Cantidad en stock: " + ColoresConsola.TEXTO_CIAN + cantidad + " unidades");
                        System.out.println(ColoresConsola.TEXTO_BLANCO + "💰 Precio unitario: " + ColoresConsola.TEXTO_CIAN + "$" + precio);

                        // Análisis del estado de vencimiento
                        System.out.println(ColoresConsola.TEXTO_CIAN + "\n" +
                                "╔══════════════════════════════════════════════════════════════════════════════╗");
                        System.out.println("║                            🔍 ANÁLISIS DE ESTADO                             ║");
                        System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");

                        if (diasDiferencia > 0) {
                            // Producto NO vencido
                            if (diasDiferencia <= 3) {
                                // Próximo a vencer (1-3 días)
                                System.out.println(ColoresConsola.TEXTO_AMARILLO + "\n⚠️  ESTADO: PRÓXIMO A VENCER ⚠️");
                                System.out.println("🕒 Días restantes: " + diasDiferencia + " día(s)");
                                System.out.println("💡 RECOMENDACIÓN: ¡VENDER URGENTEMENTE! Aplicar descuentos o promociones");

                                // Calcular pérdida potencial
                                int perdidaPotencial = cantidad * precio;
                                System.out.println("💸 Pérdida potencial si vence: $" + perdidaPotencial);

                                // Sugerencias específicas por días
                                if (diasDiferencia == 1) {
                                    System.out.println("🚨 ALERTA CRÍTICA: ¡Solo queda 1 día! Descuento del 50% recomendado");
                                } else if (diasDiferencia == 2) {
                                    System.out.println("⚡ ALERTA ALTA: Quedan 2 días. Descuento del 30% recomendado");
                                } else {
                                    System.out.println("⚠️ ALERTA MEDIA: Quedan 3 días. Descuento del 15% recomendado");
                                }

                            } else if (diasDiferencia <= 7) {
                                // Próximo a vencer (4-7 días)
                                System.out.println(ColoresConsola.TEXTO_CIAN + "\n📋 ESTADO: EN SEGUIMIENTO 📋");
                                System.out.println("🕒 Días restantes: " + diasDiferencia + " día(s)");
                                System.out.println("💡 RECOMENDACIÓN: Monitorear semanalmente. Preparar estrategia de venta");

                            } else if (diasDiferencia <= 30) {
                                // Fecha normal (más de 7 días)
                                System.out.println(ColoresConsola.TEXTO_VERDE + "\n✅ ESTADO: BUENO ✅");
                                System.out.println("🕒 Días restantes: " + diasDiferencia + " día(s)");
                                System.out.println("💡 RECOMENDACIÓN: Producto en condiciones normales para la venta");

                            } else {
                                // Muy fresco (más de 30 días)
                                System.out.println(ColoresConsola.TEXTO_VERDE + "\n🌟 ESTADO: EXCELENTE 🌟");
                                System.out.println("🕒 Días restantes: " + diasDiferencia + " día(s)");
                                System.out.println("💡 RECOMENDACIÓN: ¡Producto muy fresco! Ideal para venta normal");
                            }

                        } else if (diasDiferencia == 0) {
                            // Vence hoy
                            System.out.println(ColoresConsola.TEXTO_ROJO + "\n🚨 ESTADO: VENCE HOY 🚨");
                            System.out.println("⏰ ¡ÚLTIMO DÍA DE VENTA!");
                            System.out.println("💡 RECOMENDACIÓN: Vender inmediatamente con descuento del 70%");
                            System.out.println("🔄 ACCIÓN REQUERIDA: Revisar al final del día para descarte");

                        } else {
                            // Producto vencido
                            long diasVencido = Math.abs(diasDiferencia);
                            System.out.println(ColoresConsola.TEXTO_ROJO + "\n💀 ESTADO: PRODUCTO VENCIDO 💀");
                            System.out.println("⏰ Días vencido: " + diasVencido + " día(s)");

                            if (diasVencido <= 3) {
                                System.out.println("⚠️ ACCIÓN: Producto recientemente vencido");
                                System.out.println("🔍 RECOMENDACIÓN: Evaluar si es apto para consumo según tipo de producto");
                                System.out.println("📞 SUGERENCIA: Contactar proveedor para posible devolución");
                            } else {
                                System.out.println("🗑️ ACCIÓN REQUERIDA: ELIMINAR INMEDIATAMENTE DEL INVENTARIO");
                                System.out.println("⚠️ RIESGO: Producto no apto para venta ni consumo");
                                System.out.println("💸 Pérdida confirmada: $" + (cantidad * precio));

                                // Preguntar si desea eliminar automáticamente
                                System.out.print(ColoresConsola.TEXTO_AMARILLO +
                                        "\n🗑️ ¿Desea eliminar el Stock de este producto vencido del inventario? (SI/NO) → ");
                                String respuestaEliminar = scanner.nextLine().trim();

                                if (respuestaEliminar.equalsIgnoreCase("SI")) {
                                    productoSeleccionado.put("cantidad", 0);
                                    System.out.println(ColoresConsola.TEXTO_VERDE +
                                            "✅ Stock eliminado exitosamente del inventario");
                                } else {
                                    System.out.println(ColoresConsola.TEXTO_AMARILLO +
                                            "⚠️ El Stock no fue eliminado (RIESGO ALTO)");
                                }
                            }
                        }

                        // Información adicional útil
                        System.out.println(ColoresConsola.TEXTO_CIAN + "\n" +
                                "╔══════════════════════════════════════════════════════════════════════════════╗");
                        System.out.println("║                          📊 INFORMACIÓN ADICIONAL                            ║");
                        System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");

                        // Mostrar información del proveedor y categoría
                        System.out.println(ColoresConsola.TEXTO_BLANCO + "🏭 Proveedor: " +
                                ColoresConsola.TEXTO_CIAN + productoSeleccionado.get("provedor"));
                        System.out.println(ColoresConsola.TEXTO_BLANCO + "🏷️ Categoría: " +
                                ColoresConsola.TEXTO_CIAN + productoSeleccionado.get("categoría"));
                        System.out.println(ColoresConsola.TEXTO_BLANCO + "🆔 ID del producto: " +
                                ColoresConsola.TEXTO_CIAN + productoSeleccionado.get("ID"));

                        // Calcular valor total del stock
                        int valorTotalStock = cantidad * precio;
                        System.out.println(ColoresConsola.TEXTO_BLANCO + "💰 Valor total del stock: " +
                                ColoresConsola.TEXTO_AMARILLO + "$" + valorTotalStock);

                        // Mostrar semáforo visual del estado
                        System.out.println(ColoresConsola.TEXTO_CIAN + "\n📊 SEMÁFORO DE ESTADO:");
                        if (diasDiferencia > 7) {
                            System.out.println("🟢🟢🟢 VERDE: Producto en excelente estado");
                        } else if (diasDiferencia > 3) {
                            System.out.println("🟡🟡🟡 AMARILLO: Requiere atención");
                        } else if (diasDiferencia >= 0) {
                            System.out.println("🟠🟠🟠 NARANJA: Acción inmediata requerida");
                        } else if (diasDiferencia <= -3) {
                            System.out.println("🔴🔴🔴 ROJO: Producto vencido - Alto riesgo");
                        }

                        System.out.println(ColoresConsola.TEXTO_CIAN +
                                "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

                        // Opción para verificar otro producto
                        System.out.print(ColoresConsola.TEXTO_AMARILLO +
                                "\n🔄 ¿Desea verificar otro producto? (SI/NO) → ");
                        String verificarOtro = scanner.nextLine().trim();

                        if (verificarOtro.equalsIgnoreCase("SI")) {
                            // Reiniciar el case 5 recursivamente
                            System.out.println("\n" + "=".repeat(80));
                            // Aquí se volvería a ejecutar el case 5, pero para evitar recursión infinita,
                            // simplemente mostramos un mensaje
                            System.out.println(ColoresConsola.TEXTO_VERDE +
                                    "💡 Regrese al menú principal y seleccione la opción 5 nuevamente");
                        }

                    } catch (Exception e) {
                        System.out.println(ColoresConsola.TEXTO_ROJO +
                                "❌ Error al procesar la verificación: " + e.getMessage());
                        System.out.println("💡 Intente nuevamente con una selección válida");
                    }

                    continue;
                case 6:
                    System.out.println("\n Gracias por utilizar el programa 👍");
                    break;
                default:
                    System.out.println("Opción Inválida ✖  Ingrese un dígito del 1 al 6️");
                    // Esto Tiene implícito un Continue
            }
            break;
        }
    }
}
