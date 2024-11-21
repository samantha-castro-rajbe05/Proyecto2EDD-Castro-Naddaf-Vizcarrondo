/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import EDD.Arbol;
import EDD.HashTable;
import EDD.NodoArbol;
import Persona.Persona;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class Cargar {
    private Arbol<Persona> arbolGenealogico;
    private HashTable<String, Persona> tablaPersonas;
    private Linaje linaje;

    public Cargar() {
        tablaPersonas = new HashTable<>(100);
    }
    
    public Linaje getLinaje(){
        return linaje;
    }

    public void cargarArchivoJSON(String rutaArchivo) {
        try {
            //Utilizamos Gson, una biblioteca para trabajar con JSON, para convertir el contenido del archivo en objetos Java.
            Gson gson = new Gson();
            //Creamos un FileReader para leer el archivo especificado por rutaArchivo.
            FileReader reader = new FileReader(rutaArchivo);

            // Leemos el JSON como un objeto genérico
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            // Obtenemos el linaje (casa)
            for (Map.Entry<String, JsonElement> entradaLinaje : jsonObject.entrySet()) {
                String nombreLinaje = entradaLinaje.getKey();
                linaje = new Linaje(nombreLinaje);
                JsonElement miembrosLinaje = entradaLinaje.getValue();

                // Procesamos la lista de miembros del linaje
                for (JsonElement miembroElement : miembrosLinaje.getAsJsonArray()) {
                    // Cada miembro es un objeto con un solo campo: el nombre de la persona
                    JsonObject miembroObject = miembroElement.getAsJsonObject();
                    for (Map.Entry<String, JsonElement> entradaMiembro : miembroObject.entrySet()) {
                        String nombrePersona = entradaMiembro.getKey();
                        JsonElement atributosPersona = entradaMiembro.getValue();

                        // Creamos la persona y la agregamos a la tabla hash
                        Persona persona = new Persona(nombrePersona);
                        tablaPersonas.agregarHash(nombrePersona, persona);

                        // Procesamos los atributos de la persona
                        for (JsonElement atributoElement : atributosPersona.getAsJsonArray()) {
                            JsonObject atributoObject = atributoElement.getAsJsonObject();
                            for (Map.Entry<String, JsonElement> entradaAtributo : atributoObject.entrySet()) {
                                String claveAtributo = entradaAtributo.getKey();
                                JsonElement valorAtributo = entradaAtributo.getValue();

                                // Procesamos cada atributo
                                procesarAtributoPersona(persona, claveAtributo, valorAtributo);
                            }
                        }
                    }
                }
            }

            // Después de cargar todas las personas, construimos el árbol genealógico
            construirArbolGenealogico();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void procesarAtributoPersona(Persona persona, String clave, JsonElement valor) {
        switch (clave) {
            case "Of his name":
                persona.setNumeroNombre(valor.getAsString());
                break;
            case "Born to":
                String padre = valor.getAsString();
                persona.setPadre(padre);
                break;
            case "Known throughout as":
                persona.setMote(valor.getAsString());
                break;
            case "Held title":
                persona.setTitulo(valor.getAsString());
                break;
            case "Wed to":
                persona.setConyuge(valor.getAsString());
                break;
            case "Of eyes":
                persona.setOjos(valor.getAsString());
                break;
            case "Of hair":
                persona.setCabello(valor.getAsString());
                break;
            case "Father to":
                // Lista de hijos
                if (valor.isJsonArray()) {
                    for (JsonElement hijoElement : valor.getAsJsonArray()) {
                        persona.agregarHijo(hijoElement.getAsString());
                    }
                } else {
                    persona.agregarHijo(valor.getAsString());
                }
                break;
            case "Notes":
                persona.agregarNota(valor.getAsString());
                break;
            case "Fate":
                persona.setDestino(valor.getAsString());
                break;
            // Puedes agregar más casos si hay otros atributos
            default:
                // Manejar atributos desconocidos si es necesario
                break;
        }
    }

    private void construirArbolGenealogico() {
        // Primero, identificamos a la persona sin padre (la raíz)
        Persona raizPersona = null;
        for (Persona persona : tablaPersonas.obtenerValores()) {
            if (persona.getPadre() == null || persona.getPadre().equals("[Unknown]")) {
                raizPersona = persona;
                break;
            }
        }

        if (raizPersona == null) {
            System.out.println("No se pudo encontrar la raíz del árbol genealógico.");
            return;
        }

        NodoArbol<Persona> nodoRaiz = new NodoArbol<>(raizPersona);
        arbolGenealogico = new Arbol<>(nodoRaiz);

        // Construimos el árbol recursivamente
        construirArbolRecursivo(nodoRaiz);
    }

    //Este método toma el nodo actual y busca sus hijos en la tabla hash.
    //Si encuentra un hijo, crea un nuevo nodo para él y llama recursivamente 
    //al mismo método para agregar los descendientes de ese hijo.
    private void construirArbolRecursivo(NodoArbol<Persona> nodoActual) {
        Persona personaActual = nodoActual.getInfo();
        for (String nombreHijo : personaActual.getHijos()) {
            Persona hijoPersona = tablaPersonas.obtenerHash(nombreHijo);
            if (hijoPersona != null) {
                NodoArbol<Persona> nodoHijo = new NodoArbol<>(hijoPersona);
                nodoActual.agregarHijo(nodoHijo);

                // Llamada recursiva para construir los descendientes del hijo
                construirArbolRecursivo(nodoHijo);
            }
        }
    }

    // Métodos adicionales para interactuar con el árbol y la tabla hash

    public Arbol<Persona> getArbolGenealogico() {
        return arbolGenealogico;
    }

    public HashTable<String, Persona> getTablaPersonas() {
        return tablaPersonas;
    }
    
       
}
