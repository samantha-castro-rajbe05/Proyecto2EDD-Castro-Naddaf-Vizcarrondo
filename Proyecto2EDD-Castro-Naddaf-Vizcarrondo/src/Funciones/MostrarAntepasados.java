/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;
import EDD.Lista;
import EDD.Nodo;
import Interfaces.Antepasados;
import Principal.Persona;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

/**
 *Clase para mostrar una lista de antepasados utilizando GraphStream. Los nodos
representan a las personas y las conexiones muestran relaciones parentales.
 * @author vizca
 */
public class MostrarAntepasados extends JFrame {
    private Lista antepasados; // Lista de antepasados a visualizar
    private Viewer visor; // Visor de GraphStream
    private ViewPanel panelVista; // Panel de visualización del grafo
    private Antepasados anteP;

    /**
     * Constructor que inicializa el visualizador con una lista de antepasados
     * específica.
     *
     * @param antepasados lista de antepasados a visualizar
     * @param anteP
     */
    public MostrarAntepasados(Lista antepasados, Antepasados anteP) {
        this.antepasados = antepasados;
        this.anteP = anteP;
        this.anteP.setVisible(false); 
        configurarInterfaz();
        inicializarVisor();
    }

    /**
     * Configura la interfaz principal de la ventana.
     */
    private void configurarInterfaz() {
        setTitle("Visualizador de Antepasados");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Agregar un evento al cerrar la ventana
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                cerrarVisor(); // Cerrar el visor de GraphStream
                volver();   // Abrir el JFrame del menú principal
            }
        });
    }

    /**
     * Inicializa el visor utilizando GraphStream y construye el grafo.
     */
    private void inicializarVisor() {
        Graph grafo = new MultiGraph("Antepasados");
        construirGrafo(grafo);

        // Mostrar el grafo dentro de la ventana
        visor = grafo.display(false); // Evitar la ventana adicional
        visor.enableAutoLayout();

        // Crear el panel de visualización si no existe ya
        if (panelVista == null) {
            panelVista = (ViewPanel) visor.getDefaultView();
            add(panelVista, BorderLayout.CENTER);
        }
    }

    /**
     * Construye el grafo visual a partir de la lista de antepasados.
     *
     * @param grafo el grafo donde se añadirán los nodos y las aristas
     */
    private void construirGrafo(Graph grafo) {
        if (antepasados == null || antepasados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay antepasados para mostrar.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Nodo aux = antepasados.getpFirts(); // Nodo inicial de la lista de antepasados
        Node nodoAnterior = null;

        while (aux != null) {
            Persona persona = (Persona) aux.getDato();
            String id = persona.getNombreUnico();

            // Crear nodo si no existe
            if (grafo.getNode(id) == null) {
                Node nodoActual = grafo.addNode(id);
                nodoActual.setAttribute("ui.label", persona.getNombreUnico());
                nodoActual.setAttribute("ui.style", "fill-color: rgb(0, 102, 204); size: 25px; text-alignment: center;"); // Azul oscuro
            }

            // Conectar con el nodo anterior, si existe
            if (nodoAnterior != null && grafo.getEdge(nodoAnterior.getId() + "-" + id) == null) {
                grafo.addEdge(nodoAnterior.getId() + "-" + id, nodoAnterior.getId(), id);
            }

            // Pasar al siguiente nodo en la lista
            nodoAnterior = grafo.getNode(id);
            aux = aux.getpNext();
        }

        // Configuración global del estilo del grafo
        grafo.setAttribute("ui.stylesheet",
                "node { text-size: 16px; }"
                + "edge { size: 2px; }");
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

    
    private void volver() {
        this.anteP.setVisible(true); 
    }
}
