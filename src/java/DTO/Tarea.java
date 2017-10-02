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
public class Tarea {
    public String idTarea;
    public String descripcion;
    public String fecha;
    public String idAct;
    public String idUsu;
    public String hora;
    private Factory factory;

    public Tarea(String idUsu,String idAct, String descripcion, String fecha, String idTarea,String hora) {
        this.idUsu=idUsu;
        this.idTarea = idTarea;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idAct = idAct;
        this.hora=hora;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(String idUsu) {
        this.idUsu = idUsu;
    }

    public Tarea() {
    }

    public String getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
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

    public String getIdAct() {
        return idAct;
    }

    public void setIdAct(String idAAct) {
        this.idAct = idAAct;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
    
    @Override
    public String toString() {
        return "Descripcion : "+getDescripcion() +" Fecha limite : "+getFecha();
    }
    
}
