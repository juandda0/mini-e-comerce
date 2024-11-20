package org.juannn.easyshop.backend.models;

import org.juannn.easyshop.backend.datastructures.cola.Cola;

import java.util.ArrayList;

public class CarritoDeCompras {
    /*private Cola<Articulo> articulos;
    private double total;

    public CarritoDeCompras() {
        this.articulos = new Cola<>();
        this.total = 0.0;
    }

    // Método para agregar un artículo al carrito
    public void agregarArticulo(Articulo articulo) {
        if (articulo != null) {
            articulos.encolar(articulo);
            total += articulo.getPrecio();
        }
    }

    // Método para ver el primer artículo añadido al carrito
    public Articulo verPrimerArticulo() {
        return articulos.consultarFrente();
    }

    // Método para eliminar el primer artículo añadido del carrito
    public Articulo eliminarPrimerArticulo() {
        Articulo articulo = articulos.desencolar();
        if (articulo != null) {
            total -= articulo.getPrecio();
        }
        return articulo;
    }

    // Método para obtener el total del carrito
    public double obtenerTotal() {
        return total;
    }

    // Método para verificar si el carrito está vacío
    public boolean estaVacio() {
        return articulos.estaVacia();
    }

    // Método para obtener el número de artículos en el carrito
    public int obtenerCantidadArticulos() {
        return articulos.obtenerTamano();
    }

    // Método para obtener todos los artículos del carrito como un ArrayList
    public ArrayList<Articulo> obtenerArticulos() {
        ArrayList<Articulo> listaArticulos = new ArrayList<>();
        Cola<Articulo> colaAuxiliar = new Cola<>();
        
        // Desencolamos los artículos y los añadimos al ArrayList
        while (!articulos.estaVacia()) {
            Articulo articulo = articulos.desencolar();
            listaArticulos.add(articulo);
            colaAuxiliar.encolar(articulo);  // Volvemos a colocar el artículo en la cola
        }
        
        // Restauramos la cola original
        while (!colaAuxiliar.estaVacia()) {
            articulos.encolar(colaAuxiliar.desencolar());
        }
        
        return listaArticulos;
    }

    // Método para calcular el total del carrito considerando la cantidad de cada artículo
    public double calcularTotalConCantidad() {
        ArrayList<Articulo> listaArticulos = obtenerArticulos();
        double totalConCantidad = 0.0;
        
        for (Articulo articulo : listaArticulos) {
            // Suponemos que la cantidad de un artículo está representada en su atributo cantidad (si existe)
            int cantidad = articulo.getCantidad();  // Asegúrate de que el atributo cantidad esté en la clase Articulo
            totalConCantidad += articulo.getPrecio() * cantidad;
        }
        
        return totalConCantidad;
    }
    */
}
