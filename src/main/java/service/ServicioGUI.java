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
    
    public static void registrarGUI(ICambiable gui){
        guis.add(gui);
    }
    
    public static void eliminarGUI(ICambiable gui){
        guis.remove(gui);
    }
    
    private static void cambioEnGUI(){
        for(ICambiable gui : guis){
            gui.cambio();
        }
    }
}
