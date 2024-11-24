/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cargas;
import EDD.Arbol;
import EDD.NodoA;
import EDD.TablaHash;
import Principal.Persona;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author samantha
 */
public class CargarJSON {
    private Arbol arbolGenealogico; // Estructura para almacenar el árbol
    private TablaHash tablaPersonas; // Tabla hash para búsqueda rápida
    private String linaje; // Nombre de la familia o linaje
    private boolean padresFaltantes; // Indica si se encontraron referencias a padres inexistentes
    private boolean duplicados; // Indica si se encontraron duplicados en los datos

    /**
     * Constructor por defecto. Inicializa las estructuras y los indicadores.
     */
    public CargarJSON() {
        this.arbolGenealogico = new Arbol();
        this.tablaPersonas = new TablaHash(100);
        this.linaje = null;
        this.padresFaltantes = false;
        this.duplicados = false;
    }

    // Getters y Setters
    public Arbol getArbolGenealogico() {
        return arbolGenealogico;
    }

    public void setArbolGenealogico(Arbol arbolGenealogico) {
        this.arbolGenealogico = arbolGenealogico;
    }

    public TablaHash getTablaPersonas() {
        return tablaPersonas;
    }

    public void setTablaPersonas(TablaHash tablaPersonas) {
        this.tablaPersonas = tablaPersonas;
    }

    public String getLinaje() {
        return linaje;
    }

    public void setLinaje(String linaje) {
        this.linaje = linaje;
    }

    public boolean isPadresFaltantes() {
        return padresFaltantes;
    }

    public void setPadresFaltantes(boolean padresFaltantes) {
        this.padresFaltantes = padresFaltantes;
    }

    public boolean isDuplicados() {
        return duplicados;
    }

    public void setDuplicados(boolean duplicados) {
        this.duplicados = duplicados;
    }

    /**
     * Carga un archivo JSON y procesa los datos en un único bucle, llenando el árbol y la tabla hash.
     * 
     * @param rutaArchivo la ruta del archivo JSON a cargar
     * @throws FileNotFoundException si el archivo no existe
     */
    public void cargarDesdeJSON(String rutaArchivo) throws FileNotFoundException {
        // Leer el archivo JSON
        FileReader lector = new FileReader(rutaArchivo);
        Gson gson = new Gson();
        JsonObject datosJson = gson.fromJson(lector, JsonObject.class);

        // Procesar cada linaje (familia)
        for (String nombreFamilia : datosJson.keySet()) {
            this.linaje = nombreFamilia; // Guardar el nombre del linaje
            JsonArray miembros = datosJson.getAsJsonArray(nombreFamilia);

            // Procesar cada miembro de la familia
            for (JsonElement miembro : miembros) {
                JsonObject registro = miembro.getAsJsonObject();
                procesarPersona(registro); // Insertar en el árbol y en la tabla hash
            }
        }
    }

    /**
     * Procesa una persona representada en JSON, cargándola en el árbol y la tabla hash.
     * 
     * @param registroJson el objeto JSON que representa a la persona
     */
    private void procesarPersona(JsonObject registroJson) {
        // Obtener el nombre completo como clave principal
        String nombreCompleto = registroJson.keySet().iterator().next();
        JsonArray detalles = registroJson.getAsJsonArray(nombreCompleto);

        // Crear una instancia de Persona
        Persona persona = new Persona(nombreCompleto);
        asignarAtributos(persona, detalles);

        // Insertar en la tabla hash
        if (this.tablaPersonas.buscar(persona.getNombreUnico()) == null) {
            this.tablaPersonas.agregar(persona.getNombreUnico(), persona);
        } else {
            this.duplicados = true; // Marcar si se encuentra un duplicado
        }

        // Insertar en el árbol genealógico
        if (this.arbolGenealogico.buscarPorNombre(persona.getNombreUnico()) == null) {
            if (this.arbolGenealogico.estaVacio()) {
                this.arbolGenealogico.crearRaiz(persona);
            } else {
                insertarEnArbol(persona);
            }
        } else {
            this.duplicados = true; // Marcar duplicados si ya existe en el árbol
        }
    }

    /**
     * Inserta una persona en el árbol genealógico.
     * 
     * @param persona la persona a insertar
     */
    private void insertarEnArbol(Persona persona) {
        String nombrePadre = persona.getPadre();

        // Manejar casos especiales del nombre del padre
        if (nombrePadre != null && nombrePadre.contains("of his name")) {
            nombrePadre = nombrePadre.replace("of his name", "").replaceAll(",", "").trim();
            persona.setPadre(nombrePadre);
        }

        // Verificar si el padre existe en el árbol
        NodoA nodoPadre = this.arbolGenealogico.buscarPorNombre(nombrePadre);
        if (nodoPadre != null) {
            this.arbolGenealogico.agregarHijo(nodoPadre, persona);
        } else {
            this.padresFaltantes = true; // Marcar si el padre no existe
        }
    }

    /**
     * Asigna atributos a una persona desde los detalles en formato JSON.
     * 
     * @param persona la persona a la que se asignarán los atributos
     * @param detalles los detalles en formato JSON
     */
    private void asignarAtributos(Persona persona, JsonArray detalles) {
        for (JsonElement elemento : detalles) {
            JsonObject atributo = elemento.getAsJsonObject();

            // Asignar atributos basados en las claves del JSON
            if (atributo.has("Of his name")) {
                persona.setNumeral(atributo.get("Of his name").getAsString());
            } else if (atributo.has("Born to")) {
                if (persona.getPadre() == null) {
                    persona.setPadre(atributo.get("Born to").getAsString());
                } else {
                    persona.setMadre(atributo.get("Born to").getAsString());
                }
            } else if (atributo.has("Known throughout as")) {
                persona.setMote(atributo.get("Known throughout as").getAsString());
            } else if (atributo.has("Held title")) {
                persona.setTitulo(atributo.get("Held title").getAsString());
            } else if (atributo.has("Wed to")) {
                persona.setEsposa(atributo.get("Wed to").getAsString());
            } else if (atributo.has("Of eyes")) {
                persona.setColorOjos(atributo.get("Of eyes").getAsString());
            } else if (atributo.has("Of hair")) {
                persona.setColorCabello(atributo.get("Of hair").getAsString());
            } else if (atributo.has("Notes")) {
                persona.setComentVida(atributo.get("Notes").getAsString());
            } else if (atributo.has("Fate")) {
                persona.setComentMuerte(atributo.get("Fate").getAsString());
            }
        }
    }
}
