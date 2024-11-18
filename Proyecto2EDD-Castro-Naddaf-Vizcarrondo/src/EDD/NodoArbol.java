/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;





/**
 *
 * @author samantha
 */
public class NodoArbol<T> {
    
   private T info;
   private NodoArbol<T> padre;
   private Lista<NodoArbol<T>> hijos;
   

   /**
    * Crea un nuevo nodo con el dato
    * @param info Elemento que almacena el nodo
    */
    public NodoArbol(T info) {
        this.hijos = new Lista<>();
        this.info = info;
    }
/**
 * Regresa lo que se almacena en el nodo.
 * @return Elemento que almacena dato
 */
    //métodos getters y setters
    public T getInfo() {
        return info;
    }
/**
 * Define el dato que guarda el nodo
 * @param info El nuevo elemento a ser almacenado
 */
    public void setDato(T info) {
        this.info = info;
    }
/**
 * Regresa al padre en el arbol
 * @return Padre del nodo
 */
    public NodoArbol<T> getPadre() {
        return padre;
    }
/**
 * Define el padre del nodo
 * @param padre Nuevo padre.
 */
    public void setPadre(NodoArbol<T> padre) {
        this.padre = padre;
    }
    public Lista<NodoArbol<T>> getHijos(){
        return hijos;
    }
    public void agregarHijo(NodoArbol<T> hijo){
        hijo.setPadre(this);
        this.hijos.Agregar(hijo);
    }
    
   
}


