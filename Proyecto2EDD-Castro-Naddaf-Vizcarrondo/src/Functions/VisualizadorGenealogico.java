package Functions;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class VisualizadorGenealogico {

    public Graph convertirArbolAGrafo(Arbol<Persona> arbol) {
        Graph grafo = new SingleGraph("Genealogía");

        // Añadir nodos y aristas recursivamente
        agregarNodoAlGrafo(arbol.getRaiz(), grafo);

        // Configuración opcional del grafo
        grafo.addAttribute("ui.stylesheet", estiloCSS());
        grafo.addAttribute("ui.quality");
        grafo.addAttribute("ui.antialias");

        return grafo;
    }

    private void agregarNodoAlGrafo(NodoArbol<Persona> nodoActual, Graph grafo) {
        if (nodoActual == null) {
            return;
        }

        String idNodo = generarIdNodo(nodoActual.getData());

        // Añadir el nodo al grafo si no existe
        if (grafo.getNode(idNodo) == null) {
            Node node = grafo.addNode(idNodo);
            node.addAttribute("ui.label", nodoActual.getData().getNombre());
        }

        // Recorrer los hijos
        for (NodoArbol<Persona> hijo : nodoActual.getHijos()) {
            String idHijo = generarIdNodo(hijo.getData());

            // Añadir el hijo al grafo si no existe
            if (grafo.getNode(idHijo) == null) {
                Node nodeHijo = grafo.addNode(idHijo);
                nodeHijo.addAttribute("ui.label", hijo.getData().getNombre());
            }

            // Añadir la arista entre el nodo actual y el hijo
            String idArista = idNodo + "-" + idHijo;
            if (grafo.getEdge(idArista) == null) {
                grafo.addEdge(idArista, idNodo, idHijo, true);
            }

            // Llamada recursiva para los descendientes
            agregarNodoAlGrafo(hijo, grafo);
        }
    }

    private String generarIdNodo(Persona persona) {
        String id = persona.getNombre();
        if (persona.getNumeroNombre() != null && !persona.getNumeroNombre().isEmpty()) {
            id += " " + persona.getNumeroNombre();
        }
        return id;
    }

    private String estiloCSS() {
        // Personaliza el estilo del grafo aquí
        return "node {" +
                "   fill-color: lightblue;" +
                "   size: 20px;" +
                "   text-size: 14px;" +
                "}" +
                "edge {" +
                "   fill-color: gray;" +
                "}";
    }
}
