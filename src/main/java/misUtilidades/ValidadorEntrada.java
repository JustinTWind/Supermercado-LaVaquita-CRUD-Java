package misUtilidades;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class ValidadorEntrada {

    public static int leerEntero(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("❌ Entrada inválida | Ingrese un número entero → ");
                scanner.nextLine(); // limpiar buffer
            }
        }
    }

    public static byte leerByte(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextByte();
            } catch (InputMismatchException e) {
                System.out.print("❌ Entrada inválida | Ingrese un número entero → ");
                scanner.nextLine(); // limpiar buffer
            }
        }
    }


    public static LocalDate leerFecha(Scanner scanner) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.print("📅 Ingrese una fecha de vencimiento (YYYY-MM-DD): ");
            String entrada = scanner.nextLine();
            try {
                return LocalDate.parse(entrada, formato);
            } catch (DateTimeParseException e) {
                System.out.println("❌ Fecha inválida. Use el formato correcto (YYYY-MM-DD)");
            }
        }
    }

    public static boolean confirmar(Scanner scanner, String mensaje) {
        String respuesta;
        while (true) {
            System.out.print(mensaje);
            respuesta = scanner.next().trim().toUpperCase();
            if (respuesta.equals("SI")) return true;
            if (respuesta.equals("NO")) return false;
            System.out.println("❌ Respuesta inválida. Escriba 'SI' o 'NO'.");
        }
    }
}