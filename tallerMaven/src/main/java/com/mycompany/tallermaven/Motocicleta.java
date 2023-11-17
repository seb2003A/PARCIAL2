
package com.mycompany.tallermaven;

import java.util.Date;
public class Motocicleta extends Vehiculo {
    private int cilindrada;
    protected Date horasalida;
    protected Date horaingreso;
    private Double tarifa;

 

    // Constructores, getters y setters

    // Otros métodos específicos para motocicletas

    public Motocicleta(int cilindrada, String marca, String modelo, String placa) {
        super(marca, modelo, placa);
        this.cilindrada = cilindrada;
        this.horasalida = horasalida;
        this.horaingreso = horaingreso;
        this.tarifa = tarifa;
    }


    

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Date getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(Date horasalida) {
        this.horasalida = horasalida;
    }

    public Date getHoraingreso() {
        return horaingreso;
    }

    public void setHoraingreso(Date horaingreso) {
        this.horaingreso = horaingreso;
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

    
    

    
}