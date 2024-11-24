/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cargas;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase para abrir un selector de archivos que permite únicamente seleccionar archivos JSON.
 * @author samantha and vizca
 */
public class FileChooser {
    private JFrame ventana; // Ventana padre para mostrar el selector

    /**
     * Constructor que recibe la ventana padre donde se mostrará el selector.
     * 
     * @param ventana la ventana padre del selector
     */
    public FileChooser(JFrame ventana) {
        this.ventana = ventana;
    }

    /**
     * Abre un selector de archivos que permite únicamente seleccionar archivos JSON.
     * 
     * @return la ruta absoluta del archivo seleccionado, o null si no se seleccionó ningún archivo
     */
    public String abrirArchivo() {
        // Crear el selector de archivos
        JFileChooser selector = new JFileChooser();

        // Crear un filtro que solo permita archivos JSON
        FileNameExtensionFilter filtroJson = new FileNameExtensionFilter("Archivos JSON (*.json)", "json");
        selector.setFileFilter(filtroJson);
        selector.setAcceptAllFileFilterUsed(false); // Deshabilitar la opción "Todos los archivos"

        // Mostrar el selector de archivos y guardar la opción seleccionada
        int seleccion = selector.showOpenDialog(ventana);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = selector.getSelectedFile();

            // Validar si el archivo seleccionado tiene la extensión .json
            if (!archivoSeleccionado.getName().toLowerCase().endsWith(".json")) {
                JOptionPane.showMessageDialog(ventana, "Solo se permiten archivos con extensión .json.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            // Retornar la ruta del archivo seleccionado
            return archivoSeleccionado.getAbsolutePath();
        } else {
            // Mostrar mensaje si no se seleccionó un archivo
            JOptionPane.showMessageDialog(ventana, "No se ha seleccionado ningún archivo.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
}
