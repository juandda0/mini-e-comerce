package org.juannn.easyshop.backend.datastructures;

import java.io.Serializable;

public class Pila<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;  // Versión de serialización
    private Nodo<T> cima;

    // Constructor de la pila
    public Pila() {
        cima = null;
    }

    // Método para agregar un elemento a la pila
    public void apilar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguiente(cima);  // El siguiente del nuevo nodo es la cima actual
        cima = nuevoNodo;  // La cima se actualiza al nuevo nodo
    }

    // Método para eliminar el elemento superior de la pila
    public T desapilar() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        T dato = cima.getDato();
        cima = cima.getSiguiente();  // La cima se mueve al siguiente nodo
        return dato;
    }

    // Método para ver el elemento superior de la pila sin eliminarlo
    public T verCima() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return cima.getDato();
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return cima == null;
    }

    // Método para obtener el tamaño de la pila
    public int tamano() {
        int tamano = 0;
        Nodo<T> actual = cima;
        while (actual != null) {
            tamano++;
            actual = actual.getSiguiente();
        }
        return tamano;
    }
}
