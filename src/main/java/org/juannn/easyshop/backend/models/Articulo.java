package org.juannn.easyshop.backend.models;

import java.util.Date;

public class Articulo {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;
    private String categoria;
    private Date fechaActualizacion;

    public Articulo(int id, String nombre, String descripcion, double precio, int stock, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = stock;
        this.categoria = categoria;
        this.fechaActualizacion = new Date(); // Fecha de creación o última actualización
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    // Método para actualizar cantidad
    public void actualizarCantidad(int cantidad) {
        this.cantidad += cantidad;
        this.fechaActualizacion = new Date(); // Actualiza la fecha cada vez que el cantidad cambia
    }

    // Método para actualizar el precio
    public void actualizarPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
        this.fechaActualizacion = new Date(); // Actualiza la fecha cada vez que el precio cambia
    }

    // Método para mostrar la información del artículo
    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + cantidad +
                ", categoria='" + categoria + '\'' +
                ", fechaActualizacion=" + fechaActualizacion +
                '}';
    }
}
