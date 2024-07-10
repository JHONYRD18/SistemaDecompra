/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Raiz.Compra;
import Raiz.Menu;
import java.util.Scanner;

public class GestorCompra {

    private static Menu[] menus = {
        new Menu("Menu Universitario", 10.9),
        new Menu("Menu Ejecutivo", 11.9)
    // Puedes agregar más menús aquí según sea necesario
    };

    private static Compra[] compras = new Compra[100]; // Arreglo para almacenar compras
    private static int contadorCompras = 0; // Contador para llevar el número de compras realizadas

    public static void gestionarCompra(Scanner usuario) {
        iniciarCompra(usuario, obtenerNombreComprador(usuario));
    }

    public static void gestionarRecojo(Scanner usuario) {
        int intentos = 3; // Número máximo de intentos
        boolean recojoExitoso = false;

        while (intentos > 0) {
            System.out.print("Ingrese el codigo de compra: ");
            String codigo = usuario.nextLine();

            recojoExitoso = verificarRecojo(codigo);
            if (recojoExitoso) {
                System.out.println("Recojo exitoso!");
                return; // Sale del método si el recojo es exitoso
            } else {
                System.out.println("No se encontro pedido.");
                intentos--; // Reduce el contador de intentos
                if (intentos > 0) {
                    System.out.println("Intentos restantes: " + intentos);
                }
            }
        }

        // Si se agotan los intentos
        System.out.println("Ha alcanzado el maximo de intentos. Cerrando programa.");
        System.exit(0);
    }

    private static void iniciarCompra(Scanner usuario, String nombreComprador) {
        mostrarMenusDisponibles(); // Mostrar los menús disponibles
        
        System.out.print("Ingrese el numero del menu que desea comprar: ");
        int opcionMenu = usuario.nextInt();
        usuario.nextLine(); // Consumir el salto de línea después de nextInt()

        if (opcionMenu < 1 || opcionMenu > menus.length) {
            System.out.println("Opcion de menu no valida.");
            return;
        }

        Menu menuSeleccionado = menus[opcionMenu - 1]; // Acceder al menú seleccionado

        // Generar código de compra único
        String codigoCompra = generarCodigoCompra();

        // Solicitar método de pago
        String metodoPago = verificarMetodoDePago(usuario);
        if (metodoPago == null) {
            System.out.println("Compra cancelada.");
            return;
        }

        System.out.println("Codigo de compra: " + codigoCompra);

        // Almacenar la compra en el arreglo de compras
        compras[contadorCompras++] = new Compra(codigoCompra, nombreComprador, menuSeleccionado, metodoPago);
    }

    private static String verificarMetodoDePago(Scanner usuario) {
        int intentos = 0;
        while (intentos < 3) {
            System.out.println("");
            System.out.print("Ingrese su metodo de pago (tarjeta o yape): ");
            String metodoDePago = usuario.nextLine();

            switch (metodoDePago.toLowerCase()) {
                case "tarjeta":
                    System.out.print("Desea confirmar el pago con tarjeta? (s/n): ");
                    String respuestaTarjeta = usuario.nextLine();
                    if (respuestaTarjeta.equalsIgnoreCase("s")) {
                        System.out.println("Pedido finalizado! Gracias por su compra.");
                        return metodoDePago; // Retorna "tarjeta"
                    } else {
                        System.out.println("Pago no confirmado. Pedido no finalizado.");
                        return null; // Retorna null si no se confirma el pago
                    }
                case "yape":
                    System.out.print("Desea confirmar el pago con Yape? (s/n): ");
                    String respuestaYape = usuario.nextLine();
                    if (respuestaYape.equalsIgnoreCase("s")) {
                        System.out.println("Pedido finalizado! Gracias por su compra.");
                        return metodoDePago; // Retorna "yape"
                    } else {
                        System.out.println("Pago no confirmado. Pedido no finalizado.");
                        return null; // Retorna null si no se confirma el pago
                    }
                default:
                    System.out.println("Metodo de pago no valido.");
                    intentos++;
            }
        }
        System.out.println("Ha alcanzado el máximo de intentos.");
        System.exit(0);
        return null;
    }

    private static boolean verificarRecojo(String codigo) {
        for (int i = 0; i < contadorCompras; i++) {
            if (compras[i].getCodigoCompra().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    private static void mostrarMenusDisponibles() {
        System.out.println("\nMenus disponibles:");
        for (int i = 0; i < menus.length; i++) {
            System.out.println((i + 1) + ". " + menus[i]);
        }
    }

    private static String generarCodigoCompra() {
        return "COD" + (int) (Math.random() * 1000);
    }

    private static String obtenerNombreComprador(Scanner usuario) {
        String codigoComprador;
        String nombreCompleto;

        // Validación del código del comprador
        int intentosCodigo = 0;
        while (intentosCodigo < 2) {
            System.out.print("Ingrese su codigo de comprador "
                    + "(C o U seguido de 8 dígitos): ");
            codigoComprador = usuario.nextLine();

            // Expresión regular para validar el código del comprador
            if (codigoComprador.matches("[CcUu]\\d{8}")) {
                // Determinar si es estudiante o docente
                String tipoComprador = codigoComprador.startsWith("C")
                        || codigoComprador.startsWith("c") ? "Maestro" : "Estudiante";
                System.out.println("Es " + tipoComprador);
                break; // Código válido, salir del bucle
            } else {
                System.out.println("Codigo de comprador no válido. Intento restante: " + (1 - intentosCodigo));
                intentosCodigo++;
            }
        }

        // Si se agotan los intentos, cerrar el programa
        if (intentosCodigo >= 2) {
            System.out.println("Se agotaron los intentos. Cerrando programa.");
            System.exit(0);
        }

        // Validación del nombre completo
        while (true) {
            System.out.print("Ingrese su nombre completo: ");
            nombreCompleto = usuario.nextLine();

            // Expresión regular para validar el nombre completo
            if (nombreCompleto.matches("^[a-zA-Z ]{3,20}$")) {
                break; // Nombre válido
            } else {
                System.out.println("Nombre no válido. Ingrese nuevamente.");
            }
        }

        return nombreCompleto;
    }

    public static void verPedidosRegistrados() {
        if (contadorCompras == 0) {
            System.out.println("Aun no se han registrado pedidos.");
        } else {
            System.out.println("********* Platos de Menu registrados *********");
            for (int i = 0; i < contadorCompras; i++) {
                System.out.println("Menu" + (i + 1) + ": " + compras[i]);
            }
        }
    }
}
