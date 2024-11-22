/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

/**
 *
 * @author PeterNaddaf
 */
import EDD.NodoArbol;
import EDD.NodoLista;
import Persona.Persona;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Node;

//public Graph Visualizador(Arbol<Persona> arbol) {
//    Graph grafo = new SingleGraph("Genealogía");
//
//    // Añadir nodos y aristas recursivamente
//    agregarNodoAlGrafo(arbol.getRaiz(), grafo);
//
//    // Configuración opcional del grafo
//    grafo.addAttribute("ui.stylesheet", "url('ruta/al/estilo.css')");
//    grafo.setAutoCreate(true);
//    grafo.setStrict(false);
//
//    return grafo;
//}
//
//private void agregarNodoAlGrafo(NodoArbol<Persona> nodoActual, Graph grafo) {
//    String idNodo = generarIdNodo(nodoActual.getInfo());
//
//    // Añadir el nodo al grafo si no existe
//    if (grafo.getNode(idNodo) == null) {
//        NodoArbol nodo = grafo.addNode(idNodo);
//        nodo.addAttribute("ui.label", nodoActual.getInfo().getNombre());
//    }
//
//    for (NodoArbol<Persona> hijo : nodoActual.getHijos()) {
//        String idHijo = generarIdNodo(hijo.getInfo());
//
//        // Añadir el hijo al grafo si no existe
//        if (grafo.getNode(idHijo) == null) {
//            NodoLista nodoHijo = grafo.addNode(idHijo);
//            NodoLista.addAttribute("ui.label", hijo.getInfo().getNombre());
//        }
//
//        // Añadir la arista entre el nodo actual y el hijo
//        String idArista = idNodo + "-" + idHijo;
//        if (grafo.getEdge(idArista) == null) {
//            grafo.addEdge(idArista, idNodo, idHijo, true);
//        }
//
//        // Llamada recursiva para los descendientes
//        agregarNodoAlGrafo(hijo, grafo);
//    }
//}
//
//private String generarIdNodo(Persona persona) {
//    String id = persona.getNombre();
//    if (persona.getNumeroNombre() != null) {
//        id += " " + persona.getNumeroNombre();
//    }
//    return id;
//}
