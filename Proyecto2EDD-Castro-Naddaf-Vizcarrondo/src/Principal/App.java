/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;
import EDD.Arbol;
import EDD.Lista;
import EDD.NodoA;
import EDD.TablaHash;


/**
 * Clase principal de la aplicación que gestiona las estructuras principales: un árbol genealógico y una tabla hash.
 * 
 * Proporciona métodos para gestionar personas, realizar búsquedas, y obtener información de descendencia,
 * antepasados y generaciones.
 * 
 * @author vizca 
 *
 */
public class App {

    private TablaHash personasHash; // Tabla hash para almacenamiento rápido
    private Arbol arbolFamiliar;   // Árbol genealógico para organizar jerárquicamente
    private String linajeFamilia;  // Nombre del linaje o familia

    /**
     * Constructor por defecto. Inicializa las estructuras como vacías.
     */
    public App() {
        this.personasHash = new TablaHash(100); // Tamaño por defecto
        this.arbolFamiliar = new Arbol();
        this.linajeFamilia = "";
    }

    // Getters y Setters

    /**
     * Obtiene la tabla hash que almacena las personas.
     *
     * @return la tabla hash
     */
    public TablaHash getPersonasHash() {
        return personasHash;
    }

    /**
     * Establece la tabla hash con una nueva instancia.
     *
     * @param personasHash la nueva tabla hash
     */
    public void setPersonasHash(TablaHash personasHash) {
        this.personasHash = personasHash;
    }

    /**
     * Obtiene el árbol genealógico.
     *
     * @return el árbol familiar
     */
    public Arbol getArbolFamiliar() {
        return arbolFamiliar;
    }

    /**
     * Establece el árbol genealógico.
     *
     * @param arbolFamiliar el árbol familiar a establecer
     */
    public void setArbolFamiliar(Arbol arbolFamiliar) {
        this.arbolFamiliar = arbolFamiliar;
    }

    /**
     * Obtiene el nombre del linaje de la familia.
     *
     * @return el nombre del linaje
     */
    public String getLinajeFamilia() {
        return linajeFamilia;
    }

    /**
     * Establece el nombre del linaje de la familia.
     *
     * @param linajeFamilia el nombre del linaje
     */
    public void setLinajeFamilia(String linajeFamilia) {
        this.linajeFamilia = linajeFamilia;
    }

    // Métodos adicionales

    /**
     * Reinicia las estructuras, vaciando tanto la tabla hash como el árbol genealógico.
     */
    public void reiniciarEstructuras() {
        this.personasHash = new TablaHash(100); // Reinicia la tabla hash con el tamaño predeterminado
        this.arbolFamiliar = new Arbol();      // Reinicia el árbol genealógico
        this.linajeFamilia = "";               // Limpia el nombre del linaje
    }

    /**
     * Verifica si ambas estructuras (tabla hash y árbol) están vacías.
     *
     * @return true si están vacías, false en caso contrario
     */
    public boolean estructurasVacias() {
        return this.personasHash.estaVacia() && this.arbolFamiliar.estaVacio();
    }

    /**
     * Busca personas por nombre en la tabla hash.
     *
     * @param nombre el nombre a buscar
     * @return un arreglo de personas que coincidan con el nombre
     */
    public Persona[] buscarNombre(String nombre) {
        Lista resultados = this.personasHash.buscarPorNombre(nombre);

        if (!resultados.isEmpty()) {
            Persona[] resultadoBusq = new Persona[resultados.getSize()];
            for (int i = 0; i < resultados.getSize(); i++) {
                resultadoBusq[i] = (Persona) resultados.getValor(i);
            }

            return resultadoBusq;
        }

        return null;
    }

    /**
     * Muestra los resultados de una búsqueda por nombre en formato legible.
     *
     * @param resultado el arreglo de personas resultado de la búsqueda
     * @return una cadena con los resultados formateados
     */
    public String mostrarBusquedaNombre(Persona[] resultado) {
        String resultadoStr = "";
        for (int i = 0; i < resultado.length; i++) {
            if (resultado[i].getMote() != null) {
                resultadoStr += "Indice: " + i + ", Mote: " + resultado[i].getMote() + ", Nombre: " + resultado[i].getNombreNumeral() + "\n";
            } else {
                resultadoStr += "Indice: " + i + ", Nombre: " + resultado[i].getNombreNumeral() + "\n";
            }
        }

        return resultadoStr;
    }

