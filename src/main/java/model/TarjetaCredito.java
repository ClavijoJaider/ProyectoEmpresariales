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
public class TarjetaCredito {

    private double cupo;
    private double cuotaManejo;
    private String numeroTarjeta;

    public TarjetaCredito(double cupo, double cuotaManejo, String numeroTarjeta) {
        this.cupo = cupo;
        this.cuotaManejo = cuotaManejo;
        this.numeroTarjeta = numeroTarjeta;
    }

}
