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
public class Resultado {
    
    private Candidato candidato;
    private Eleccion eleccion;

    public Resultado(Candidato candidato, Eleccion eleccion) {
        this.candidato = candidato;
        this.eleccion = eleccion;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Eleccion getEleccion() {
        return eleccion;
    }

    public void setEleccion(Eleccion eleccion) {
        this.eleccion = eleccion;
    }

    
    @Override
    public String toString() {
        return candidato + "|" + eleccion;
    }
    
    
    
}
