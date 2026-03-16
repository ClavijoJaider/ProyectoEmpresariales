/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import gui.ICambiable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaiderclavijo
 */
public class ServicioGUI {
    
    private static List <ICambiable> guis = new ArrayList<>();
    private static ServicioGUI sgui;
    
    private ServicioGUI(){
        
    }
    
    public static ServicioGUI getInstance(){
        if (sgui == null){
            sgui = new ServicioGUI();
            return sgui;
        }
        
        return sgui;
    }
    
    public  void registrarGUI(ICambiable gui){
        guis.add(gui);
    }
    
    public  void eliminarGUI(ICambiable gui){
        guis.remove(gui);
    }
    
    public  void cambioEnGUI(){
        for(ICambiable gui : guis){
            gui.cambio();
        }
    }
}
