/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author santi
 */
import model.CuentaBancaria;

import java.util.*;
import model.CuentaAhorros;
import model.CuentaCorriente;

public class CuentaBancariaService implements ICuentaService {

    private static final Map<Integer, CuentaBancaria> cuentas = new HashMap<>();

    @Override
    public void addCuenta(CuentaBancaria cuenta) {
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta no puede ser null");
        }

        int numero = cuenta.getNumeroCuenta();
        if (cuentas.containsKey(numero)) {
            throw new IllegalArgumentException("Ya existe una cuenta con ese número: " + numero);
        }

        cuentas.put(numero, cuenta);
    }

    @Override
    public CuentaBancaria buscarPorNumero(int numeroCuenta) {
        CuentaBancaria c = cuentas.get(numeroCuenta);
        if (c == null) {
            throw new IllegalArgumentException("Cuenta no encontrada: " + numeroCuenta);
        }
        return c;
    }

    @Override
    public List<CuentaBancaria> listar() {
        List<CuentaBancaria> list = new ArrayList<>(cuentas.values());
        list.sort(Comparator.comparingInt(CuentaBancaria::getNumeroCuenta));
        return list;
    }

    @Override
    public boolean eliminar(int numeroCuenta) {
        CuentaBancaria cb = buscarPorNumero(numeroCuenta);

        try {
            if (cb != null && cb.getEstado().equalsIgnoreCase("Activo")) {
                cb.setEstado("Inactivo");
                return true;
            }

        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public void depositar(int numeroCuenta, double monto) {
        CuentaBancaria c = buscarPorNumero(numeroCuenta);
        c.depositar(monto);
    }

    @Override
    public void retirar(int numeroCuenta, double monto) {
        CuentaBancaria c = buscarPorNumero(numeroCuenta);
        c.retirar(monto);
    }

    @Override
    public double calcularCostoMensual(int numeroCuenta) {
        CuentaBancaria c = buscarPorNumero(numeroCuenta);
        return c.calcularCostoMensual();
    }

    @Override
    public void crearCuentaAhorros(int numeroCuenta, String titular, double saldo, double tasa) {
        CuentaBancaria ca = new CuentaAhorros(numeroCuenta, titular, saldo, tasa);
        addCuenta(ca);
    }

    @Override
    public void crearCuentaCorriente(int numeroCuenta, String titular, double saldo, double sobregiro, double comision) {
        CuentaBancaria cc = new CuentaCorriente(numeroCuenta, titular, saldo, sobregiro, comision);
        addCuenta(cc);
    }
}
