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
public class Compromiso2 {

    public String idCompromiso2;
    public String descripcion;
    public String fecha;
    public String idUsu;
    public String hora;
    public String tipo;
    public Compromiso2() {
    }

    public Compromiso2(String tipo,String idCompromiso2, String descripcion, String fecha, String idUsu, String hora) {
        this.tipo=tipo;
        this.idCompromiso2 = idCompromiso2;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idUsu = idUsu;
        this.hora = hora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
    public String getIdCompromiso2() {
        return idCompromiso2;
    }

    public void setIdCompromiso2(String idCompromiso2) {
        this.idCompromiso2 = idCompromiso2;
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
