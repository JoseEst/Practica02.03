/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica003.vista;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import practica003.controlador.EventoPrincipal;
import practica003.controlador.GestionDato;

/**
 *
 * @author Jose
 */
public class VentanaPrincipal extends JFrame
{
     private GestionDato gestionDato;
    private JDesktopPane escritorio;
    private JMenuBar barraMenu;
    private java.util.List<JMenu> menuList;
    private ArrayList<JMenuItem> menuItemList; 
    
    public VentanaPrincipal(GestionDato gD) 
    {
        super("Archivos");
        this.gestionDato = gD;
        this.setSize(800, 600);
        this.setLocation(500,250);
        this.iniciaComponentes();
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        
    }
     private void iniciaComponentes() 
    {
       this.escritorio= new JDesktopPane();
        this.barraMenu= new JMenuBar();
        this.menuList=new ArrayList<JMenu>();// llamado al array
        this.menuList.add(new JMenu("Candidato"));// ingreso de datos en el array
        this.menuList.add(new JMenu("Eleccion"));// ingreso de datos en el array
        this.menuList.add(new JMenu("Resultado"));// ingreso de datos en el array
      


        this.menuItemList= new ArrayList<JMenuItem>();
        this.menuItemList.add(new JMenuItem("Agregar Candidato"));
        
        this.menuItemList.add(new JMenuItem("Agregar Eleccion"));
       
        
        this.menuItemList.add(new JMenuItem("Agregar Resultado "));
        
        
        this.setContentPane(this.escritorio);
        this.setJMenuBar(barraMenu);
        
        this.barraMenu.add(this.menuList.get(0));
        this.menuList.get(0).add(this.menuItemList.get(0));
        
        this.barraMenu.add(this.menuList.get(1));
        this.menuList.get(1).add(this.menuItemList.get(1));
        
        this.barraMenu.add(this.menuList.get(2));
        this.menuList.get(2).add(this.menuItemList.get(2));
        
        
        
        
        this.menuItemList.get(0).addActionListener(new EventoPrincipal(this));
        this.menuItemList.get(1).addActionListener(new EventoPrincipal(this));
        this.menuItemList.get(2).addActionListener(new EventoPrincipal(this));
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenuBar getBarraMenu() {
        return barraMenu;
    }

    public void setBarraMenu(JMenuBar barraMenu) {
        this.barraMenu = barraMenu;
    }

    public List<JMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<JMenu> menuList) {
        this.menuList = menuList;
    }

    public ArrayList<JMenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(ArrayList<JMenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }
     
}
