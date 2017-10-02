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
public class Entrevista {
    public String idEntrevista;
    public String descripcion;
    public String fecha;
    public String idUsu;
    public String hora;

    public Entrevista(String descripcion,String idUsu,String idEntrevista,  String fecha,  String hora) {
        this.idEntrevista = idEntrevista;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idUsu = idUsu;
        this.hora = hora;
    }

    public Entrevista() {
    }

    public String getIdEntrevista() {
        return idEntrevista;
    }

    public void setIdEntrevista(String idEntrevista) {
        this.idEntrevista = idEntrevista;
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
