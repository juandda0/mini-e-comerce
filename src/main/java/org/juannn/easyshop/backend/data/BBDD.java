package org.juannn.easyshop.backend.data;

import org.juannn.easyshop.backend.models.Usuario;
import java.util.HashMap;
import java.util.Map;

public class BBDD {
    // Mapa que simula la base de datos de usuarios (clave: email, valor: Usuario)
    private static Map<String, Usuario> usuarios = new HashMap<>();
    private static int idCounter = 1; // Contador para generar IDs únicos para los usuarios

    // Método para registrar un nuevo usuario
    public static boolean registrarUsuario(String nombre, String email, String contrasena) {
        // Verificar si el correo ya está registrado
        if (usuarios.containsKey(email)) {
            System.out.println("El correo electrónico ya está registrado.");
            return false;
        }

        // Crear un nuevo usuario
        Usuario nuevoUsuario = new Usuario(idCounter++, nombre, email, contrasena);
        
        // Guardar el usuario en la "base de datos"
        usuarios.put(email, nuevoUsuario);
        System.out.println("Usuario registrado exitosamente.");
        return true;
    }

    // Método para hacer login de un usuario
    public static Usuario login(String email, String contrasena) {
        Usuario usuario = usuarios.get(email); // Buscar el usuario por el correo

        if (usuario == null) {
            System.out.println("No se encontró un usuario con ese correo.");
            return null;
        }

        // Verificar si la contraseña es correcta
        if (usuario.getContrasena().equals(contrasena)) {
            System.out.println("Login exitoso.");
            return usuario; // Login exitoso
        } else {
            System.out.println("Contraseña incorrecta.");
            return null; // Contraseña incorrecta
        }
    }
}
