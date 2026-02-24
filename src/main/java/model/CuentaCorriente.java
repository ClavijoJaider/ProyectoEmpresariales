/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jaiderclavijo
 */
public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobreGiro;
    private double comision; // comisión fija mensual
    private TarjetaCredito tarjetaCredito; // asociación con D

    public CuentaCorriente(int numeroCuenta, String titular, double saldo, String estado,
                           double limiteSobreGiro, double comision, TarjetaCredito tarjetaCredito) {
        super(numeroCuenta, titular, saldo, estado);
        this.limiteSobreGiro = limiteSobreGiro;
        this.comision = comision;
        this.tarjetaCredito = tarjetaCredito;
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