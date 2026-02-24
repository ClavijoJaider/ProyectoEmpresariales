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
public abstract class CuentaBancaria {
    
    private int numeroCuenta;
    private String titular;
    private double saldo;
    private String estado;
    
  
  public CuentaBancaria(int numeroCuenta, String titular, double saldo, String estado) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.estado = estado;
    }

  
    public abstract double calcularCostoMensual();

    public void depositar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto debe ser > 0");
        saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto debe ser > 0");
        if (monto > saldo) throw new IllegalArgumentException("Saldo insuficiente");
        saldo -= monto;
    }  
    
}
