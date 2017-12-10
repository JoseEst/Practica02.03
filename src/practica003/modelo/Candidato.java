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
public class Candidato {
    private String nombre;
    private int edad;
    private String lista;

    public Candidato(String nombre, int edad, String lista) {
        this.nombre = nombre;
        this.edad = edad;
        this.lista = lista;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getLista() {
        return lista;
    }
    public void setLista(String lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "|Candidato|" + "\t |" + nombre + "\t |" + edad + "\t |" + lista;
    }
    
    
}
