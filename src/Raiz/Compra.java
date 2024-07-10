
package Raiz;

public class Compra {
    
//  atributos
    private String codigoCompra;
    private String nombreComprador;
    private Menu menuComprado;
    private String metodoPago;

//  Constructor
    public Compra(String codigoCompra, String nombreComprador, Menu menuComprado, String metodoPago) {
        this.codigoCompra = codigoCompra;
        this.nombreComprador = nombreComprador;
        this.menuComprado = menuComprado;
        this.metodoPago = metodoPago;
    }

//  Inicio Getter
    public String getCodigoCompra() {
        return codigoCompra;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public Menu getMenuComprado() {
        return menuComprado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }
//  Fin Getter

    @Override
    public String toString() {
        return " " + "codigoCompra: " + codigoCompra + 
                ", nombreComprador: " + nombreComprador + 
                ", Nombre del" + menuComprado + 
                ", metodoPago: " + metodoPago;
    }
}
