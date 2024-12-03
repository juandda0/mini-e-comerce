package org.juannn.easyshop.backend.datastructures;

import java.io.Serializable;

public class Lista<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L; // Versión de serialización
    private Nodo<T> cabeza;

    // Constructor de la lista
    public Lista() {
        cabeza = null;
    }

    // Método para agregar un elemento al final de la lista
    public void insertarFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo; // Si la lista está vacía, el nuevo nodo es la cabeza
        } else {
            Nodo<T> actual = cabeza;
            // Recorrer hasta el último nodo
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo); // Enlazar el nuevo nodo al final de la lista
        }
    }

    // Método para eliminar un elemento de la lista
    public boolean eliminar(T dato) {
        if (cabeza == null) {
            return false; // Lista vacía
        }

        // Si el dato a eliminar está en la cabeza
        if (cabeza.getDato().equals(dato)) {
            cabeza = cabeza.getSiguiente();
            return true;
        }

        // Buscar el nodo a eliminar
        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato().equals(dato)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    return true;
            }
            actual = actual.getSiguiente();
        }

        return false; // El dato no fue encontrado
    }

    // Método para buscar un elemento en la lista
    public boolean buscar(T dato) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return true; // Elemento encontrado
            }
            actual = actual.getSiguiente();
        }
        return false; // Elemento no encontrado
    }

    // todo para mostrar todos los elementos de la lista
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }
}
