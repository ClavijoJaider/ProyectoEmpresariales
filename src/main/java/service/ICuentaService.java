/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

/**
 *
 * @author santi
 */
import model.CuentaBancaria;
import java.util.List;

public interface ICuentaService {

    void addCuenta(CuentaBancaria cuenta);

    void crearCuentaAhorros(int numeroCuenta, String titular, double saldo, double tasa);

    void crearCuentaCorriente(int numeroCuenta, String titular, double saldo, double sobregiro, double comision);

    CuentaBancaria buscarPorNumero(int numeroCuenta);

    List<CuentaBancaria> listar();

    boolean eliminar(int numeroCuenta);

    void depositar(int numeroCuenta, double monto);

    void retirar(int numeroCuenta, double monto);

    double calcularCostoMensual(int numeroCuenta);

    void actualizarCuentaAhorros(int numeroCuenta, String titular, double tasaInteres);

    void actualizarCuentaCorriente(int numeroCuenta, String titular, double limiteSobreGiro, double comision);

    void asociarTarjetaCredito(int numeroCuenta, String numeroTarjeta, double cupo, double cuotaManejo);

    void actualizarTarjetaCredito(int numeroCuenta, String numeroTarjeta, double cupo, double cuotaManejo);

    void eliminarTarjetaCredito(int numeroCuenta);
}
