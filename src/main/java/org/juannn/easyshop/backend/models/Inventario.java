package org.juannn.easyshop.backend.models;

import java.util.ArrayList;
import java.util.Date;

public class Inventario {
    private ArrayList<Articulo> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // Método para agregar un artículo al inventario
    public void agregarArticulo(Articulo articulo) {
        if (articulo != null) {
            productos.add(articulo);
        }
    }

    // Método para buscar un artículo por su ID
    public Articulo buscarArticuloPorId(int id) {
        for (Articulo articulo : productos) {
            if (articulo.getId() == id) {
                return articulo;
            }
        }
        return null;  // Retorna null si no lo encuentra
    }

    // Método para actualizar un artículo en el inventario por su ID
    public boolean actualizarArticulo(int id, String nuevoNombre, String nuevaDescripcion, double nuevoPrecio, int nuevaCantidad, String nuevaCategoria) {
        Articulo articulo = buscarArticuloPorId(id);
        if (articulo != null) {
            articulo.setNombre(nuevoNombre);
            articulo.setDescripcion(nuevaDescripcion);
            articulo.setPrecio(nuevoPrecio);
            articulo.setCantidad(nuevaCantidad);
            articulo.setCategoria(nuevaCategoria);
            articulo.setFechaActualizacion(new Date());  // Actualiza la fecha de modificación
            return true;  // Retorna true si se actualizó correctamente
        }
        return false;  // Retorna false si no encontró el artículo con ese ID
    }

    // Método para eliminar un artículo del inventario por su ID
    public boolean eliminarArticulo(int id) {
        Articulo articulo = buscarArticuloPorId(id);
        if (articulo != null) {
            productos.remove(articulo);
            return true;  // Retorna true si se eliminó correctamente
        }
        return false;  // Retorna false si no encontró el artículo con ese ID
    }

    // Método para obtener todos los artículos del inventario
    public ArrayList<Articulo> obtenerTodosLosArticulos() {
        return new ArrayList<>(productos);
    }

    // Método para obtener el tamaño del inventario (número de productos)
    public int obtenerTamano() {
        return productos.size();
    }
}
