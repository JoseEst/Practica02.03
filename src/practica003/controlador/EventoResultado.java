/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica003.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JDialog;
import javax.swing.JLabel;
import practica003.modelo.Candidato;
import practica003.modelo.Eleccion;
import practica003.modelo.Resultado;
import practica003.vista.VentanaResultado;

/**
 *
 * @author Jose
 */
public class EventoResultado implements ActionListener {

    private VentanaResultado ventanaResultado;
    private Candidato candidato;
    private Eleccion eleccion;

    public EventoResultado(VentanaResultado ventanaResultado) {
        this.ventanaResultado = ventanaResultado;
    }

    public VentanaResultado getVentanaResultado() {
        return ventanaResultado;
    }

    public void setVentanaResultado(VentanaResultado ventanaResultado) {
        this.ventanaResultado = ventanaResultado;
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
    public void actionPerformed(ActionEvent e) {
        try {

            int numc = this.ventanaResultado.getComboCandidato().getSelectedIndex();
            this.candidato = this.ventanaResultado.getGestionDato().getCandidatoList().get(numc);
            int nume = this.ventanaResultado.getComboEleccion().getSelectedIndex();
            this.eleccion = this.ventanaResultado.getGestionDato().getEleccionList().get(nume);

            Resultado res = new Resultado(this.candidato,this.eleccion);

            //control dato repetido
            boolean ban = true;
            for (Resultado resul : this.ventanaResultado.getGestionDato().getResultadoList()) {
                if (res.equals(resul)) {
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

                this.ventanaResultado.getGestionDato().addResultado(res);

                Object[][] datoResultado = this.ventanaResultado.cargarDatosTabla(this.ventanaResultado.getGestionDato().getResultadoList().size(), 2);
                this.ventanaResultado.setDatos(datoResultado);
                this.ventanaResultado.getModeloTabla().setDataVector(this.ventanaResultado.getDatos(), this.ventanaResultado.getEncabezado());

                //Agregar Archivo Ubicacion
                File ficheroResultado = new File("C:\\carpetaPractica03\\Resultado.txt");

                if (ficheroResultado.exists() == false) {

                    try {

                        ficheroResultado.createNewFile();

                    } catch (Exception ae) {

                        ae.printStackTrace();

                    }

                }

                try {

                    FileOutputStream escritura = new FileOutputStream(ficheroResultado, true);
                    DataOutputStream dataEscritura = new DataOutputStream(escritura);
                    dataEscritura.writeUTF(res.toString());
                    dataEscritura.close();

                } catch (Exception ae) {

                    ae.printStackTrace();

                }

            }

        } catch (NumberFormatException ae) {

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
