/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica003.vista;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import practica003.controlador.EventoResultado;
import practica003.controlador.GestionDato;
import practica003.modelo.Candidato;
import practica003.modelo.Eleccion;
import practica003.modelo.Resultado;

/**
 *
 * @author Jose
 */
public class VentanaResultado extends JInternalFrame {
  
    private GestionDato gestionDato;
    private List<JLabel> etiList;
    private List<JButton> botonList;
    private JPanel panel;
    private JComboBox comboCandidato;
    private JComboBox comboEleccion;
    private JScrollPane scroll;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private Object[] encabezado;
    private Object[][] datos;
    
    public VentanaResultado (GestionDato gestionDato){
        
        super("Ventana Resultado",true,true,true,true);
        this.gestionDato=gestionDato;
        this.setSize(600,500);
        this.iniciaComponente();
        
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public List<JLabel> getEtiList() {
        return etiList;
    }

    public void setEtiList(List<JLabel> etiList) {
        this.etiList = etiList;
    }

    public List<JButton> getBotonList() {
        return botonList;
    }

    public void setBotonList(List<JButton> botonList) {
        this.botonList = botonList;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public JComboBox getComboCandidato() {
        return comboCandidato;
    }

    public void setComboCandidato(JComboBox comboCandidato) {
        this.comboCandidato = comboCandidato;
    }

    public JComboBox getComboEleccion() {
        return comboEleccion;
    }

    public void setComboEleccion(JComboBox comboEleccion) {
        this.comboEleccion = comboEleccion;
    }
    
    
    
      public void iniciaComponente(){
        
        this.etiList = new ArrayList<JLabel>();
        this.botonList = new ArrayList<JButton>();
        this.comboCandidato = new JComboBox(this.cargarCombo());
        this.comboEleccion = new JComboBox(this.cargarCombo2());
        JPanel panel = new JPanel(new FlowLayout());
        
        this.etiList.add(new JLabel("Candidato"));
        this.etiList.add(new JLabel("Eleccion"));
        
        this.botonList.add(new JButton("Guardar"));
        
        this.encabezado = new Object[2];
        this.encabezado[0] = "Canditato";
        this.encabezado[1] = "Eleccion";
        
        this.datos = cargarDatosTabla(this.gestionDato.getResultadoList().size(),2);
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);        
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
        
        panel.add(this.etiList.get(0));
        panel.add(this.comboCandidato);
        panel.add(this.etiList.get(1));
        panel.add(this.comboEleccion);
        panel.add(this.botonList.get(0));
        panel.add(this.scroll);
        
       this.botonList.get(0).addActionListener(new EventoResultado(this));
       
        
        this.add(panel);
        
        
        
        
    }
    
    public String[] cargarCombo() 
    {       
        String[] retorno = new String[this.gestionDato.getCandidatoList().size()];
        int i=0;
        for(Candidato c: this.gestionDato.getCandidatoList()) 
        {
            retorno[i] = this.getGestionDato().getCandidatoList().get(i).getNombre();
            i++;
        }
        return retorno;
    }
    
    public String[] cargarCombo2() 
    {       
        String[] retorno = new String[this.gestionDato.getEleccionList().size()];
        int i=0;
        for(Eleccion e: this.gestionDato.getEleccionList()) 
        {
            retorno[i] = this.getGestionDato().getEleccionList().get(i).getFecha();
            i++;
        }
        return retorno;
    }
    
    public Object[][] cargarDatosTabla(int m, int n) 
    {
        Object[][] retorno = new Object[m][n];
        int i=0;
        for(Resultado r:this.gestionDato.getResultadoList()) 
        {
            retorno[i][0] = r.getCandidato().getNombre();
            retorno[i][1] = r.getEleccion();
            i++;
        }        
        return retorno;
    }
    

}

    



