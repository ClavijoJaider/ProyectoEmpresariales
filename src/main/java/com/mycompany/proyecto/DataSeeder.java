package com.mycompany.proyecto;

import service.CuentaBancariaService;

/**
 * Carga datos genéricos de prueba al iniciar la aplicación.
 * Incluye cuentas de ahorros y corrientes con distintos perfiles.
 */
public class DataSeeder {

    public static void cargarDatos(CuentaBancariaService service) {

        // ── Cuentas de Ahorros ────────────────────────────────────────────────
        // numeroCuenta, titular, saldo (mínimo 200.000), tasaInteres (decimal)
        service.crearCuentaAhorros(1001, "Ana Milena Torres",    500_000.00,  0.04);
        service.crearCuentaAhorros(1002, "Carlos Hernández",    1_200_000.00, 0.035);
        service.crearCuentaAhorros(1003, "Lucía Ramírez",         800_000.00, 0.045);
        service.crearCuentaAhorros(1004, "Pedro Gómez",           350_000.00, 0.03);
        service.crearCuentaAhorros(1005, "Valentina Ospina",    2_500_000.00, 0.05);

        // ── Cuentas Corrientes ────────────────────────────────────────────────
        // numeroCuenta, titular, saldo, limiteSobreGiro, comision
        service.crearCuentaCorriente(2001, "Empresa Soluciones S.A.S", 5_000_000.00, 2_000_000.00, 15_000.00);
        service.crearCuentaCorriente(2002, "Juan David Morales",       1_800_000.00,   500_000.00,  8_000.00);
        service.crearCuentaCorriente(2003, "Inversiones del Norte",   10_000_000.00, 5_000_000.00, 25_000.00);
        service.crearCuentaCorriente(2004, "María Claudia Ríos",         400_000.00,   200_000.00,  5_000.00);
        service.crearCuentaCorriente(2005, "Comercial Andina Ltda",    3_700_000.00, 1_500_000.00, 12_000.00);

        System.out.println("[DataSeeder] ✔ 10 cuentas de prueba cargadas correctamente.");
    }
}
