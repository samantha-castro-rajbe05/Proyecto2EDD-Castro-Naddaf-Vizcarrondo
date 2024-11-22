package Functions;
import EDD.Arbol;
import EDD.NodoArbol;
import Interfaces.Menu;
import Persona.Persona;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

public class VisualizadorGenealogico {
//    private Viewer visor;
//    private ViewPanel panelVista;
//    
//    /**
//     * Constructor que inicializa el visualizador con el grafo proporcionado.
//     *
//     * @param grafo el grafo que se va a visualizar.
//     */
//    
//    public VisualizadorGenealogico(Grafo grafo) {
//        this.grafo = grafo;
//        configurarInterfaz();
//        inicializarVisor();
//        agregarBotonRegresar();
//    }
//    /**
//     * Configura la interfaz gr&aacute;fica del visualizador.
//     */
//   private void configurarInterfaz() {
//        setTitle("Arbol");
//        setSize(800, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
//    }

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
    
//    /**
//     * Inicializa el visor del grafo y lo muestra en la interfaz.
//     */
//   
//    private void inicializarVisor() {
//        Graph grafoVisual = new SingleGraph("Arbol");
//        //construirGrafo(grafoVisual);
//
//        // Mostrar el grafo sin crear una nueva ventana
//        visor = grafoVisual.display(false);
//        visor.enableAutoLayout();  // Permitir que el layout se ajuste automáticamente
//
//        // Creamos el panel de visualización si no existe ya
//        if (panelVista == null) {
//            panelVista = (ViewPanel) visor.getDefaultView();  // Sin ventana adicional
//            add(panelVista, BorderLayout.CENTER);  // Añadir el panel al JFrame
//        }
//    }

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
    
//     /**
//     * Agrega un bot&oacute;n "Regresar" a la interfaz que permite cerrar el visor y volver al men&uacute principal.
//     */
//      private void agregarBotonRegresar() {
//        JButton botonRegresar = new JButton("Regresar");
//        botonRegresar.addActionListener(e -> {
//            cerrarVisor();
//            this.dispose();
//            // Simulación de abrir menú principal (suponiendo que ya exista una clase 'Menu')
//            Menu menuPrincipal = new Menu();
//            menuPrincipal.setVisible(true);
//        });
//        add(botonRegresar, BorderLayout.SOUTH);
//    }
//      /**
//     * Cierra el visor y elimina el panel de visualizaci&oacute;n de la interfaz.
//     */
//        private void cerrarVisor() {
//            if (visor != null) {
//                visor.disableAutoLayout();
//                visor.close();
//            }
//            if (panelVista != null) {
//                remove(panelVista);
//                panelVista = null;
//        }
//    }
}
