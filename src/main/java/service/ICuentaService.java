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
    void eliminar(int numeroCuenta);
    void depositar(int numeroCuenta, double monto);
    void retirar(int numeroCuenta, double monto);
    

  
    double calcularCostoMensual(int numeroCuenta);
}
