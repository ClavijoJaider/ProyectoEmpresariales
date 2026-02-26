/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import lombok.Data;
import lombok.Getter;

/**
 *
 * @author jaiderclavijo
 */
@Data
@Getter
public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobreGiro;
    private double comision; 
    private TarjetaCredito tarjetaCredito; 

    public CuentaCorriente(int numeroCuenta, String titular, double saldo,
                           double limiteSobreGiro, double comision) {
        super(numeroCuenta, titular, saldo, "activo");
        if(limiteSobreGiro >= 0)
        {
            this.limiteSobreGiro = limiteSobreGiro;
        } else
        {
            throw new IllegalArgumentException("el limite de sobre giro no puede ser menor que 0");
        }
        if(comision >= 0)
        {
            this.comision = comision;
        } else
        {
            throw new IllegalArgumentException("La comision no puede ser menor que 0");
        }
        tarjetaCredito = null;
    }
    
    

    // SOBRESCRITURA (polimorfismo)
    @Override
    public double calcularCostoMensual() {
        double costo = comision;
        if (tarjetaCredito != null) costo += tarjetaCredito.getCuotaManejo();
        return costo;
    }

    // Retiro con sobregiro permitido
    @Override
    public void retirar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto debe ser > 0");

        double saldoActual = getSaldo();
        double maxDisponible = saldoActual + limiteSobreGiro;

        if (monto > maxDisponible) {
            throw new IllegalArgumentException("Excede el saldo + límite de sobregiro");
        }
        setSaldo(saldoActual - monto); // puede quedar negativo
    }
}