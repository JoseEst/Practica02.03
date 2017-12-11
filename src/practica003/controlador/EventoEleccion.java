/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica003.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import javax.swing.JDialog;
import javax.swing.JLabel;
import practica003.modelo.Eleccion;
import practica003.vista.VentanaEleccion;

/**
 *
 * @author Jose
 */
public class EventoEleccion implements ActionListener {
    
    private VentanaEleccion ventanaEleccion;

    public EventoEleccion(VentanaEleccion ventanaEleccion) {
        this.ventanaEleccion = ventanaEleccion;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        try {

            String fecha = this.ventanaEleccion.getTxtList().get(0).getText();
            
            Eleccion el = new Eleccion(fecha);

            //control dato repetido
            boolean ban = true;
            for (Eleccion e : this.ventanaEleccion.getGestionDato().getEleccionList()) {
                if (el.getFecha().equals(e.getFecha()) == true) {
                    ban = false;
                    JDialog d = new JDialog();
                    d.setTitle("Error");
                    d.getContentPane().add(new JLabel("       Esta Eleccion ya ha sido ingresada."));
                    d.setSize(320, 100);
                    d.setLocation(830, 400);
                    d.setVisible(true);
                    break;
                }
            }
            if (ban == true) {
                
                this.ventanaEleccion.getGestionDato().addEleccion(el);

                Object[][] datoEleccion = this.ventanaEleccion.cargaDatosTabla(this.ventanaEleccion.getGestionDato().getEleccionList().size(), 1);
                this.ventanaEleccion.setDatos(datoEleccion);
                this.ventanaEleccion.getModeloTabla().setDataVector(this.ventanaEleccion.getDatos(), this.ventanaEleccion.getEncabezado());

                //Agregar Archivo Ubicacion
                File ficheroParroquia = new File("C:\\carpetaPractica02\\Eleccion.txt");

                if (ficheroParroquia.exists() == false) {

                    try {

                        ficheroParroquia.createNewFile();

                    } catch (Exception e) {

                        e.printStackTrace();

                    }

                }

                try {

                    FileOutputStream escritura = new FileOutputStream(ficheroParroquia, true);
                    DataOutputStream dataEscritura = new DataOutputStream(escritura);
                    dataEscritura.writeUTF(el.toString());
                    dataEscritura.close();

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        } catch (NumberFormatException e) {

            JDialog d = new JDialog();
            d.setTitle("Error");
            d.getContentPane().add(new JLabel("   Los casilleros NO se han llenado correctamente."));
            d.setSize(320, 100);
            d.setLocation(830, 400);
            d.setBackground(Color.RED);
            d.setVisible(true);

        }
        
    }
    
    
    
}
