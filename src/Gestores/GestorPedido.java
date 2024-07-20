/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Clases.Menu;
import Clases.Pedido;
import Clases.Usuario;
import static Gestores.GestorUsuario.buscarUsuarioPorCodigo;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class GestorPedido {

    private static Menu[] menus = {
        new Menu("Menu Grand Central",
        new String[]{"Salpicon de pollo", "Sancochado de res"},
        new String[]{"Pollo Mechado", "Fideos a la Huancaina"},
        new String[]{"Refrezco de manzana", "Jugo de Naranja"},
        11.0),
        new Menu("Menu Ejecutivo",
        new String[]{"Sopa seca", "Papa a la huancaina"},
        new String[]{"Lomo saltado", "Arroz con Pollo"},
        new String[]{"Chicha morada", "Agua purificada"},
        12.0),
    // Puedes agregar más menús aquí según sea necesario
    };

    private static Pedido[] pedidos = new Pedido[100]; // Arreglo pedidos
    private static int contadorPedidos = 0; // Contador de pedidos realizados

    public static void iniciarPedido(Scanner usuario) {
        // Mostrar los menús disponibles

        Menu menuElegido = seleccionarMenu(usuario);
        System.out.println("");
        // Validar y obtener el comprador
        Usuario comprador = validarComprador(usuario);
        if (comprador == null) {
            System.out.println("No se encontró ningún comprador válido. "
                    + "Cerrando programa.");
            System.exit(0);
        }
        // Preguntar método de pago
        int metodoPago = verificarMetodoDePago(usuario);
        if (metodoPago != 0) {
            System.out.println("El pago no se realizó correctamente. "
                    + "Cerrando programa.");
            limpiarPantalla();
            return;
        }
        // Generar código de compra
        String codigoCompra = generarCodigoCompra();
        System.out.println("");

        // Crear el pedido
        Pedido nuevoPedido = new Pedido(codigoCompra, comprador, menuElegido, 
                metodoPago);

        agregarPedido(nuevoPedido);

        // Mostrar mensaje de confirmación
        System.out.println("Codigo de compra: " + codigoCompra);
        limpiarPantalla();
    }

    private static Menu seleccionarMenu(Scanner usuario) {

        for (int i = 0; i < menus.length; i++) {
            System.out.println((i + 1) + ". " + menus[i].getNombre());
            menus[i].mostrarMenu();
        }

        int intentos0 = 0;
        int opcionMenu = 0;

        while (intentos0 < 2) {
            System.out.print("Seleccione un menú (1 o 2): ");
            opcionMenu = usuario.nextInt();
            usuario.nextLine(); // Limpiar el buffer de entrada

            if (opcionMenu >= 1 && opcionMenu <= menus.length) {
                // Mostrar el menú seleccionado
                Menu menuElegido = menus[opcionMenu - 1];
                System.out.println("Ha seleccionado: "
                        + menuElegido.getNombre());
                System.out.println("");
                break; // Salir del bucle si la opción es válida
            } else {
                intentos0++;
                if (intentos0 < 2) {
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                } else {
                    System.out.println("Se han agotado los intentos. "
                            + "Cerrando el programa.");
                    System.exit(0);
                }
            }
        }

        Menu menuElegido = menus[opcionMenu - 1];

        // Solicitar al usuario que elija los entrada, fondo y bebida
        menuElegido.mostrarPlatos();
        int intentos = 0;
        int opcionPlato = -1; // Inicializamos opcionPlato fuera del rango 

        while (intentos < 2) {
            System.out.print("Elija un Plato de Entrada (1 o 2): ");
            opcionPlato = usuario.nextInt();
            usuario.nextLine(); // Limpiar el buffer de entrada

            if (opcionPlato == 1 || opcionPlato == 2) {
                System.out.println("Plato de entrada Agregado");
                System.out.println("");
                break; // Salir del bucle si la opción es válida
            } else {
                intentos++;
                if (intentos < 2) {
                    System.out.println("Opción no válida. Por favor, intente "
                            + "nuevamente.");
                } else {
                    System.out.println("Se han agotado los intentos. "
                            + "Operación cancelada.");
                    System.exit(0);
                }
            }
        }

        menuElegido.mostrarEntradas();
        int intentos1 = 0;
        int opcionEntrada = -1; // Inicializamos opcionPlato fuera del rango 

        while (intentos1 < 2) {
            System.out.print("Elija un Plato de Fondo (1 o 2): ");
            opcionEntrada = usuario.nextInt();
            usuario.nextLine(); // Limpiar el buffer de entrada

            if (opcionEntrada == 1 || opcionEntrada == 2) {
                System.out.println("Plato de Fondo Agregado");
                System.out.println("");
                break; // Salir del bucle si la opción es válida
            } else {
                intentos1++;
                if (intentos1 < 2) {
                    System.out.println("Opción no válida. Por favor, intente "
                            + "nuevamente.");
                } else {
                    System.out.println("Se han agotado los intentos. "
                            + "Operación cancelada.");
                    System.exit(0);
                }
            }
        }

        menuElegido.mostrarBebidas();
        int intentos2 = 0;
        int opcionBebida = -1; // Inicializamos opcionPlato fuera del rango 

        while (intentos1 < 2) {
            System.out.print("Elija una Bebida (1 o 2): ");
            opcionBebida = usuario.nextInt();
            usuario.nextLine(); // Limpiar el buffer de entrada

            if (opcionBebida == 1 || opcionBebida == 2) {
                System.out.println("Bebida Agregado");
                System.out.println("");
                break; // Salir del bucle si la opción es válida
            } else {
                intentos2++;
                if (intentos2 < 2) {
                    System.out.println("Opción no válida. Por favor, intente "
                            + "nuevamente.");
                } else {
                    System.out.println("Se han agotado los intentos. "
                            + "Operación cancelada.");
                    System.exit(0);
                }
            }
        }

        // Obtener el plato elegido
        String platoElegido = menuElegido.getPlato(opcionPlato - 1);
        String entradaElegida = menuElegido.getEntrada(opcionEntrada - 1);
        String bebidaElegida = menuElegido.getBebida(opcionBebida - 1);

        // Crear un nuevo menú con las opciones seleccionadas
        Menu menuPersonalizado = new Menu("Personalizado",
                new String[]{platoElegido},
                new String[]{entradaElegida},
                new String[]{bebidaElegida},
                menuElegido.getPrecio());

        // Mostrar el menú personalizado
        System.out.println("Menu:" + menuElegido.getNombre());
        System.out.println("Entrada: " + menuPersonalizado.getPlato(0));
        System.out.println("Fondo: " + menuPersonalizado.getEntrada(0));
        System.out.println("Bebida: " + menuPersonalizado.getBebida(0));
        System.out.println("Precio Total: S/. " + menuPersonalizado.getPrecio());
        return menuPersonalizado;
    }

    private static Usuario validarComprador(Scanner usuario) {

        Usuario comprador = null;
        int opcionUsuario = 0;
        do {
            System.out.println("Es usted parte de la universidad o un invitado?");
            System.out.println("1. Universidad 2. Invitado");
            System.out.print("Seleccione una opcion (1 o 2): ");
            opcionUsuario = usuario.nextInt();
            usuario.nextLine(); // Limpiar el buffer de entrada

            switch (opcionUsuario) {
                case 1:
                    // Es universidad, pedir código y buscar usuario
                    int intentos = 0;
                    while (intentos < 2 && comprador == null) {
                        System.out.print("Ingrese su código Universitario: ");
                        String codigoUniv = usuario.nextLine();
                        System.out.println("");

                        // función para buscar el usuario universitario por código
                        comprador = buscarUsuarioPorCodigo(codigoUniv);

                        // Verificar que la variable comprador no esté vacía
                        if (comprador != null) {
                            System.out.println("Usuario encontrado: " + 
                                    comprador.getNombre());
                            break;
                        } else {
                            intentos++;
                            if (intentos < 2) {
                                System.out.println("Usuario no encontrado. I"
                                        + "ntento " + intentos + " de 2.");
                            } else {
                                System.out.println("Se han agotado los intentos. "
                                        + "Operación cancelada.");
                                return null;
                            }
                        }
                    }
                    break;

                case 2:
                    // Es invitado, pedir nombre, apellido y correo
                    comprador = GestorUsuario.crearUsuario(usuario);
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    System.out.println("");
                    break;
            }
        } while (opcionUsuario != 1 && opcionUsuario != 2);

        return comprador;
    }

    private static int verificarMetodoDePago(Scanner usuario) {
        int intentos = 0;
        while (intentos < 3) {
            System.out.println("");
            System.out.println("1. Tarjeta 2. Billetera Digital");
            System.out.print("Seleccione su metodo de pago:");
            int metodoDePago = usuario.nextInt();
            usuario.nextLine(); // Limpiar el buffer de entrada

            switch (metodoDePago) {
                case 1:
                    int tipoTarjeta = 0;
                    String tipoTarjetaTexto = "";
                    int intentos1 = 0;
                    while (intentos1 < 2) {
                        System.out.println("1. Crédito 2. Débito");
                        System.out.print("Seleccione el tipo de tarjeta: ");
                        tipoTarjeta = usuario.nextInt();
                        usuario.nextLine(); // Limpiar el buffer de entrada

                        switch (tipoTarjeta) {
                            case 1:
                                tipoTarjetaTexto = "Tarjeta de Crédito";
                                System.out.print("¿Desea confirmar el pago "
                                        + "con " + tipoTarjetaTexto + "? "
                                                + "(S / N): ");
                                String confirmacionTarjeta1 = usuario.nextLine();

                                if (confirmacionTarjeta1.equalsIgnoreCase("s")) {
                                    System.out.println("¡Pedido finalizado! "
                                            + "Gracias por su compra.");
                                    return 0; // Indicar éxito
                                } else {
                                    System.out.println("Pago no confirmado.");
                                    return -1; // Indicar error
                                }

                            case 2:
                                tipoTarjetaTexto = "Tarjeta de Débito";
                                System.out.print("¿Desea confirmar el pago con"
                                        + " " + tipoTarjetaTexto + "? (S / N)"
                                                + ": ");
                                String confirmacionTarjeta2 = usuario.nextLine();

                                if (confirmacionTarjeta2.equalsIgnoreCase("s")) {
                                    System.out.println("¡Pedido finalizado! "
                                            + "Gracias por su compra.");
                                    return 0; // Indicar éxito
                                } else {
                                    System.out.println("Pago no confirmado.");
                                    return -1; // Indicar error
                                }

                            default:
                                System.out.println("Opción de tarjeta no válida.");
                                intentos1++;
                                break;
                        }
                    }
                    System.out.println("Se han agotado los intentos. "
                            + "Operación cancelada.");
                    return -1; // Indicar error

                case 2:
                    int intentos2 = 0;
                    int billeteraDigital = 0;
                    String billeteraTexto = "";

                    while (intentos2 < 2) {
                        System.out.println("1. Yape 2. Tunki 3. Plin");
                        System.out.print("Seleccione la billetera digital: ");
                        billeteraDigital = usuario.nextInt();
                        usuario.nextLine(); // Limpiar el buffer de entrada

                        switch (billeteraDigital) {
                            case 1:
                                billeteraTexto = "Yape";

                                System.out.print("¿Desea confirmar el pago con "
                                        + billeteraTexto + "? (s / n): ");
                                String confirmacionBilletera1 = usuario.nextLine();

                                if (confirmacionBilletera1.equalsIgnoreCase("s")) {
                                    System.out.println("¡Pedido finalizado! Gracias por "
                                            + "su compra.");
                                    break;
                                } else {
                                    System.out.println("Pago no confirmado.");
                                    return -1;
                                }

                            case 2:
                                billeteraTexto = "Tunki";
                                System.out.print("¿Desea confirmar el pago con "
                                        + billeteraTexto + "? (s / n): ");
                                String confirmacionBilletera2 = usuario.nextLine();

                                if (confirmacionBilletera2.equalsIgnoreCase("s")) {
                                    System.out.println("¡Pedido finalizado! Gracias por "
                                            + "su compra.");
                                    break;
                                } else {
                                    System.out.println("Pago no confirmado.");
                                    return -1;
                                }

                            case 3:
                                billeteraTexto = "Plin";
                                System.out.print("¿Desea confirmar el "
                                        + "pago con " + billeteraTexto + "? "
                                                + "(s / n): ");
                                String confirmacionBilletera3 = 
                                        usuario.nextLine();

                                if (confirmacionBilletera3.equalsIgnoreCase("s")
                                        ) {
                                    System.out.println("¡Pedido finalizado! "
                                            + "Gracias por " + "su compra.");
                                    break;
                                } else {
                                    System.out.println("Pago no confirmado.");
                                    return -1;
                                }
                                
                            default:
                                System.out.println("Opción de billetera digital"
                                        + " no válida.");
                                intentos2++;
                                break;
                        }
                    }
                    System.out.println("Se han agotado los intentos. "
                            + "Operación cancelada.");
                    return -1; // Indicar error

                default:
                    System.out.println("Metodo de pago no valido.");
                    intentos++;
            }
            
        }
        System.out.println("Ha alcanzado el maximo de intentos.");
        return -1;
    }

    private static String generarCodigoCompra() {
        return "COD" + (int) (Math.random() * 1000);
    }

    private static void agregarPedido(Pedido pedido) {
        if (contadorPedidos < pedidos.length) {
            pedidos[contadorPedidos] = pedido; // Agregar el pedido al arreglo
            contadorPedidos++; // Incrementar el contador de pedidos
            System.out.println("Pedido agregado correctamente.");
        } else {
            System.out.println("No se pueden agregar más pedidos. "
                    + "Capacidad maxima alcanzada.");
        }
    }

    public static void verPedidos(Scanner scanner) {

        int opcion;
        boolean salir = false;

        do {
            System.out.println("Opciones:");
            System.out.println("1. Ver número de pedidos realizados");
            System.out.println("2. Buscar un pedido");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada            
            switch (opcion) {
                case 1:
                    System.out.println("Número de pedidos realizados "
                            + "exitosamente: " + contadorPedidos);
                    break;
                case 2:
                    if (contadorPedidos > 0) {
                        System.out.println("Ingrese el código del pedido "
                                + "que desea buscar:");
                        String codigoPedido = scanner.nextLine();
                        System.out.println("");

                        boolean encontrado = false;
                        for (int i = 0; i < contadorPedidos; i++) {
                            if (pedidos[i].getCodigoCompra().equals(codigoPedido)) {
                                pedidos[i].mostrarInformacionPedido();
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Pedido no encontrado.");
                        }
                    } else {
                        System.out.println("No hay pedidos realizados.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println(); // Separador entre iteraciones del menú

        } while (!salir);
        limpiarPantalla();
    }

    public static void recojoPedido(Scanner usuario) {
        System.out.print("Ingrese el codigo de su pedido para recojo: ");
        String codigoPedido = usuario.nextLine(); // Lee el código del 
        // pedido como String

        boolean encontrado = false;
        for (int i = 0; i < contadorPedidos; i++) {
            if (pedidos[i].getCodigoCompra().equals(codigoPedido)) {
                System.out.println("Pedido recogido exitosamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Pedido no encontrado. Realice su pedido "
                    + "o inténtelo nuevamente.");
        }
        limpiarPantalla();
    }

    public static void limpiarPantalla() {
        try {
            System.out.println("Presione enter para continuar");
            new java.util.Scanner(System.in).nextLine();
            Robot iniciar = new Robot();
            iniciar.keyPress(KeyEvent.VK_CONTROL);
            iniciar.keyPress(KeyEvent.VK_L);
            iniciar.keyRelease(KeyEvent.VK_CONTROL);
            iniciar.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
            System.out.println("" + ex.getMessage());
        }
    }

}
