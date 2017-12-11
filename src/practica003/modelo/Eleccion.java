/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica003.modelo;

/**
 *
 * @author Jose
 */
public class Eleccion {
    
    private String fecha;

    public Eleccion(String fecha) {
        this.fecha = fecha;
    } 
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return fecha;
    }
    
}
