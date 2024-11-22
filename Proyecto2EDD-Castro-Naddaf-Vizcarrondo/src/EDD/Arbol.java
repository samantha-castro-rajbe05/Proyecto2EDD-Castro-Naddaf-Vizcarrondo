/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Functions.CriterioBusqueda;

/**
 *
 * @author samantha
 */
public class Arbol<T> {
    private NodoArbol<T> raiz;

    public Arbol(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public void setRaiz(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }
    public NodoArbol<T> buscarNodoRecursivo(NodoArbol<T> actual, CriterioBusqueda<T> criterio){
        if(actual==null)
            return null;
        if(criterio.cumple(actual.getInfo()))
            return actual;
        Lista<NodoArbol<T>> hijos = actual.getHijos();
        int size = hijos.getSize();
        for (int i = 0; i<size; i++) {
            NodoArbol<T> hijo = hijos.obtener(i);
            NodoArbol resultado = buscarNodoRecursivo(hijo,criterio);
            if(resultado!=null)
                return resultado;
            
        }
        return null;
    }
            
            
    //Para buscar un nodo por un criterio
    public NodoArbol<T> BuscarPorCriterio(CriterioBusqueda<T> criterio){
        return buscarNodoRecursivo(raiz, criterio);
    }

    public NodoArbol<T> getRaiz() {
        return raiz;
    }
    
    
    
        
    }
    

    
    

