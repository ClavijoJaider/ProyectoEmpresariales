/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto;

import gui.GUIPrincipal;
import service.CuentaBancariaService;

/**
 *
 * @author jaiderclavijo
 */
public class Proyecto {

    public static void main(String[] args) {
        // 1. Cargar datos de prueba en el servicio compartido
        CuentaBancariaService service = new CuentaBancariaService();
        DataSeeder.cargarDatos(service);

        // 2. Abrir ventana principal
        GUIPrincipal gui = new GUIPrincipal();
        gui.setVisible(true);;
    }
}
