/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

import EDD.Lista;


/**
 *
 * @author PeterNaddaf
 */
public class Persona {
    private String nombre;
    private String numeroNombre; // Por ejemplo, "First", "Second"
    private String mote; // Apodo o sobrenombre
    private String titulo;
    private String conyuge;
    private String padre;
    private Lista<String> hijos;
    private String ojos;
    private String cabello;
    private Lista<String> notas;
    private String destino; // Destino o fate

    // Constructor
    public Persona(String nombre) {
        this.nombre = nombre;
        this.hijos = new Lista<>();
        this.notas = new Lista<>();
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNumeroNombre(String numeroNombre) {
        this.numeroNombre = numeroNombre;
    }

    public String getNumeroNombre() {
        return numeroNombre;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public String getMote() {
        return mote;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setConyuge(String conyuge) {
        this.conyuge = conyuge;
    }

    public String getConyuge() {
        return conyuge;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getPadre() {
        return padre;
    }

    public Lista<String> getHijos() {
        return hijos;
    }

    public void agregarHijo(String hijo) {
        this.hijos.agregar(hijo);
    }

    public void setOjos(String ojos) {
        this.ojos = ojos;
    }

    public String getOjos() {
        return ojos;
    }

    public void setCabello(String cabello) {
        this.cabello = cabello;
    }

    public String getCabello() {
        return cabello;
    }

    public Lista<String> getNotas() {
        return notas;
    }

    public void agregarNota(String nota) {
        this.notas.agregar(nota);
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }
}
