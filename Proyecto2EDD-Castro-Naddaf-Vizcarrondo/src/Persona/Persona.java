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
    private String numeroNombre;
    private String mote;
    private String titulo;
    private String padre;
    private Lista<String> hijos;
    private String ojos;
    private String cabello;
    private Lista<String> notas;
    private String destino;
    private String conyuge;
    
    
    public Persona(String nombre){
        this.nombre=nombre;
        this.hijos=new Lista<>();
        
    }

    public String getNumeroNombre() {
        return numeroNombre;
    }

    public void setNumeroNombre(String numeroNombre) {
        this.numeroNombre = numeroNombre;
    }

    public String getConyuge() {
        return conyuge;
    }

    public void setConyuge(String conyuge) {
        this.conyuge = conyuge;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public Lista<String> getHijos() {
        return hijos;
    }

    public void setHijos(Lista<String> hijos) {
        this.hijos = hijos;
    }

    public String getOjos() {
        return ojos;
    }

    public void setOjos(String ojos) {
        this.ojos = ojos;
    }

    public String getCabello() {
        return cabello;
    }

    public void setCabello(String cabello) {
        this.cabello = cabello;
    }

    public Lista<String> getNotas() {
        return notas;
    }

    public void setNotas(Lista<String> notas) {
        this.notas = notas;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public void agregarHijo(String hijo){
        this.hijos.Agregar(hijo);
    }
    public void agregarNota(String nota){
        this.notas.Agregar(nota);
    }
}
