/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Raiz;

public class Menu {
    
//  atributos
    private String nombre;
    private double precio;

//  constructor
    public Menu(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

//  Inicio Getter
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
//  Fin Getter

    @Override
    public String toString() {
        return " " + "Menu: " + nombre + 
                ", Precio: S/. " + precio;
    }
}

