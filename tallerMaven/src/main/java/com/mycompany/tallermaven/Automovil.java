
package com.mycompany.tallermaven;
import java.util.Date;

public class Automovil extends Vehiculo {
    private int numeroPuertas;
    private Date horasalida;
    private Date horaingreso;
    private Double tarifa;

    // Constructores, getters y setters

    // Otros métodos específicos para automóviles

    public Automovil(String marca, String modelo, String placa, int numeroPuertas) {
        super(marca, modelo, placa);
        this.numeroPuertas = numeroPuertas;
    }

  
  
    
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
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