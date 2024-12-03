package org.juannn.easyshop.backend.models;

import java.io.Serializable;

public class Producto implements Serializable {

    private int id;
    private String nombre;
    private double precio;
    private String imageRut;
    private String category;
    private int stock;

    public Producto(int id, String nombre, double precio, String imageRut, String category, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imageRut = imageRut;
        this.category = category;
        this.stock = stock;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImageRut() {
        return imageRut;
    }

    public void setImageRut(String imageRut) {
        this.imageRut = imageRut;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio + ", Categoría: " + category + ", Stock: " + stock;
    }


}
