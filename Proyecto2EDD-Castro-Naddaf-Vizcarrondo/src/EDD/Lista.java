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
    private NodoLista cabeza;
    private int tamaño;

    public Lista() {
        this.cabeza = null;
        this.tamaño = 0;
    }
    public NodoLista getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoLista cabeza) {
        this.cabeza = cabeza;
    }
    
    public int getTamaño() {
        return tamaño;
    }
        
    public void agregar(T data) {
        NodoLista nuevoNodo = new NodoLista(data);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoLista actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamaño++;
    }


    public Object obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        NodoLista actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.data;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    @Override
    public Iterator iterator() {
        return new IteradorLista();
    }


    private class IteradorLista implements Iterator {
        private NodoLista actual;

        public IteradorLista() {
            this.actual = getCabeza();
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public Object next() {
            if (actual == null) {
                throw new NoSuchElementException();
            }
            Object data = actual.data;
            actual = actual.siguiente;
            return data;
        }
    }
    
    public Object getValor(int posicion){
        
        if(posicion  >= 0 && posicion < tamaño){
            
            if(posicion == 0){
                return this.cabeza.getDato();
            }else{
                NodoLista aux = this.cabeza;
                for(int i = 0; i < posicion; i++){
                    aux = aux.getpNext();
                }
                return aux.getDato();
            }
        }
        return null;
    }
    
    public boolean isEmpty() { //verifica si la lista esta vacia
        return cabeza == null;
    }
    
    public void insertFinale(Object dato) {
        NodoLista pNew = new NodoLista(dato);
        if (this.isEmpty()) { //si la lista esta vacia 
            this.setCabeza(pNew);
        } else {
            NodoLista aux = this.cabeza;//si la lista no esta vacia recorro la lista hasta el ultimo nodo 
            while (aux.getpNext() != null) {
                aux = aux.getpNext();//cambio el apuntador
            }
            aux.setpNext(pNew); //obtengo New
        }
        tamaño++;
    }
}

