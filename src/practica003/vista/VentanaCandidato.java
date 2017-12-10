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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import practica003.controlador.EventoCandidato;
import practica003.controlador.GestionDato;
import practica003.modelo.Candidato;

/**
 *
 * @author Jose
 */
public class VentanaCandidato extends JInternalFrame 
{
    
    private GestionDato gestionDato;
    private List<JLabel> etiList;
    private List<JTextField> txtList;
    private List<JButton> botonList;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private JPanel panel;
    
    public VentanaCandidato(GestionDato gestionDato) 
    {
        super("Registrar Candidato",true,true,true,true);
        this.gestionDato = gestionDato;
        this.iniciaComponente();
        this.setSize(600, 500);        
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
    public List<JTextField> getTxtList() {
        return txtList;
    }
    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }
    public List<JButton> getBotonList() {
        return botonList;
    }
    public void setBotonList(List<JButton> botonList) {
        this.botonList = botonList;
    } 
    public Object[][] getDatos() {
        return datos;
    }
    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }
    public Object[] getEncabezado() {
        return encabezado;
    }
    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }
    public JTable getTabla() {
        return tabla;
    }
    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }
    public JScrollPane getScroll() {
        return scroll;
    }
    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }
    public JPanel getPanel() {
        return panel;
    }
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    
    public void iniciaComponente()
    {
        this.etiList= new ArrayList<JLabel>();
        this.txtList= new ArrayList<JTextField>();
        this.botonList= new ArrayList<JButton>();
        JPanel panel = new JPanel(new FlowLayout());
        
        this.etiList.add(new JLabel("Nombre"));
        this.etiList.add(new JLabel("Edad"));
        this.etiList.add(new JLabel("Lista"));
        
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        
        this.botonList.add(new JButton("Guardar"));
        this.botonList.add(new JButton("Limpiar"));
        
        this.encabezado = new Object[3];               
        this.encabezado[0] = "Nombre";
        this.encabezado[1] = "Edad";
        this.encabezado[2] = "Lista";
        
        this.datos = cargaDatosTabla(this.gestionDato.getCandidatoList().size(),3);
        
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);        
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
        
        panel.add(this.etiList.get(0));
        panel.add(this.txtList.get(0));
        panel.add(this.etiList.get(1));
        panel.add(this.txtList.get(1));
        panel.add(this.etiList.get(2));
        panel.add(this.txtList.get(2));
        panel.add(this.botonList.get(0));
        panel.add(this.botonList.get(1));
        panel.add(this.scroll);
        
        this.botonList.get(0).addActionListener(new EventoCandidato(this));
        this.botonList.get(1).addActionListener(new EventoCandidato(this));
        
        this.add(panel);
    }
    
    public Object[][] cargaDatosTabla(int m, int n) 
    {
        Object[][] retorno = new Object[m][n];
        int i=0;
        for(Candidato c:this.gestionDato.getCandidatoList()) 
        {
            retorno[i][0] = c.getNombre();
            retorno[i][1] = c.getEdad();
            retorno[i][2] = c.getLista();
            i++;
        }        
        return retorno;
    }
}
