/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jaiderclavijo
 */
public class CuentaAhorros extends CuentaBancaria implements IRendimiento {
    private double tasaInteres;       
    private double montoMinApertura;   

    public CuentaAhorros(int numeroCuenta, String titular, double saldo, String estado,
                         double tasaInteres, double montoMinApertura) {
        super(numeroCuenta, titular, saldo, estado);
        this.tasaInteres = tasaInteres;
        this.montoMinApertura = montoMinApertura;

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