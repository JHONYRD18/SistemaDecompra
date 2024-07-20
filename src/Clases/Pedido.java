/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Jhony RD
 */
public class Pedido {

    private String codigoCompra;
    private Usuario comprador;
    private Menu menuElegido;
    private int metodoPago;
    private static int contadorDePedidos = 0; // Atributo estático para contar pedidos

    public Pedido(String codigoCompra, Usuario comprador, Menu menuElegido, int metodoPago) {
        this.codigoCompra = codigoCompra;
        this.comprador = comprador;
        this.menuElegido = menuElegido;
        this.metodoPago = metodoPago;
        contadorDePedidos++; // Incrementar contador al crear un nuevo pedido
    }

    // Getters y setters
    public String getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(String codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public Menu getMenuElegido() {
        return menuElegido;
    }

    public void setMenuElegido(Menu menuElegido) {
        this.menuElegido = menuElegido;
    }

    public int getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(int metodoPago) {
        this.metodoPago = metodoPago;
    }

    public static int getContadorDePedidos() {
        return contadorDePedidos;
    }

    public void mostrarInformacionPedido() {
        System.out.println("===== Informacion del Pedido =====");
        System.out.println("Codigo de Pedido: " + codigoCompra);
        System.out.println("Comprador:");
        System.out.println("- Nombre: " + comprador.getNombre());
        System.out.println("- Apellido: " + comprador.getApellido());
        System.out.println("- Correo: " + comprador.getCorreo());
        System.out.println("- Tipo: " + comprador.getTipo());
        System.out.println("Menu Elegido: " + menuElegido.getNombre());
        System.out.println("Detalles del Menu:");

        // Mostrar platos del menú elegido
        System.out.println("- Entrada: " + menuElegido.getPlato(0));
        System.out.println("- Fondos: " + menuElegido.getEntrada(0));
        System.out.println("- Bebida: " + menuElegido.getBebida(0));

        // Mostrar precio total del menú elegido
        System.out.println("Precio Total: S/." + menuElegido.getPrecio());

        // Mostrar método de pago
        String metodoPagoString = "";
        switch (metodoPago) {
            case 1:
                metodoPagoString = "Tarjeta de Crédito";
                break;
            case 2:
                metodoPagoString = "Tarjeta de Débito";
                break;
            case 3:
                metodoPagoString = "Yape";
                break;
            case 4:
                metodoPagoString = "Tunki";
                break;
            case 5:
                metodoPagoString = "Plin";
                break;
            default:
                metodoPagoString = "No especificado";
                break;
        }
        System.out.println("Metodo de Pago: " + metodoPagoString);
        System.out.println("=================================");
    }

}
