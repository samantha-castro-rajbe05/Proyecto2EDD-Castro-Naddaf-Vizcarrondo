/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import EDD.Arbol;
import EDD.NodoA;
import Interfaces.BuscarPorNombre;
import Principal.Persona;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
/**
 *
 * @author PeterNaddaf
 */


/**
 *
 * @author Moises Liota
 */
public class MostrarDescendencia extends JFrame{
    private Arbol arbol; 
    private Viewer visor;
    private ViewPanel panelVista;
    private BuscarPorNombre buscarNombre;

    
    public MostrarDescendencia(Arbol arbol, BuscarPorNombre buscarNombre) {
        this.arbol = arbol;
        this.buscarNombre = buscarNombre;
        buscarNombre.setVisible(false);
        configurarInterfaz();
        inicializarVisor();
    }

    
    private void configurarInterfaz() {
        setTitle("Visualizador de Árbol Genealógico");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Agregar un evento al cerrar la ventana
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                cerrarVisor(); // Cerrar el visor de GraphStream
                volverDescendencia();   // Abrir el JFrame del menú principal
            }
        });
    }

   
    private void inicializarVisor() {
        Graph arbolVisual = new MultiGraph("Árbol Genealógico");
        construirArbol(arbolVisual);

        // Mostrar el árbol sin crear una nueva ventana
        visor = arbolVisual.display(false);
        visor.enableAutoLayout();

        // Crear el panel de visualización si no existe ya
        if (panelVista == null) {
            panelVista = (ViewPanel) visor.getDefaultView();
            add(panelVista, BorderLayout.CENTER);
        }
    }

    
    private void construirArbol(Graph arbolVisual) {
        if (arbol.estaVacio()) {
            JOptionPane.showMessageDialog(this, "El árbol está vacío.");
            return;
        }

        // Crear nodos y relaciones
        agregarNodoYSubarbol(arbol.getRaiz(), null, arbolVisual);

        // Configuración del estilo del grafo
        arbolVisual.setAttribute("ui.stylesheet",
                "node { text-size: 14px; size: 30px; text-alignment: center; fill-color: rgb(173, 216, 230); }"
                + "edge { size: 2px; }");
    }

    /**
     * Agrega un nodo y sus subnodos al grafo visual de manera recursiva.
     *
     * @param nodoActual el nodo actual del árbol
     * @param padreId el identificador del nodo padre, o null si es la raíz
     * @param arbolVisual el grafo donde se agregarán los nodos
     */
    private void agregarNodoYSubarbol(NodoA nodoActual, String padreId, Graph arbolVisual) {
        Persona persona = nodoActual.getPersona();
        String nodoId = persona.getNombreUnico();

        // Verificar si el nodo ya existe en el grafo
        if (arbolVisual.getNode(nodoId) == null) {
            org.graphstream.graph.Node nodoVisual = arbolVisual.addNode(nodoId);
            nodoVisual.setAttribute("ui.label", persona.getNombreUnico());
            nodoVisual.setAttribute("persona", persona);
        }

        // Crear la relación (arista) con el nodo padre
        if (padreId != null && arbolVisual.getEdge(padreId + "-" + nodoId) == null) {
            arbolVisual.addEdge(padreId + "-" + nodoId, padreId, nodoId);
        }

        // Recorrer los hijos del nodo actual y agregarlos al grafo
        for (int i = 0; i < nodoActual.getHijos().getSize(); i++) {
            NodoA hijo = (NodoA) nodoActual.getHijos().getValor(i);
            agregarNodoYSubarbol(hijo, nodoId, arbolVisual);
        }
    }

    /**
     * Cierra el visor de GraphStream.
     */
    private void cerrarVisor() {
        if (visor != null) {
            visor.disableAutoLayout();
            visor.close();
        }
        if (panelVista != null) {
            remove(panelVista);
            panelVista = null;
        }
    }

    /**
     * Abre la ventana principal del menú.
     */
    private void volverDescendencia() {
        buscarNombre.setVisible(true); // Mostrar el menú
    }
}


