/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica003.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import practica003.vista.VentanaCandidato;
import practica003.vista.VentanaPrincipal;

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
       if (e.getSource().equals(this.VentPri.getMenuItemList().get(0))) 
        {
            System.err.println("Agregar Ventana Candidato");
            VentanaCandidato VenCan = new VentanaCandidato(this.VentPri.getGestionDato());
            VenCan.setVisible(true);
            this.VentPri.getEscritorio().add(VenCan);
          
        }
        
        if (e.getSource().equals(this.VentPri.getMenuItemList().get(1))) 
        {
            System.err.println("Agregar Ventana Eleccion"); 
          
        }
        if (e.getSource().equals(this.VentPri.getMenuItemList().get(2))) 
        {
             System.err.println("Agregar Ventana Resultado"); 
          
        }
    }

    public VentanaPrincipal getVentPri() {
        return VentPri;
    }

    public void setVentPri(VentanaPrincipal VentPri) {
        this.VentPri = VentPri;
    }
    
    
}
