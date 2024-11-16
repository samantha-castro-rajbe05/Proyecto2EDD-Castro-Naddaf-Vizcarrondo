/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author PeterNaddaf
 */
public class NodoLista<T> {
    T info;
    NodoLista<T> pNext;
    
    public NodoLista(T info){
        this.info= info;
        this.pNext=null;
    }
    
    
}

