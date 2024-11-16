/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

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
    
    
}
