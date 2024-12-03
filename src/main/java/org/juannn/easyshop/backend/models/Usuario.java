package org.juannn.easyshop.backend.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String email;
    private String contrasena;

    private List<Producto> listaDeseos;
    private List<Producto> carrito;
    private List<Producto> historial;

    public Usuario(int id, String nombre, String email, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.listaDeseos = new ArrayList<>();
        this.carrito = new ArrayList<>();
        this.historial = new ArrayList<>();
    }

    // Getters y Setters
    public List<Producto> getListaDeseos() {
        return listaDeseos;
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public List<Producto> getHistorial() {
        return historial;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setListaDeseos(List<Producto> listaDeseos) {
        this.listaDeseos = listaDeseos;
    }

    public void setCarrito(List<Producto> carrito) {
        this.carrito = carrito;
    }

    public void setHistorial(List<Producto> historial) {
        this.historial = historial;
    }
}
