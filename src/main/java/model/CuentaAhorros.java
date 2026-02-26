/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import lombok.Data;

/**
 *
 * @author jaiderclavijo
 */
@Data
public class CuentaAhorros extends CuentaBancaria implements IRendimiento {
    private double tasaInteres;       
    private double montoMinApertura;   

    public CuentaAhorros(int numeroCuenta, String titular, double saldo,
                         double tasaInteres) {
        super(numeroCuenta, titular, saldo, "activo");
        this.tasaInteres = tasaInteres;
        montoMinApertura = 200000.00;

        if (saldo < montoMinApertura) {
            throw new IllegalArgumentException("Saldo inicial menor al monto mínimo de apertura");
        }
    }
    

    
    
    @Override
    public double calcularCostoMensual() {
        
        return 0.0;
    }

   
    @Override
    public double calcularRendimiento() {
        return getSaldo() * tasaInteres;
    }
}