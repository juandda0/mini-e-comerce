package org.juannn.easyshop.backend.persistencia;

import org.juannn.easyshop.backend.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BBDD {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Producto> productos = new ArrayList<>();
    private static int siguienteId = 1; // Empezamos con ID 1
    private static Usuario usuarioLogeado;
    private static final String USUARIOS_FILE = "usuarios.ser";
    private static final String PRODUCTOS_FILE = "productos.ser";

    static {
        cargarUsuarios();
        cargarProductos();
    }

    // Cargar los usuarios desde archivo
    public static void cargarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USUARIOS_FILE))) {
            usuarios = (List<Usuario>) ois.readObject();
            // Obtener el siguiente ID
            if (!usuarios.isEmpty()) {
                siguienteId = usuarios.get(usuarios.size() - 1).getId() + 1;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo cargar los usuarios, iniciando con lista vacía.");
        }
    }

    // Guardar los usuarios en archivo
    public static void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USUARIOS_FILE))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    // Cargar los productos desde archivo
    public static void cargarProductos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRODUCTOS_FILE))) {
            productos = (List<Producto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo cargar los productos, iniciando con lista vacía.");
        }
    }

    // Guardar los productos en archivo
    public static void guardarProductos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PRODUCTOS_FILE))) {
            oos.writeObject(productos);
        } catch (IOException e) {
            System.out.println("Error al guardar productos: " + e.getMessage());
        }
    }

    // Obtener las listas de productos del usuario logueado
    public static List<Producto> getListaDeseos() {
        Usuario usuario = getUsuarioLogeado();
        return usuario != null ? usuario.getListaDeseos() : new ArrayList<>();
    }

    public static List<Producto> getHistorial() {
        Usuario usuario = getUsuarioLogeado();
        return usuario != null ? usuario.getHistorial() : new ArrayList<>();
    }

    public static List<Producto> getCarrito() {
        Usuario usuario = getUsuarioLogeado();
        return usuario != null ? usuario.getCarrito() : new ArrayList<>();
    }

    // Método para registrar un nuevo usuario
    public static boolean registrar(String nombre, String email, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return false; // El usuario ya existe
            }
        }
        Usuario nuevoUsuario = new Usuario(siguienteId++, nombre, email, contrasena);
        usuarios.add(nuevoUsuario);
        guardarUsuarios();  // Guardar después de agregar
        return true;
    }

    // Método para iniciar sesión
    public static Usuario login(String email, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getContrasena().equals(contrasena)) {
                usuarioLogeado = usuario;
                return usuario;
            }
        }
        return null;
    }

    // Obtener el usuario logueado
    public static Usuario getUsuarioLogeado() {
        return usuarioLogeado;
    }

    // Establecer el usuario logueado
    public static void setUsuarioLogeado(Usuario usuario) {
        usuarioLogeado = usuario;
    }

    // Obtener producto por ID
    public static Producto obtenerProductoPorId(int productoId) {
        for (Producto producto : productos) {
            if (producto.getId() == productoId) {
                return producto;
            }
        }
        return null;
    }

    // Métodos para agregar productos al carrito, lista de deseos e historial
    public static boolean agregarAlCarrito(Producto producto) {
        Usuario usuario = getUsuarioLogeado();
        if (usuario != null && producto != null) {
            List<Producto> carrito = usuario.getCarrito();
            if (!carrito.contains(producto)) {
                carrito.add(producto);
                guardarUsuarios();  // Guardar después de agregar
                return true;
            }
        }
        return false;
    }

    public static boolean agregarALaListaDeDeseos(Producto producto) {
        Usuario usuario = getUsuarioLogeado();
        if (usuario != null && producto != null) {
            List<Producto> listaDeseos = usuario.getListaDeseos();
            if (!listaDeseos.contains(producto)) {
                listaDeseos.add(producto);
                guardarUsuarios();  // Guardar después de agregar
                return true;
            }
        }
        return false;
    }

    public static boolean agregarAlHistorial(Producto producto) {
        Usuario usuario = getUsuarioLogeado();
        if (usuario != null && producto != null) {
            List<Producto> historial = usuario.getHistorial();
            if (!historial.contains(producto)) {
                historial.add(producto);
                guardarUsuarios();  // Guardar después de agregar
                return true;
            }
        }
        return false;
    }

    public static List<Producto> obtenerProductos() {
        return productos;
    }

    public static void limpiarCarrito() {
        Usuario usuario = getUsuarioLogeado();
        if (usuario != null) {
            usuario.getCarrito().clear();
            guardarUsuarios();  // Guardar después de limpiar
        }
    }

    public static boolean estaEnCarrito(Producto producto) {
        Usuario usuario = getUsuarioLogeado();
        if (usuario != null && producto != null) {
            return usuario.getCarrito().contains(producto);
        }
        return false;
    }

    public static boolean estaEnListaDeseos(Producto producto) {
        Usuario usuario = getUsuarioLogeado();
        if (usuario != null && producto != null) {
            return usuario.getListaDeseos().contains(producto);
        }
        return false;
    }

    public static boolean eliminarDelCarrito(Producto producto) {
        Usuario usuario = getUsuarioLogeado();
        if (usuario != null && producto != null) {
            List<Producto> carrito = usuario.getCarrito();
            if (carrito.contains(producto)) {
                carrito.remove(producto);
                guardarUsuarios();  // Guardar después de eliminar
                return true;
            }
        }
        return false;
    }

    public static boolean eliminarDeLaListaDeDeseos(Producto producto) {
        Usuario usuario = getUsuarioLogeado();
        if (usuario != null && producto != null) {
            List<Producto> listaDeseos = usuario.getListaDeseos();
            if (listaDeseos.contains(producto)) {
                listaDeseos.remove(producto);
                guardarUsuarios();  // Guardar después de eliminar
                return true;
            }
        }
        return false;
    }
}
