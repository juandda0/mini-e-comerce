package org.juannn.easyshop.backend.datastructures.cola;

public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> finalCola;
    private int tamano;

    public Cola() {
        this.frente = null;
        this.finalCola = null;
        this.tamano = 0;
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Método para obtener el tamaño de la cola
    public int obtenerTamano() {
        return tamano;
    }

    // Método para agregar un elemento al final de la cola (Encolar)
    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = nuevoNodo;
        } else {
            finalCola.setSiguiente(nuevoNodo);
        }
        finalCola = nuevoNodo;
        tamano++;
    }

    // Método para eliminar y devolver el elemento al frente de la cola (Desencolar)
    // Devuelve null si la cola está vacía
    public T desencolar() {
        if (estaVacia()) {
            return null;
        }
        T dato = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            finalCola = null;
        }
        tamano--;
        return dato;
    }

    // Método para obtener el elemento al frente de la cola sin eliminarlo (Consultar)
    // Devuelve null si la cola está vacía
    public T consultarFrente() {
        if (estaVacia()) {
            return null;
        }
        return frente.getDato();
    }
}