    /**
     * Obtiene un subárbol que representa la descendencia de una persona.
     *
     * @param persona la persona cuya descendencia se desea obtener
     * @return un árbol genealógico que contiene la descendencia de la persona
     */
    public Arbol descendencia(Persona persona) {
        Arbol arbolDescendencia = new Arbol();
        arbolDescendencia.setRaiz(this.arbolFamiliar.buscarPorNombre(persona.getNombreUnico()));
        return arbolDescendencia;
    }

    /**
     * Busca personas por título en la tabla hash.
     *
     * @param titulo el título a buscar
     * @return un arreglo de personas que coincidan con el título
     */
    public Persona[] buscarTitulo(String titulo) {
        Lista resultados = this.personasHash.buscarPorTitulo(titulo);

        if (!resultados.isEmpty()) {
            Persona[] resultadoBusq = new Persona[resultados.getSize()];
            for (int i = 0; i < resultados.getSize(); i++) {
                resultadoBusq[i] = (Persona) resultados.getValor(i);
            }

            return resultadoBusq;
        }

        return null;
    }

    /**
     * Muestra los resultados de una búsqueda por título en formato legible.
     *
     * @param resultado el arreglo de personas resultado de la búsqueda
     * @return una cadena con los resultados formateados
     */
    public String mostrarBusquedaTitulo(Persona[] resultado) {
        String resultadoStr = "";
        for (int i = 0; i < resultado.length; i++) {
            resultadoStr += "Indice: " + i + ", Nombre Unico: " + resultado[i].getNombreUnico() + ", Titulo: " + resultado[i].getTitulo() + "\n";
        }

        return resultadoStr;
    }

    /**
     * Busca personas que coincidan únicamente por el nombre en la tabla hash.
     *
     * @param nombre el nombre a buscar
     * @return un arreglo de personas que coincidan con el nombre
     */
    public Persona[] buscarSoloNombre(String nombre) {
        Lista resultados = this.personasHash.buscarSoloNombre(nombre);

        if (!resultados.isEmpty()) {
            Persona[] resultadoBusq = new Persona[resultados.getSize()];
            for (int i = 0; i < resultados.getSize(); i++) {
                resultadoBusq[i] = (Persona) resultados.getValor(i);
            }

            return resultadoBusq;
        }

        return null;
    }

    /**
     * Muestra los resultados de una búsqueda solo por nombre en formato legible.
     *
     * @param resultado el arreglo de personas resultado de la búsqueda
     * @return una cadena con los resultados formateados
     */
    public String mostrarBusquedaSoloNombre(Persona[] resultado) {
        String resultadoStr = "";
        for (int i = 0; i < resultado.length; i++) {
            resultadoStr += "Indice: " + i + ", Nombre: " + resultado[i].getNombreNumeral() + "\n";
        }

        return resultadoStr;
    }

    /**
     * La funcion obtiene una lista de los antepasados de forma especifica.
     *
     * @param persona la persona cuyos antepasados se desean obtener
     * @return una lista con los antepasados
     */
    public Lista antepasados(Persona persona) {
        NodoA nodo = this.arbolFamiliar.buscarPorNombre(persona.getNombreUnico());
        return this.getArbolFamiliar().obtenerAntepasados(nodo);
    }

    /**
     * Genera una lista de generaciones disponibles en el árbol genealógico.
     *
     * @return una lista con los números de generación disponibles
     */
    public Lista generacionesDispo() {
        Lista generaciones = new Lista();
        int maxGen = this.arbolFamiliar.obtenerProfundidadMaxima();
        for (int i = 0; i < maxGen; i++) {
            generaciones.insertFinale(i + 1);
        }

        return generaciones;
    }

    /**
     * Busca personas en una generación específica del árbol genealógico.
     *
     * @param numGen el número de la generación a buscar
     * @return un arreglo de personas en esa generación
     */
    public Persona[] buscarGeneracion(int numGen) {
        Lista generacion = this.arbolFamiliar.obtenerPersonasEnNivel(numGen);
        if (!generacion.isEmpty()) {
            Persona[] resultadoBusq = new Persona[generacion.getSize()];
            for (int i = 0; i < generacion.getSize(); i++) {
                resultadoBusq[i] = (Persona) generacion.getValor(i);
            }

            return resultadoBusq;
        }
        return null;
    }

    /**
     * Muestra los resultados de una generación específica en formato legible.
     *
     * @param resultados el arreglo de personas en la generación
     * @param numeroGen el número de la generación
     * @return una cadena con los resultados formateados
     */
    public String mostrarGeneracion(Persona[] resultados, int numeroGen) {
        String resultadosStr = "Generacion: " + numeroGen;
        for (Persona resultado : resultados) {
            resultadosStr += resultado.toString() + "\n\n";
        }

        return resultadosStr;
    }
}

