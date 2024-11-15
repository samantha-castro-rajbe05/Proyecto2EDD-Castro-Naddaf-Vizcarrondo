/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author samantha
 */
public class Lista {
    
    private Nodo pFirst;
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
    public Nodo getpFirst() {
        return pFirst;
    }
/**
 * Establece el nodo1 de la lista.
 * @param pFirst El nuevo nodo1.
 */
    public void setpFirst(Nodo pFirst) {
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
}
