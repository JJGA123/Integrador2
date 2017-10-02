/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Factory.Factory;

/**
 *
 * @author Jhon Galvis
 */
public class Cumpleaños {
    public String idCumpleaños;
    public String descripcion;
    public String fecha;
    public String idUsu;
    public String hora;

    public Cumpleaños() {
    }

    public Cumpleaños(String idCumpleaños, String descripcion, String fecha, String idUsu,String hora) {
        this.idCumpleaños = idCumpleaños;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idUsu = idUsu;
        this.hora = hora;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public String getIdCumpleaños() {
        return idCumpleaños;
    }

    public void setIdCumpleaños(String idCumpleaños) {
        this.idCumpleaños = idCumpleaños;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(String idUsu) {
        this.idUsu = idUsu;
    }
    
    @Override
    public String toString() {
        return "Descripcion : "+getDescripcion() +" Fecha limite : "+getFecha();
    }
}
