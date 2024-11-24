/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Principal.Persona;
/**
 * Implementación alternativa de la clase Arbol.
 * Este árbol general permite organizar nodos jerárquicos, trabajar con niveles, 
 * buscar por nombre único y gestionar antepasados.
 * Los nodos están representados por la clase {@link NodoA}.

 * @author vizca
 */
public class Arbol {
    private NodoA raiz; // Nodo raíz del árbol

    /**
     * Constructor por defecto. Inicializa el árbol vacío.
     */
    public Arbol() {
        this.raiz = null;
    }
    /**
     * Retorna el nodo raíz del árbol.
     * 
     * @return la raíz del árbol
     */
    public NodoA getRaiz() {
        return raiz;
    }

    /**
     * Establece el nodo raíz del árbol.
     * 
     * @param raiz el nodo a establecer como raíz
     */
    public void setRaiz(NodoA raiz) {
        this.raiz = raiz;
    }

    /**
     * Verifica si el árbol está vacío.
     * 
     * @return true si no hay nodos en el árbol, false en caso contrario
     */
    public boolean estaVacio() {
        return this.raiz == null;
    }

    /**
     * Inicializa la raíz del árbol con una persona.
     * 
     * @param persona la persona que será la raíz
     */
    public void crearRaiz(Persona persona) {
        this.raiz = new NodoA(persona);
    }

    /**
     * Agrega un nuevo nodo como hijo de un nodo padre.
     * 
     * @param padre el nodo padre al que se agregará el hijo
     * @param persona la persona asociada al nodo hijo
     */
    public void agregarHijo(NodoA padre, Persona persona) {
        NodoA nuevoHijo = new NodoA(persona);
        nuevoHijo.setPadre(padre);
        padre.agregarHijo(nuevoHijo);
    }

    /**
     * Busca un nodo en el árbol por su nombre único.
     * 
     * @param nombreUnico el nombre único de la persona a buscar
     * @return el nodo que contiene la persona, o null si no se encuentra
     */
    public NodoA buscarPorNombre(String nombreUnico) {
        if (estaVacio()) {
            return null;
        }

        Cola cola = new Cola();
        cola.insert(raiz);

        while (!cola.isEmpty()) {
            NodoA actual = (NodoA) cola.delete();
            Persona persona = actual.getPersona();

            // Comparación por mote o nombre completo + numeral
            if (persona.getMote() != null && persona.getMote().equalsIgnoreCase(nombreUnico)) {
                return actual;
            }
            
            if (persona.getNombreNumeral().equalsIgnoreCase(nombreUnico)) {
                return actual;
            }

            // Encolar hijos
            Nodo hijo = actual.getHijos().getpFirts();
            while (hijo != null) {
                cola.insert(hijo.getDato());
                hijo = hijo.getpNext();
            }
        }

        return null;
    }

    /**
     * Imprime el árbol por niveles, mostrando cada nivel en orden.
     */
    public void imprimirPorNiveles() {
        if (estaVacio()) {
            System.out.println("El árbol está vacío.");
            return;
        }

        Cola cola = new Cola();
        cola.insert(raiz);
        StringBuilder resultado = new StringBuilder("Árbol por niveles:\n");

        while (!cola.isEmpty()) {
            NodoA actual = (NodoA) cola.delete();
            resultado.append(actual.getPersona().toString()).append("\n");

            // Encolar hijos
            Nodo hijo = actual.getHijos().getpFirts();
            while (hijo != null) {
                cola.insert(hijo.getDato());
                hijo = hijo.getpNext();
            }
        }

        System.out.println(resultado.toString());
    }

    /**
     * Calcula el nivel máximo (profundidad) del árbol.
     * 
     * @return el nivel máximo alcanzado en el árbol
     */
    public int obtenerProfundidadMaxima() {
        if (estaVacio()) {
            return 0;
        }

        int profundidadMax = 0;
        Cola colaNodos = new Cola();
        Cola colaNiveles = new Cola();

        colaNodos.insert(raiz);
        colaNiveles.insert(1);

        while (!colaNodos.isEmpty()) {
            NodoA actual = (NodoA) colaNodos.delete();
            int nivelActual = (int) colaNiveles.delete();

            profundidadMax = Math.max(profundidadMax, nivelActual);

            // Encolar hijos con su nivel
            Nodo hijo = actual.getHijos().getpFirts();
            while (hijo != null) {
                colaNodos.insert(hijo.getDato());
                colaNiveles.insert(nivelActual + 1);
                hijo = hijo.getpNext();
            }
        }

        return profundidadMax;
    }

    /**
     * Devuelve una lista con todas las personas en un nivel específico.
     * 
     * @param nivel el nivel que se desea obtener
     * @return una lista con las personas del nivel, o null si el nivel no existe
     */
    public Lista obtenerPersonasEnNivel(int nivel) {
        if (estaVacio() || nivel < 1) {
            return null;
        }

        Lista personasNivel = new Lista();
        Cola colaNodos = new Cola();
        Cola colaNiveles = new Cola();

        colaNodos.insert(raiz);
        colaNiveles.insert(1);

        while (!colaNodos.isEmpty()) {
            NodoA actual = (NodoA) colaNodos.delete();
            int nivelActual = (int) colaNiveles.delete();

            if (nivelActual == nivel) {
                personasNivel.insertFinale(actual.getPersona());
            }

            Nodo hijo = actual.getHijos().getpFirts();
            while (hijo != null) {
                colaNodos.insert(hijo.getDato());
                colaNiveles.insert(nivelActual + 1);
                hijo = hijo.getpNext();
            }
        }

        return personasNivel;
    }

    /**
     * Devuelve una lista con los antepasados de un nodo específico.
     * 
     * @param nodo el nodo cuyo linaje ascendente se desea obtener
     * @return una lista con los antepasados del nodo
     */
    public Lista obtenerAntepasados(NodoA nodo) {
        if (nodo == null) {
            return null;
        }

        Lista antepasados = new Lista();
        NodoA actual = nodo.getPadre();

        while (actual != null) {
            antepasados.insertFinale(actual.getPersona());
            actual = actual.getPadre();
        }

        return antepasados;
    }
}
