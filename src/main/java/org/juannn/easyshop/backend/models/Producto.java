package org.juannn.easyshop.backend.models;

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private String imageRut;
    private String category;

    /*private String descripcion;
    private int cantidad;
    private Date fechaActualizacion;
    */

    public Producto(int id, String nombre, double precio, String imageRut, String category/*, String descripcion, int stock, */) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imageRut = imageRut;
        this.category = category;
        /*this.descripcion = descripcion;
        this.cantidad = stock;

        this.fechaActualizacion = new Date(); // Fecha de creación o última actualización*/
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

    /*public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    */
}
