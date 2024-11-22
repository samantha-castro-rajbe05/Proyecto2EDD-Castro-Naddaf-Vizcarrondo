/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;





public class NodoArbol<T> {
    private T data;
    private NodoArbol<T> padre;
    private Lista<NodoArbol<T>> hijos;

    public NodoArbol(T data) {
        this.data = data;
        this.hijos = new Lista<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodoArbol<T> getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol<T> padre) {
        this.padre = padre;
    }

    public Lista<NodoArbol<T>> getHijos() {
        return hijos;
    }

    public void agregarHijo(NodoArbol<T> hijo) {
        hijo.setPadre(this);
        this.hijos.agregar(hijo);
    }
}




