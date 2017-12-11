/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica003.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import practica003.vista.VentanaCandidato;
import practica003.vista.VentanaEleccion;
import practica003.vista.VentanaPrincipal;
import practica003.vista.VentanaResultado;

/**
 *
 * @author Jose
 */
public class EventoPrincipal implements ActionListener
{
    private VentanaPrincipal VentPri;

    public EventoPrincipal(VentanaPrincipal VentPri) {
        this.VentPri = VentPri;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        File carpeta = new File("C:\\carpetaPractica03");
        if(carpeta.exists() == false) {
            carpeta.mkdir();
        }
        
       if (e.getSource().equals(this.VentPri.getMenuItemList().get(0))) 
        {
            System.err.println("Agregar Ventana Candidato");
            VentanaCandidato VenCan = new VentanaCandidato(this.VentPri.getGestionDato());
            VenCan.setVisible(true);
            this.VentPri.getEscritorio().add(VenCan);
          
        }
        
        if (e.getSource().equals(this.VentPri.getMenuItemList().get(1))) 
        {
            
            VentanaEleccion vE = new VentanaEleccion(this.VentPri.getGestionDato());
            vE.setVisible(true);
            this.VentPri.getEscritorio().add(vE);
          
        }
        if (e.getSource().equals(this.VentPri.getMenuItemList().get(2))) 
        {
            System.err.println("Agregar Ventana Resultado"); 
            VentanaResultado vR = new VentanaResultado(this.VentPri.getGestionDato());
            vR.setVisible(true); 
            this.VentPri.getEscritorio().add(vR);
            
          
        }
    }

    public VentanaPrincipal getVentPri() {
        return VentPri;
    }

    public void setVentPri(VentanaPrincipal VentPri) {
        this.VentPri = VentPri;
    }
    
    
}
