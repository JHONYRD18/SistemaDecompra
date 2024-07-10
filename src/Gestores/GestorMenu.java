/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Raiz.Menu;
public class GestorMenu {
    private Menu[] menus;

    public GestorMenu(Menu[] menus) {
        this.menus = menus;
    }

    public void mostrarMenus() {
        System.out.println("\nInformacion de Menus:");
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public Menu[] getMenus() {
        return menus;
    }
}
