/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import EDD.Arbol;
import EDD.HashTable;
import EDD.Lista;
import EDD.NodoArbol;
import Persona.Persona;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Cargar {
    private Arbol<Persona> arbolGenealogico;
    private HashTable<String, Persona> tablaPersonas;
    private String nombreLinaje;

    public Cargar() {
        tablaPersonas = new HashTable<>(200); // Ajusta la capacidad según sea necesario
    }

    public void cargar(String rutaArchivo) {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(rutaArchivo);

            // Leemos el JSON como un objeto genérico
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            // Obtenemos el linaje (casa)
            for (Map.Entry<String, JsonElement> entradaLinaje : jsonObject.entrySet()) {
                nombreLinaje = entradaLinaje.getKey();
                JsonArray miembrosLinaje = entradaLinaje.getValue().getAsJsonArray();

                // Procesamos la lista de miembros del linaje
                for (JsonElement miembroElement : miembrosLinaje) {
                    // Cada miembro es un objeto con un solo campo: el nombre de la persona
                    JsonObject miembroObject = miembroElement.getAsJsonObject();
                    for (Map.Entry<String, JsonElement> entradaMiembro : miembroObject.entrySet()) {
                        String nombrePersona = entradaMiembro.getKey();
                        JsonArray atributosPersona = entradaMiembro.getValue().getAsJsonArray();

                        // Creamos la persona
                        Persona persona = new Persona(nombrePersona);

                        // Procesamos los atributos de la persona
                        for (JsonElement atributoElement : atributosPersona) {
                            JsonObject atributoObject = atributoElement.getAsJsonObject();
                            for (Map.Entry<String, JsonElement> entradaAtributo : atributoObject.entrySet()) {
                                String claveAtributo = entradaAtributo.getKey();
                                JsonElement valorAtributo = entradaAtributo.getValue();

                                // Procesamos cada atributo
                                procesarAtributoPersona(persona, claveAtributo, valorAtributo);
                            }
                        }

                        // Agregamos la persona a la tabla hash usando una clave única
                        String clavePersona = generarClaveUnica(persona);
                        tablaPersonas.agregar(clavePersona, persona);
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
                if (!padre.equals("[Unknown]")) {
                    persona.setPadre(padre);
                }
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
        Lista<Persona> listaPersonas = tablaPersonas.obtenerTodosLosValores();
        for (Persona persona : listaPersonas) {
            if (persona.getPadre() == null) {
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

    private void construirArbolRecursivo(NodoArbol<Persona> nodoActual) {
        Persona personaActual = nodoActual.getData();
        Lista<String> nombresHijos = personaActual.getHijos();

        for (String nombreHijo : nombresHijos) {
            String claveHijo = buscarClavePersona(nombreHijo);
            if (claveHijo != null) {
                Persona hijoPersona = tablaPersonas.obtener(claveHijo);
                if (hijoPersona != null) {
                    NodoArbol<Persona> nodoHijo = new NodoArbol<>(hijoPersona);
                    nodoActual.agregarHijo(nodoHijo);

                    // Llamada recursiva para construir los descendientes del hijo
                    construirArbolRecursivo(nodoHijo);
                }
            }
        }
    }

    private String generarClaveUnica(Persona persona) {
        String clave = persona.getNombre();
        if (persona.getNumeroNombre() != null) {
            clave += " " + persona.getNumeroNombre();
        }
        return clave;
    }

    private String buscarClavePersona(String nombre) {
        // Buscamos la clave de la persona en la tabla hash
        Lista<String> claves = tablaPersonas.obtenerTodasLasClaves();
        for (String clave : claves) {
            if (clave.startsWith(nombre)) {
                return clave;
            }
        }
        return null;
    }

    public Arbol<Persona> getArbolGenealogico() {
        return arbolGenealogico;
    }

    public HashTable<String, Persona> getTablaPersonas() {
        return tablaPersonas;
    }

    public String getNombreLinaje() {
        return nombreLinaje;
    }
}
