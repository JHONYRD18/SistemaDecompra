
package Clases;

/**
 *
 * @author Jhony RD
 */
public class Menu {

    private String nombre;
    private String[] platos;
    private String[] entradas;
    private String[] bebidas;
    private double precio;

    public Menu(String nombre, String[] platos, String[] entradas, String[] bebidas, double precio) {
        this.nombre = nombre;
        this.platos = platos;
        this.entradas = entradas;
        this.bebidas = bebidas;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
    public String[] getPlatos() {
        return platos;
    }

    public String[] getEntradas() {
        return entradas;
    }

    public String[] getBebidas() {
        return bebidas;
    }

    // Métodos para obtener platos, entradas y bebidas por índice
    public String getPlato(int indice) {
        if (indice >= 0 && indice < platos.length) {
            return platos[indice];
        } else {
            return null;
        }
    }

    public String getEntrada(int indice) {
        if (indice >= 0 && indice < entradas.length) {
            return entradas[indice];
        } else {
            return null;
        }
    }

    public String getBebida(int indice) {
        if (indice >= 0 && indice < bebidas.length) {
            return bebidas[indice];
        } else {
            return null;
        }
    }
    
    public void mostrarPlatos() {
        System.out.println("Entradas disponibles:");
        for (int i = 0; i < platos.length; i++) {
            System.out.println((i + 1) + ". " + platos[i]);
        }
    }

    // Método para mostrar las entradas disponibles
    public void mostrarEntradas() {
        System.out.println("Fondos disponibles:");
        for (int i = 0; i < entradas.length; i++) {
            System.out.println((i + 1) + ". " + entradas[i]);
        }
    }

    // Método para mostrar las bebidas disponibles
    public void mostrarBebidas() {
        System.out.println("Bebidas disponibles:");
        for (int i = 0; i < bebidas.length; i++) {
            System.out.println((i + 1) + ". " + bebidas[i]);
        }
    }

    public void mostrarMenu() {
       System.out.println("===== " + nombre + " =====");
        System.out.println("Entrada:");
        for (String plato : platos) {
            System.out.println("- " + plato);
        }
        System.out.println("Fondo:");
        for (String entrada : entradas) {
            System.out.println("- " + entrada);
        }
        System.out.println("Bebidas:");
        for (String bebida : bebidas) {
            System.out.println("- " + bebida);
        }
        System.out.println("Precio: S/. " + precio);
        System.out.println("=========================");
    }
    
}
