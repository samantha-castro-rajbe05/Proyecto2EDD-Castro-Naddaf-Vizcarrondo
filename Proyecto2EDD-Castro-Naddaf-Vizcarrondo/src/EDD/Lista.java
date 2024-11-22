/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import java.util.Iterator;
/**
 *
 * @author samantha
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Lista<T> implements Iterable<T> {
    private NodoLista<T> cabeza;
    private int tamaño;

    public Lista() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    public void agregar(T data) {
        NodoLista<T> nuevoNodo = new NodoLista<>(data);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoLista<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamaño++;
    }

    public int getTamaño() {
        return tamaño;
    }

    public T obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        NodoLista<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.data;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorLista();
    }

    private class IteradorLista implements Iterator<T> {
        private NodoLista<T> actual;

        public IteradorLista() {
            this.actual = cabeza;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (actual == null) {
                throw new NoSuchElementException();
            }
            T data = actual.data;
            actual = actual.siguiente;
            return data;
        }
    }
}

