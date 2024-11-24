/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Principal.Persona;
/**
 *
 * @author vizca
 */
public class NodoA {
    private Persona persona; // Objeto Persona asociado a este nodo
    private NodoA padre; // Referencia al nodo padre
    private Lista hijos; // Lista de hijos del nodo

    /**
     * Constructor que inicializa un nodo con una persona.
     *
     * @param persona la persona asociada al nodo
     */
    public NodoA(Persona persona) {
        this.persona = persona;
        this.padre = null;
        this.hijos = new Lista();
    }

    // Getters y Setters
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public NodoA getPadre() {
        return padre;
    }

    public void setPadre(NodoA padre) {
        this.padre = padre;
    }

    public Lista getHijos() {
        return hijos;
    }

    public void setHijos(Lista hijos) {
        this.hijos = hijos;
    }

    /**
     * Agrega un nodo hijo al actual. Si ya existe un hijo con la misma persona,
     * no lo agrega.
     *
     * @param hijo el nodo hijo a agregar
     */
    public void agregarHijo(NodoA hijo) {
        if (!this.tieneHijo(hijo.getPersona())) {
            hijo.setPadre(this); // Establecer la referencia al nodo padre
            this.hijos.insertFinale(hijo); // Agregar el hijo a la lista
        }
    }

    /**
     * Verifica si este nodo ya tiene un hijo con la persona especificada.
     *
     * @param persona la persona a buscar entre los hijos
     * @return true si ya existe un hijo con la misma persona, false en caso
     * contrario
     */
    public boolean tieneHijo(Persona persona) {
        Nodo aux = this.hijos.getpFirts(); // Primer nodo en la lista de hijos

        while (aux != null) {
            NodoA nodoHijo = (NodoA) aux.getDato();
            if (nodoHijo.getPersona().getNombreUnico().equalsIgnoreCase(persona.getNombreUnico())) {
                return true; // Existe un hijo con la misma persona
            }
            aux = aux.getpNext();
        }

        return false;
    }

    /**
     * Verifica si el nodo es una hoja (no tiene hijos).
     *
     * @return true si el nodo no tiene hijos, false en caso contrario
     */
    public boolean esHoja() {
        return this.hijos.isEmpty();
    }

    /**
     * Devuelve una representación en texto del nodo, mostrando el nombre de la
     * persona asociada.
     *
     * @return una cadena con el nombre único de la persona
     */
    @Override
    public String toString() {
        return "Persona:" + persona.getNombreUnico();
    }
}
