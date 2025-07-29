package misUtilidades;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class ValidadorEntrada {

    public static int leerEntero(Scanner scanner) {
        int num;
        while (true) {
            try {
                num = scanner.nextInt();
                if (num <= 0 ) {
                    System.out.print("❌ Entrada inválida | Ingrese un número mayor a 0 → ");
                    continue;
                } else return num;
            } catch (InputMismatchException e) {
                System.out.print("❌ Entrada inválida | Ingrese un número entero → ");
                scanner.nextLine(); // limpiar buffer
            }
        }
    }

    public static byte leerByte(Scanner scanner) {
        byte num;
        while (true) {
            try {
                num = scanner.nextByte();
                if (num <= 0 ) {
                    System.out.print("❌ Entrada inválida | Ingrese un número mayor a 0 → ");
                    continue;
                } else return num;
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

    public static String ComprobarVacio(Scanner scanner) {
        String texto;
        while (true) {
            try {
                texto = scanner.nextLine();

                if (texto.isEmpty()) {
                    System.out.print("\"❌ Entrada inválida | El Texto está vacío → \"");
                    continue;
                } else return texto;

            } catch (InputMismatchException e) {
                System.out.print("❌ Entrada inválida | Ingrese un número entero → ");
                scanner.nextLine(); // limpiar buffer
            }
        }
    }

}