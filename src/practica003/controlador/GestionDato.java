/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica003.controlador;

import java.util.List;
import practica003.modelo.Candidato;

/**
 *
 * @author Jose
 */
public class GestionDato {
    
    private List<Candidato> candidatoList;

    public GestionDato(List<Candidato> candidatoList) {
        this.candidatoList = candidatoList;
    }

    public List<Candidato> getCandidatoList() {
        return candidatoList;
    }
    public void setCandidatoList(List<Candidato> candidatoList) {
        this.candidatoList = candidatoList;
    }
    
    public boolean addCandidato(Candidato candidato) {
        return this.candidatoList.add(candidato);
    }
}
