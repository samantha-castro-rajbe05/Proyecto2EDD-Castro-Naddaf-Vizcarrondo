/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Arbol;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author samantha
 */


/**
 * Clase para mostrar un árbol genealógico utilizando GraphStream. Los nodos son
 * representados como gráficos con estilo personalizado.
 */

public class MostrarArbol {
    private Arbol arbol; // Estructura del árbol genealógico
    private Viewer visor; // Visor de GraphStream
    private ViewPanel panelVista; // Panel de visualización del grafo
    
    /**
     * Constructor que inicializa el visualizador con un árbol específico.
     *
     * @param arbol el árbol genealógico a visualizar
     */
    public MostrarArbol(Arbol arbol) {
        this.arbol = arbol;
        
    }
}
