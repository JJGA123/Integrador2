/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Jhon Galvis
 */
public class Estadistica {
    public String id;
    public String descripcion;
    public String fecha;
    public String idUsu;
    public String hora;
    public String fechaSistema;
    public String horaSistema;
    public String tipo;
    public Estadistica(String descripcion,String idUsu,String id,  String fecha,  String hora,String horaSistema,String fechaSistema,String tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idUsu = idUsu;
        this.hora = hora;
        this.fechaSistema=fechaSistema;
        this.horaSistema=horaSistema;
        this.tipo=tipo;
    }

    public Estadistica() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getFechaSistema() {
        return fechaSistema;
    }

    public void setFechaSistema(String fechaSistema) {
        this.fechaSistema = fechaSistema;
    }

    public String getHoraSistema() {
        return horaSistema;
    }

    public void setHoraSistema(String horaSistema) {
        this.horaSistema = horaSistema;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
