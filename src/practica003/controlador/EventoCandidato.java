/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica003.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JDialog;
import javax.swing.JLabel;
import practica003.modelo.Candidato;
import practica003.vista.VentanaCandidato;

/**
 *
 * @author Jose
 */
public class EventoCandidato implements ActionListener
{
    private VentanaCandidato ventanaCandidato;

    public EventoCandidato(VentanaCandidato ventanaCandidato) {
        this.ventanaCandidato = ventanaCandidato;
    }

    public VentanaCandidato getVentanaCandidato() {
        return ventanaCandidato;
    }
    public void setVentanaCandidato(VentanaCandidato ventanaCandidato) {
        this.ventanaCandidato = ventanaCandidato;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try 
        {
            if (e.getSource().equals(this.ventanaCandidato.getBotonList().get(0))) 
            {
                String nombre = this.ventanaCandidato.getTxtList().get(0).getText();
                int edad = Integer.parseInt(this.ventanaCandidato.getTxtList().get(1).getText());
                String lista = this.ventanaCandidato.getTxtList().get(2).getText();

                Candidato c = new Candidato(nombre, edad, lista);

                int i = 0;
                boolean ban = true;
                for (Candidato ca : this.ventanaCandidato.getGestionDato().getCandidatoList()) 
                {
                    if(c.getNombre().equals(this.ventanaCandidato.getGestionDato().getCandidatoList().get(i).getNombre()) == true && c.getLista().equals(this.ventanaCandidato.getGestionDato().getCandidatoList().get(i).getLista()) == true) 
                    {
                        ban = false;
                        JDialog d = new JDialog();
                        d.setTitle("Error");
                        d.getContentPane().add(new JLabel("Ya exsiste"));
                        d.setSize(120, 100);
                        d.setLocation(830, 400);
                        d.setVisible(true);
                        break;
                    }
                    i++;
                }

                if (ban == true) 
                {
                    this.ventanaCandidato.getGestionDato().addCandidato(c);
                }

                Object[][] datoCandidato = this.ventanaCandidato.cargaDatosTabla(this.ventanaCandidato.getGestionDato().getCandidatoList().size(), 3);
                this.ventanaCandidato.setDatos(datoCandidato);
                this.ventanaCandidato.getModeloTabla().setDataVector(this.ventanaCandidato.getDatos(), this.ventanaCandidato.getEncabezado());
                
                File ficheroCandidato = new File("C:\\carpetaPractica03\\Candidato.txt");
                
                if (ficheroCandidato.exists() == false)
                {
                    try 
                    {
                        ficheroCandidato.createNewFile();

                    } 
                    catch(Exception ae) 
                    {
                        ae.printStackTrace();
                    }                              
                }
                try
                {
                    FileOutputStream ae = new FileOutputStream("C:\\carpetaPractica03\\Candidato.txt",false);
                    DataOutputStream b = new DataOutputStream(ae);

                    b.writeUTF(c.toString());     
                    b.close();
                }
                catch (Exception ae) 
                {
                    ae.printStackTrace();
                }                        
            }
            else if (e.getSource().equals(this.ventanaCandidato.getBotonList().get(1))) 
            {
                this.ventanaCandidato.getTxtList().get(0).setText("");
                this.ventanaCandidato.getTxtList().get(1).setText("");
                this.ventanaCandidato.getTxtList().get(2).setText("");
            }
        }
        catch (NumberFormatException ae) 
        {
            JDialog d = new JDialog();
            d.setTitle("Error");
            d.getContentPane().add(new JLabel("Casilleros incorrectos"));
            d.setSize(120, 100);
            d.setLocation(830, 400);
            d.setVisible(true);
        } 
        catch (ArrayIndexOutOfBoundsException ae2) 
        {
            JDialog d = new JDialog();
            d.setTitle("Error");
            d.getContentPane().add(new JLabel("NO se han encontrado PROVINCIAS"));
            d.setSize(320, 100);
            d.setLocation(830, 400);
            d.setVisible(true);
        }
    
    }
}
