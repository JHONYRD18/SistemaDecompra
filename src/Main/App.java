package Main;

import static Gestores.GestorPedido.iniciarPedido;
import static Gestores.GestorPedido.limpiarPantalla;
import static Gestores.GestorPedido.recojoPedido;
import static Gestores.GestorPedido.verPedidos;
import java.util.Scanner;

/**
 *
 * @author Jhony RD
 */
public class App {

    public static void esperarEnter(Scanner leer) {
        System.out.print("\nPresione Enter para mostrar el Menu Principal...");
        leer.nextLine();
    }
    
    public static void mostrarMenu() {
        System.out.println("=== Sistema de Gestion de Pedidos ===");
        System.out.println("1. Iniciar Pedido");
        System.out.println("2. Ver Pedidos");
        System.out.println("3. Recojo de Pedido");
        System.out.println("0. Cerrar");
        System.out.print("Seleccione una opcion: ");
    }

    public static void main(String[] args) {
        Scanner usuario = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            opcion = usuario.nextInt();
            usuario.nextLine(); // Limpiar el buffer de entrada
            
            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    iniciarPedido(usuario);
                    break;
                case 2:
                    limpiarPantalla();
                    usuario.nextLine();                    
                    verPedidos(usuario);
                    break;
                case 3:
                    limpiarPantalla();
                    recojoPedido(usuario);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no válida. Intente nuevamente.");
            }
            esperarEnter(usuario);
        } while (opcion != 0);
        usuario.close();
        
    }
    
   
}
