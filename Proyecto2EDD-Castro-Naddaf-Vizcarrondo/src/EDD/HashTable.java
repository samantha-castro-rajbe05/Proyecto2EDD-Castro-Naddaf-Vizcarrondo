/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Persona.Persona;

/**
 *
 * @author samantha
 */
public class HashTable<K,V> {
    private class Entrada<K,V>{
        K clave;
        V valor;
        Entrada<K,V> pNext;
        
        public Entrada(K clave, V valor){
            this.clave = clave;
            this.valor = valor;
            this.pNext=null;
            
        }
    }
    private Entrada<K,V>[] tabla;
    private int capacidad;
    
    @SuppressWarnings("unchecked")
    public HashTable(int capacidad){
        this.capacidad = capacidad;
        this.tabla = new Entrada[capacidad];
    }
    private int obtenerIndiceHash(K clave){
        int hashcode = clave.hashCode();
        return Math.abs(hashcode)%capacidad;
        
    }
    public void agregarHash(K clave, V valor){
        int indice = obtenerIndiceHash(clave);
        Entrada<K,V> nuevaEntrada = new Entrada<>(clave,valor);
        
        if(tabla[indice]== null)
            tabla[indice]=nuevaEntrada;
        else{
            Entrada<K,V> actual = tabla[indice];
            while(actual.clave.equals(clave)){
                if(actual.clave.equals(clave)){
                    actual.valor= valor;
                    return;
                }
                if(actual.pNext==null)
                    break;
                actual = actual.pNext;
            }
            actual.pNext = nuevaEntrada;
        }
    }
    public V obtenerHash(K clave){
        int indice = obtenerIndiceHash(clave);
        Entrada<K,V> actual = tabla[indice];
        
        while(actual!= null){
            if(actual.clave.equals(clave))
                return actual.valor;
            actual=actual.pNext;
            
        }
        return null;
    }
    public Lista<V> obtenerValores(){
        Lista<V> valores = new Lista<>();
        for (int i = 0; i < capacidad; i++) {
            Entrada<K,V> actual = tabla[i];
            while(actual!= null){
                valores.Agregar(actual.valor);
                actual = actual.pNext;
            }
            
        }
        return valores;
    }
    public Lista<K> obtenerTodasLasClaves() {
    Lista<K> claves = new Lista<>();
    for (int i = 0; i < capacidad; i++) {
        Entrada<K, V> actual = tabla[i];
        while (actual != null) {
            claves.Agregar(actual.clave);
            actual = actual.pNext;
        }
    }
    return claves;
}

    
    //public String buscarNombre(String nombre){
        //validar si el nombre no esta en la lista de nombres, si no esta que salga un mensaje de error
        //recorrer arbol
        //agarrar los keys (nombres)
        //del value agarrar el value de la clave "of his name" (vamos a ponerle value3)
        //imprimir un numero + ". " + nombre + ". " value3 + "of his name"
        
       //Lista listaNombres = new Lista();
        
        //if (nombre
        
    //}
    
}
