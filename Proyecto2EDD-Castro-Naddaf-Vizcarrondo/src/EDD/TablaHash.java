/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Principal.Persona;
/**
 *
 * @author vizca
 */
public class TablaHash {
    private Lista[] buckets; // Arreglo de listas que actúan como contenedores para los datos
    private int capacidad; // Número máximo de índices en la tabla

    /**
     * Constructor que inicializa la tabla hash con un tamaño máximo.
     * 
     * @param capacidad el número máximo de índices en la tabla hash
     */
    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        this.buckets = new Lista[capacidad];

        // Inicializamos cada posición con una lista vacía
        for (int i = 0; i < capacidad; i++) {
            buckets[i] = new Lista();
        }
    }
    
    public Lista[] getBuckets() {
        return buckets;
    }

    public void setBuckets(Lista[] buckets) {
        this.buckets = buckets;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    

    /**
     * Calcula el índice de la tabla hash para una clave utilizando su hashCode.
     * 
     * @param clave la clave del objeto
     * @return el índice correspondiente en el arreglo
     */
    private int calcularIndice(Object clave) {
        return Math.abs(clave.hashCode()) % capacidad;
    }
    
    /**
     * Verifica si la tabla hash está vacía (sin datos).
     * 
     * @return true si no hay elementos en la tabla, false en caso contrario
     */
    public boolean estaVacia() {
        for (int i = 0; i < capacidad; i++) {
            if (!buckets[i].isEmpty()) {
                return false; // Si al menos una lista tiene elementos, no está vacía
            }
        }
        return true; // Todas las listas están vacías
    }

    /**
     * Inserta un objeto en la tabla hash.
     * Si la clave ya existe, no realiza la inserción.
     * 
     * @param clave la clave del objeto
     * @param valor el objeto a almacenar
     */
    public void agregar(Object clave, Object valor) {
        int indice = calcularIndice(clave); // Calculamos el índice en la tabla
        Lista lista = buckets[indice]; // Obtenemos la lista correspondiente al índice

        if (buscar(clave) == null) { // Solo insertamos si no existe ya la clave
            lista.insertFinale(valor); // Insertamos al final de la lista
        }
    }

    /**
     * Busca un objeto en la tabla hash utilizando su clave.
     * 
     * @param clave la clave del objeto a buscar
     * @return el objeto encontrado, o null si no existe
     */
    public Object buscar(Object clave) {
        int indice = calcularIndice(clave); // Calculamos el índice de la clave
        Lista lista = buckets[indice]; // Obtenemos la lista correspondiente al índice

        // Iteramos sobre la lista para encontrar el objeto con la clave
        for (int i = 0; i < lista.getSize(); i++) {
            Persona persona = (Persona) lista.getValor(i);
            if (persona.getNombreUnico().equalsIgnoreCase((String) clave)) {
                return persona; // Retornamos si encontramos una coincidencia
            }
        }
        return null; // Si no se encuentra, retornamos null
    }

    /**
     * Busca todas las personas cuyo nombre contiene un texto específico.
     * 
     * @param nombre el texto a buscar en los nombres
     * @return una lista con los resultados encontrados
     */
    public Lista buscarPorNombre(String nombre) {
        Lista resultados = new Lista();

        // Recorremos cada lista en los buckets
        for (int i = 0; i < capacidad; i++) {
            Lista lista = buckets[i];

            for (int j = 0; j < lista.getSize(); j++) {
                Persona persona = (Persona) lista.getValor(j);

                // Verificamos si el mote o el nombre contiene el texto
                if (persona.getMote() != null && persona.getMote().toLowerCase().contains(nombre.toLowerCase())) {
                    resultados.insertFinale(persona);
                } else if (persona.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                    resultados.insertFinale(persona);
                }
            }
        }
        return resultados;
    }

    /**
     * Busca todas las personas que tienen un título específico.
     * 
     * @param titulo el título a buscar
     * @return una lista con las personas que tienen el título
     */
    public Lista buscarPorTitulo(String titulo) {
        Lista resultados = new Lista();

        // Recorremos cada lista en los buckets
        for (int i = 0; i < capacidad; i++) {
            Lista lista = buckets[i];

            for (int j = 0; j < lista.getSize(); j++) {
                Persona persona = (Persona) lista.getValor(j);

                // Si el título contiene el texto buscado, lo añadimos
                if (persona.getTitulo() != null && persona.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                    resultados.insertFinale(persona);
                }
            }
        }
        return resultados;
    }
    
    public Lista buscarSoloNombre(String nombre) {
        Lista resultados = new Lista();

        // Recorremos cada lista en los buckets
        for (int i = 0; i < capacidad; i++) {
            Lista lista = buckets[i];

            for (int j = 0; j < lista.getSize(); j++) {
                Persona persona = (Persona) lista.getValor(j);

                if (persona.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                    resultados.insertFinale(persona);
                }
            }
        }
        return resultados;
    }

    /**
     * Elimina todos los datos almacenados en la tabla hash.
     */
    public void vaciar() {
        for (int i = 0; i < capacidad; i++) {
            buckets[i].destruir(); // Destruir cada lista en los buckets
        }
    }

    /**
     * Muestra el contenido completo de la tabla hash.
     */
    public void imprimirTabla() {
        StringBuilder builder = new StringBuilder("Contenido de la Tabla Hash:\n");

        // Iteramos por cada índice de la tabla
        for (int i = 0; i < capacidad; i++) {
            builder.append("Índice ").append(i).append(": ");
            Lista lista = buckets[i];

            // Recorremos cada lista en el índice
            for (int j = 0; j < lista.getSize(); j++) {
                Persona persona = (Persona) lista.getValor(j);
                builder.append(persona.getNombreUnico()).append(" -> ");
            }
            builder.append("null\n");
        }

        // Imprimimos el contenido completo
        System.out.println(builder.toString());
    }
    
    

}
