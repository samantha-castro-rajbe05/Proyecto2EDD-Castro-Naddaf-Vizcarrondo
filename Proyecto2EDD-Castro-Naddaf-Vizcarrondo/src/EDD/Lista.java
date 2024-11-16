/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author samantha
 */
public class Lista<T> {
    
    private NodoLista<T> pFirst;
    private int size;
    
    

    /**
     * Constructor que inicializa la lista
     */
    public Lista() { //eliminamos los parametros
        this.pFirst = null;
        this.size = 0;
    }
//métodos getters y setters para los atributos pFirst y size
    /**
     * Obtiene el primer nodo de la lista.
     * @return El primer nodo.
     */
    public NodoLista getpFirst() {
        return pFirst;
    }
/**
 * Establece el nodo1 de la lista.
 * @param pFirst El nuevo nodo1.
 */
    public void setpFirst(NodoLista pFirst) {
        this.pFirst = pFirst;
    }
/**
 * Obtiene el tamaño de la lista
 * @return numero de elementos dentro de la lista
 */
    public int getSize() {
        return size;
    }
/**
 * Define tamaño de la lista
 * @param size nuevo tamaño de Lista.
 */
    public void setSize(int size) {
        this.size = size;
    }
    
    public void Agregar(T info){
        NodoLista<T> nuevonodo = new NodoLista<>(info);
        if(pFirst==null)
            pFirst= nuevonodo;
        else{
            NodoLista<T> actual = pFirst;
            while(actual.pNext!= null){
                actual = actual.pNext;
                
            }
            actual.pNext=nuevonodo;
        }
        size++;
        
        
    }
    public T obtener(int indice){
        if(indice<0||indice>=size)
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        NodoLista<T> actual = pFirst;
        for (int i = 0; i < indice; i++) {
            actual = actual.pNext;
        }
        return actual.info;
    }
}
