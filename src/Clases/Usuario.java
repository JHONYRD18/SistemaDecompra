/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Jhony RD
 */
public class Usuario {
    private String CodigoUniv;
    private String nombre;
    private String apellido;
    private String correo;
    private String tipo; // Puede ser "Estudiante" o "Maestro" para usuarios de universidad

    public Usuario(String CodigoUniv, String nombre, String apellido, String correo, String tipo) {
        this.CodigoUniv = CodigoUniv;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.tipo = tipo;
    }
    public Usuario(String nombre, String apellido, String correo, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.tipo = tipo;
    }

    public String getCodigoUniv() {
        return CodigoUniv;
    }

    public void setCodigoUniv(String CodigoUniv) {
        this.CodigoUniv = CodigoUniv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
