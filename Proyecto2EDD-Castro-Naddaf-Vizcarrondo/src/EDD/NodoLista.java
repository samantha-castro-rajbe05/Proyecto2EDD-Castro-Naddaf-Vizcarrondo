/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author PeterNaddaf
 */
public class NodoLista {
    Object data;
    NodoLista siguiente;

    public NodoLista(Object data) {
        this.data = data;
        this.siguiente = null;
    }
    
    /**
 * Regresa lo que se almacena en el nodo.
 * @return Elemento que almacena dato
 */
    //métodos getters y setters
    public Object getDato() {
        return data;
    }
/**
 * Define el dato que guarda el nodo
 * @param dato El nuevo elemento a ser almacenado
 */
    public void setDato(Object data) {
        this.data = data;
    }
/**
 * Regresa al siguiente nodo en la lista
 * @return Siguiente nodo
 */
    public NodoLista getpNext() {
        return siguiente;
    }
/**
 * Define el nodo siguiente de la lista
 * @param pNext Nuevo nodo.
 */
    public void setpNext(NodoLista pNext) {
        this.siguiente = siguiente;
    }
}


