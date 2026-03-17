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
     public void setCupo(double cupo) {
        if (cupo < 0) {
            throw new IllegalArgumentException("El cupo no puede ser negativo");
        }
        this.cupo = cupo;
    }

    public void setCuotaManejo(double cuotaManejo) {
        if (cuotaManejo < 0) {
            throw new IllegalArgumentException("La cuota de manejo no puede ser negativa");
        }
        this.cuotaManejo = cuotaManejo;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        if (numeroTarjeta == null || numeroTarjeta.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de tarjeta no puede estar vacío");
        }
        this.numeroTarjeta = numeroTarjeta.trim();
    }

}
