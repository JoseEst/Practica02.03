/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica003.controlador;

import java.util.List;
import practica003.modelo.Candidato;
import practica003.modelo.Eleccion;

/**
 *
 * @author Jose
 */
public class GestionDato {
    
    private List<Candidato> candidatoList;
    private List<Eleccion> eleccionList;

    public GestionDato(List<Candidato> candidatoList, List<Eleccion> eleccionList) {
        this.candidatoList = candidatoList;
        this.eleccionList = eleccionList;
    }

    public List<Candidato> getCandidatoList() {
        return candidatoList;
    }
    public void setCandidatoList(List<Candidato> candidatoList) {
        this.candidatoList = candidatoList;
    }

    public List<Eleccion> getEleccionList() {
        return eleccionList;
    }

    public void setEleccionList(List<Eleccion> eleccionList) {
        this.eleccionList = eleccionList;
    }
    
    public boolean addCandidato(Candidato candidato) {
        return this.candidatoList.add(candidato);
    }
    
    public boolean addEleccion(Eleccion eleccion) {
        return this.eleccionList.add(eleccion);
    }
    
}
