/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

/**
 *
 * @author samantha
 */
public class Linaje {

    private String nombreLinaje;

    public Linaje(String nombreLinaje) {
        this.nombreLinaje = nombreLinaje;
    }

    public String getNombreLinaje() {
        return nombreLinaje;
    }

    public void setNombreLinaje(String nombreLinaje) {
        this.nombreLinaje = nombreLinaje;
    }

    public String toString(){
        
        return ("El linaje seleccionado es: "+nombreLinaje);
       
    }
}
