/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica003.vista;

import java.util.ArrayList;
import java.util.List;
import practica003.controlador.GestionDato;
import practica003.modelo.Candidato;
import practica003.modelo.Eleccion;
import practica003.modelo.Resultado;

/**
 *
 * @author Jose
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        List<Candidato> candidato = new ArrayList<Candidato>();
        List<Eleccion> eleccion = new ArrayList<Eleccion>();
        List<Resultado> resultado = new ArrayList<Resultado>();
        GestionDato gD = new GestionDato(candidato,eleccion,resultado);
        VentanaPrincipal VentPri = new VentanaPrincipal (gD);// TODO code application logic here
    }
    
}
