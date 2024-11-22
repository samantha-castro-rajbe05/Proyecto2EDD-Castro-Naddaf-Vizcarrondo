/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Persona.Persona;

/**
 *
 * @author samantha
 */
public class HashTable<K, V> {
    private class Entrada<K, V> {
        K clave;
        V valor;
        Entrada<K, V> siguiente;

        public Entrada(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
            this.siguiente = null;
        }
    }

    private Entrada<K, V>[] tabla;
    private int capacidad;

    @SuppressWarnings("unchecked")
    public HashTable(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Entrada[capacidad];
    }

    private int obtenerIndiceHash(K clave) {
        int hashCode = clave.hashCode();
        return Math.abs(hashCode) % capacidad;
    }

    public void agregar(K clave, V valor) {
        int indice = obtenerIndiceHash(clave);
        Entrada<K, V> nuevaEntrada = new Entrada<>(clave, valor);

        if (tabla[indice] == null) {
            tabla[indice] = nuevaEntrada;
        } else {
            Entrada<K, V> actual = tabla[indice];
            while (actual != null) {
                if (actual.clave.equals(clave)) {
                    actual.valor = valor; // Actualiza el valor si la clave ya existe
                    return;
                }
                if (actual.siguiente == null) {
                    break;
                }
                actual = actual.siguiente;
            }
            actual.siguiente = nuevaEntrada; // Manejo de colisiones por encadenamiento
        }
    }

    public V obtener(K clave) {
        int indice = obtenerIndiceHash(clave);
        Entrada<K, V> actual = tabla[indice];

        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        return null; // Clave no encontrada
    }

    public Lista<V> obtenerTodosLosValores() {
        Lista<V> valores = new Lista<>();
        for (int i = 0; i < capacidad; i++) {
            Entrada<K, V> actual = tabla[i];
            while (actual != null) {
                valores.agregar(actual.valor);
                actual = actual.siguiente;
            }
        }
        return valores;
    }

    public Lista<K> obtenerTodasLasClaves() {
        Lista<K> claves = new Lista<>();
        for (int i = 0; i < capacidad; i++) {
            Entrada<K, V> actual = tabla[i];
            while (actual != null) {
                claves.agregar(actual.clave);
                actual = actual.siguiente;
            }
        }
        return claves;
    }
}
