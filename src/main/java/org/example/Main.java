package org.example;

import static Code.InsertarCollection.Insertar;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        String opcion = "";
        do {
            System.out.println("0. Salir");
            System.out.println("1. Crear BD y cargar datos");
            System.out.println("2. Borrar BD");
            System.out.println("3. Listar profesores");
            System.out.println("4. Insertar Profesor");

            opcion = libs.Leer.pedirCadena("Introduce una opción");
            switch (opcion) {
                case "0" -> {salir = true;}
                case "1" -> {}
                default -> {System.out.println("Opción incorrecta");}
            }
        }while (!salir);
    }
}