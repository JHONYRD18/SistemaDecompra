
package Gestores;

import Clases.Usuario;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestorUsuario {

    public static Usuario buscarUsuarioPorCodigo(String codigo) {
        Usuario[] usuarios = {
            new Usuario("U25678954", "Juan", "Perez", "U25678954@utp.edu.pe", "Estudiante"),
            new Usuario("C25678954", "María", "Gomez", "C25678954@utp.edu.pe", "Maestro"),
            new Usuario("u25422957", "Nayeli", "Torres", "u25422957@utp.edu.pe", "Estudiante"),
            new Usuario("c41857620", "Carlos", "Flores", "c41857620@utp.edu.pe", "Maestro")
        };
        // Buscar el usuario por el código
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigoUniv().equals(codigo)) {
                return usuario; // Devolver el usuario encontrado
            }
        }
        return null;
    }

    public static Usuario crearUsuario(Scanner usuario) {
        String nombre = "";
        String apellido = "";
        String correo = "";

        Pattern NombreApellido = Pattern.compile("^[a-zA-Z ]{3,20}$");
        Pattern Correo = Pattern.compile("^[a-zA-Z0-9]+@(gmail|hotmail)\\.com$");

        while (true) {
            System.out.print("Ingrese su nombre: ");
            nombre = usuario.nextLine().trim();

            Matcher matcher = NombreApellido.matcher(nombre);
            if (matcher.matches()) {
                break;
            } else {
                System.out.println("Nombre inválido. Ingrese solo letras y espacios.");
            }
        }

        while (true) {
            System.out.print("Ingrese su apellido: ");
            apellido = usuario.nextLine().trim();

            Matcher matcher = NombreApellido.matcher(apellido);
            if (matcher.matches()) {
                break;
            } else {
                System.out.println("Apellido inválido. Ingrese solo letras y espacios.");
            }
        }

        while (true) {
            System.out.print("Ingrese su correo (gmail o hotmail): ");
            correo = usuario.nextLine().trim();

            Matcher matcher = Correo.matcher(correo);
            if (matcher.matches()) {
                break;
            } else {
                System.out.println("Correo inválido. Ingrese un correo válido de gmail o hotmail.");
            }
        }

        return new Usuario(nombre, apellido, correo, "Invitado");
    }
}
